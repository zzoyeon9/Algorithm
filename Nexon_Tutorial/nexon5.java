package Nexon_Tutorial;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /* * Complete the 'minCostPath' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. WEIGHTED_INTEGER_GRAPH g
     *  2. INTEGER x
     *  3. INTEGER y



     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     **/


    private static int [] dist;
    private static Queue<Integer> queue = new LinkedList<>();
    private static ArrayList<ArrayList<Edge>> graph;
    private static boolean [] isVisit;

    public static void bfs(int startNode) {

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            for(int i=0;i<graph.get(curNode).size();i++){
                if(isVisit[graph.get(curNode).get(i).v])
                    continue;
                queue.add(graph.get(curNode).get(i).v);
                dist[graph.get(curNode).get(i).v] = dist[graph.get(startNode).get(curNode).w];
                isVisit[graph.get(curNode).get(i).v] = true;

            }
        }
    }
    public static int minCostPath(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight, int x, int y) {

        graph = new ArrayList<>();
        isVisit = new boolean[gNodes];

        for(int i=0;i<=gFrom.size();i++)
            graph.add(new ArrayList<Edge>());

        for(int i=0;i<gFrom.size();i++) {
            Edge edge = new Edge(gTo.get(i), gWeight.get(i));
            graph.get(gFrom.get(i)).add(edge);
            edge = new Edge(gFrom.get(i), gWeight.get(i));
            graph.get(gTo.get(i)).add(edge);
        }
        //bfs를 통해 1에서부터 x, y의 각각 비용을 계산하여 더 가까운것부터 시작
        int startNode = 1;
        queue.add(startNode);
        isVisit[startNode]=true;
        bfs(1);
//            if(dist[x]>dist[y])
//            bfs2(1,x);
//            bfs2(x,y);
//            bfs2(y,gNodes);
        return 0;
    }
}
class Edge {
    public Integer w;
    public Integer v;

    public Edge(Integer w, Integer v) {
        this.w = w;
        this.v = v;
    }


}
public class nexon5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int y = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.minCostPath(gNodes, gFrom, gTo, gWeight, x, y);
        System.out.println(result);
    }
}
