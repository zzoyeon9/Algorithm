import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;
public class Kruskal {

    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    public static void main(String[] args) {

        ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edges> edges = new ArrayList<>();
        edges.add(new Edges(7, "A", "B"));
        edges.add(new Edges(5, "A", "D"));
        edges.add(new Edges(8, "B", "C"));
        edges.add(new Edges(9, "B", "D"));
        edges.add(new Edges(7, "B", "E"));
        edges.add(new Edges(5, "C", "E"));
        edges.add(new Edges(7, "D", "E"));
        edges.add(new Edges(6, "D", "F"));
        edges.add(new Edges(8, "F", "E"));
        edges.add(new Edges(11, "F", "G"));
        edges.add(new Edges(9, "E", "G"));


        Kruskal a = new Kruskal();
        System.out.println(a.kruFunc(vetices, edges));
    }
    public String find(String node){
        if(parent.get(node) != node) {
             parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public void union(String nodeV, String nodeU){
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        if(rank.get(root1) > rank.get(root2))
            parent.put(root2, root1);
        else {
            parent.put(root1, root2);
            if(rank.get(root1)==rank.get(root2))
                rank.put(root2,rank.get(root2)+1);
        }
    }

    public void makeSet(String node){
        parent.put(node,node);
        rank.put(node,0);
    }
    public ArrayList<Edges> kruFunc(ArrayList<String> vetices, ArrayList<Edges> edges){
        ArrayList<Edges> resultList = new ArrayList<>();
        Edges currentEdge;

        //1. init

        for (int i=0;i<vetices.size();i++)
            makeSet(vetices.get(i));

        //2. sorting by weight

        Collections.sort(edges);

        for(int i=0;i<edges.size();i++){
            currentEdge = edges.get(i);
            if(find(currentEdge.nodeV) != find(currentEdge.nodeU)) {
                union(currentEdge.nodeV, currentEdge.nodeU);
                resultList.add(currentEdge);
            }
        }
        return resultList;
    }
}

class Edges implements Comparable<Edges> {
    public int weight;
    public String nodeV;
    public String nodeU;

    public Edges(int weight, String nodeV, String nodeU){
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }
    @Override
    public int compareTo(Edges edge){
        return this.weight - edge.weight;
    }

}
