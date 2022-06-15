import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AdvancedPrim {

    public ArrayList<Path> advancedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode) {
        ArrayList<Path> result = new ArrayList<>(); //결과물이 담길 리스트
        PriorityQueue<AdvancedEdge> sortedAdjNodes = new PriorityQueue<>(); //탐색할 노드(엣지)가 들어있는 우선순위 큐
        HashMap<String, String> mstPath = new HashMap<>(); //각각의 노드의 목적지 노드가 어딘인지 저장해놓기 위한 해시맵
        HashMap<String, Integer> linkedEdges = new HashMap<>(); //인접 목적지 노드 및 해당 노드로 가는 엣지의 가중치가 담긴 해시맵
        HashMap<String, AdvancedEdge> keysObj = new HashMap<>(); // 우선 순위 큐에 들어가있는 노드의 가중치 변경 시, 삭제하기 위해 해당 노드의 정보를 담아놓기 위한 해시맵
        AdvancedEdge edgeObj, poppedEdge, linkedEdge;
        int totalWeight=0;

        //init
        for (String key : graph.keySet()){
            if(key == startNode){
                edgeObj = new AdvancedEdge(key, 0);
                mstPath.put(key, key);
            }else{
                edgeObj = new AdvancedEdge(key, Integer.MAX_VALUE);
                mstPath.put(key, null);
            }
            sortedAdjNodes.add(edgeObj);
            keysObj.put(key,edgeObj);
        }

        while(sortedAdjNodes.size()>0){
            poppedEdge = sortedAdjNodes.poll();
            keysObj.remove(poppedEdge.node);

            result.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
            totalWeight += poppedEdge.weight;

            linkedEdges = graph.get(poppedEdge.node); // 타겟 노드의 인접 노드 및 간선(해쉬맵) 저
            for (String adjacentNode : linkedEdges.keySet()){
                if(keysObj.containsKey(adjacentNode)){
                    linkedEdge = keysObj.get(adjacentNode);

                    if(linkedEdges.get(adjacentNode)< linkedEdge.weight) {
                        linkedEdge.weight = linkedEdges.get(adjacentNode);
                        mstPath.put(adjacentNode, poppedEdge.node);

                        sortedAdjNodes.remove(linkedEdge);
                        sortedAdjNodes.add(linkedEdge);
                    }
                }
            }
        }
        System.out.println(totalWeight);
        return result;
    }


    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<>();

        HashMap<String, Integer> edges = new HashMap<>();

        edges.put("B", 7);
        edges.put("D", 5);
        mygraph.put("A", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 7);
        edges.put("D", 9);
        edges.put("C", 8);
        edges.put("E", 7);
        mygraph.put("B", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 8);
        edges.put("E", 5);
        mygraph.put("C", edges);

        edges = new HashMap<String, Integer>();
        edges.put("A", 5);
        edges.put("B", 9);
        edges.put("E", 7);
        edges.put("F", 6);
        mygraph.put("D", edges);

        edges = new HashMap<String, Integer>();
        edges.put("B", 7);
        edges.put("C", 5);
        edges.put("D", 7);
        edges.put("F", 8);
        edges.put("G", 9);
        mygraph.put("E", edges);

        edges = new HashMap<String, Integer>();
        edges.put("D", 6);
        edges.put("E", 8);
        edges.put("G", 11);
        mygraph.put("F", edges);

        edges = new HashMap<String, Integer>();
        edges.put("E", 9);
        edges.put("F", 11);
        mygraph.put("G", edges);

        AdvancedPrim inst = new AdvancedPrim();

        System.out.println(inst.advancedPrimFunc(mygraph, "A"));
    }

}

class AdvancedEdge implements Comparable<AdvancedEdge> {

    public String node;
    public int weight;

    public AdvancedEdge(String node, int weight){
        this.node = node;
        this.weight = weight;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.node + ")";
    }

    @Override
    public int compareTo(AdvancedEdge edge){
        return this.weight - edge.weight;
    }
}

class Path {
    public String node1;
    public String node2;
    public int weight;

    public Path(String node1, String node2, int weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public String toString(){
        return "(" + this.node1 + ", " + this.node2 + ", " + this.weight + ")";
    }
}