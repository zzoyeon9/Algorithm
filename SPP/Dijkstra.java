import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {

    HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start){
        //초기화
        HashMap<String, Integer> distances = new HashMap<>();
        Edge node;
        ArrayList<Edge> nodelist;

        for (String key : graph.keySet()){
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorQueue = new PriorityQueue<Edge>();
        priorQueue.add(new Edge(start, distances.get(start)));
        //
        //우선순위 큐에서 값(간선)을 하나씩 빼서 해당 간선 가중치를 distances에 넣기
        while(priorQueue.size()>0) {
            //큐에서 간선 빼기
            node = priorQueue.poll();
            //해당 간선의 목적지 노드 및 가중치 임시 변수에 저장
            String curVertax = node.vertax;
            int curDis = node.distance;

            //뺀 간선으로부터 목적지 노드까지의 가중치 정보를 distances에 넣기
            if(distances.get(curVertax)<curDis)
                continue;

            nodelist = graph.get(curVertax);//distances.put(curVertax, curDis);

            for(int i=0;i<nodelist.size();i++){
                Edge curNode = nodelist.get(i);
                String targetVer = curNode.vertax;
                int targetDis = curNode.distance;
                //해당 간선의 목적지 노드가 이미 가중치 배열에 들어와있다면

                if(curDis + targetDis <distances.get(targetVer)) {
                    distances.put(targetVer, curDis + targetDis);
                    priorQueue.add(new Edge(targetVer,curDis + targetDis));//priorQueue.add(curNode); 이거 테스트하고 넘어가
                }


            }
        }
        return distances;
    }


    public static void main(String[] args) {

        Dijkstra inst = new Dijkstra();

        inst.graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge("B",8), new Edge("C",1), new Edge("D",2))));
        inst.graph.put("B", new ArrayList<Edge>());
        inst.graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge("B",5), new Edge("D",2))));
        inst.graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge("E",3), new Edge("F",5))));
        inst.graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge("F",1))));
        inst.graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge("A",5))));

        System.out.println(inst.dijkstraFunc(inst.graph, "A"));


    }
}
