import java.util.*;

public class Dfs {



    public void dfs(HashMap<String, ArrayList<String>> graph, String firstNode){

        Queue<String> visited = new LinkedList();
        Stack<String> waiting = new Stack<>();
        int count=0;

        if(graph.isEmpty()){
            System.out.println("Nothing");
            return;
        }
        waiting.add(firstNode);
        while(!waiting.isEmpty()){
            String targetNode = waiting.pop();
            count++;
            if(!visited.contains(targetNode)) {
                visited.add(targetNode);
                waiting.addAll(graph.get(targetNode));
                System.out.print(targetNode + " ");
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> graph = new HashMap<>();

        graph.put("A", new ArrayList<>(Arrays.asList("B","C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        Dfs a = new Dfs();
        a.dfs(graph, "A");

    }
}
