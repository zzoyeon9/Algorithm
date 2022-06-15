import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim {

    PriorityQueue<Edges> sortedAdjacentEdges = new PriorityQueue<>();



    public ArrayList<Edges> primFunc(String startNode, ArrayList<Edges> edges){
        Edges currentEdge;
        ArrayList<String> connectedNodes = new ArrayList<>();//fixed
        ArrayList<Edges> curNodeEdgeList;//fixing
        ArrayList<Edges> result = new ArrayList<>();//fixed
        HashMap<String, ArrayList<Edges>> graph = new HashMap<>();//fixed

        //init
        for(int i=0;i< edges.size();i++){
            currentEdge = edges.get(i);
            if(!graph.containsKey(currentEdge.nodeV))
                graph.put(currentEdge.nodeV, new ArrayList<Edges>());
            if(!graph.containsKey(currentEdge.nodeU))
                graph.put(currentEdge.nodeU, new ArrayList<Edges>());
        }
        for(int i=0;i< edges.size();i++){
            currentEdge = edges.get(i);
            curNodeEdgeList = graph.get(currentEdge.nodeV);
            curNodeEdgeList.add(new Edges(currentEdge.weight, currentEdge.nodeV, currentEdge.nodeU));
            curNodeEdgeList = graph.get(currentEdge.nodeU);
            curNodeEdgeList.add(new Edges(currentEdge.weight, currentEdge.nodeU, currentEdge.nodeV));
        }


        connectedNodes.add(startNode);
        curNodeEdgeList = graph.getOrDefault(startNode, new ArrayList<Edges>());

        for(int i=0;i<curNodeEdgeList.size();i++)
            sortedAdjacentEdges.add(curNodeEdgeList.get(i));

        while(sortedAdjacentEdges.size()>0){
            Edges poppedEdge = sortedAdjacentEdges.poll();

            if(!connectedNodes.contains(poppedEdge.nodeU)) {//Node's Cycle inspection
                connectedNodes.add(poppedEdge.nodeU);

                result.add(new Edges(poppedEdge.weight, poppedEdge.nodeV, poppedEdge.nodeU));

                ArrayList<Edges> adjacentNodeEdges = graph.getOrDefault(poppedEdge.nodeU, new ArrayList<Edges>());

                for(int i=0; i<adjacentNodeEdges.size(); i++) {
                    currentEdge = adjacentNodeEdges.get(i);
                    if (!connectedNodes.contains(currentEdge.nodeU))
                        sortedAdjacentEdges.add(currentEdge);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {

      Prim inst = new Prim();
      ArrayList<Edges> myEdges = new ArrayList<>();
        myEdges.add(new Edges(7, "A", "B"));
        myEdges.add(new Edges(5, "A", "D"));
        myEdges.add(new Edges(8, "B", "C"));
        myEdges.add(new Edges(9, "B", "D"));
        myEdges.add(new Edges(7, "D", "E"));
        myEdges.add(new Edges(5, "C", "E"));
        myEdges.add(new Edges(7, "B", "E"));
        myEdges.add(new Edges(6, "D", "F"));
        myEdges.add(new Edges(8, "E", "F"));
        myEdges.add(new Edges(9, "E", "G"));
        myEdges.add(new Edges(11, "F", "G"));
        System.out.println(inst.primFunc("A", myEdges));

    }

}


