package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSandBFS_bj1260 {

    private static int N,M,V;
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean [] isVisited;
    private static Queue<Integer> que = new LinkedList<>();
    private static StringBuilder sb;

    public static void dfs(Integer v) {

        isVisited[v] = true;
        sb.append(v + " ");
        for(int i=0;i<graph.get(v).size();i++){
            if(isVisited[graph.get(v).get(i)])
                continue;
            dfs(graph.get(v).get(i));
        }
    }

    public static void bfs(Integer v) {
        sb.append(v + " ");
        for(int i=0;i<graph.get(v).size();i++) {
            if(isVisited[graph.get(v).get(i)])
                continue;
            isVisited[graph.get(v).get(i)]=true;
            que.add(graph.get(v).get(i));
        }
        if(!que.isEmpty())
            bfs(que.poll());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for(int i=0;i<=N;i++)
            graph.add(new ArrayList<>());
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            Integer v1 = Integer.parseInt(st.nextToken());
            Integer v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        for(int i=1;i<=N;i++)
        Collections.sort(graph.get(i));

        sb = new StringBuilder();
        isVisited = new boolean[N+1];
        dfs(V);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        isVisited = new boolean[N+1];
        isVisited[V] = true;
        que.add(V);
        bfs(que.poll());
        System.out.println(sb.toString());
    }
}