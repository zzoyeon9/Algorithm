package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindTreeParents_bj11725 {

    private static int N;
    private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private static boolean [] isVisit;
    private static int [] answer;

    public static void dfs(int node) {

        for(int i=0;i<tree.get(node).size();i++) {
            if (isVisit[tree.get(node).get(i)])
                continue;

            isVisit[tree.get(node).get(i)]=true;
            answer[tree.get(node).get(i)] = node;
            dfs(tree.get(node).get(i));
        }
    }

    public static void func() {

        answer = new int[N+1];
        isVisit = new boolean[N+1];

        dfs(1);
        for(int i=2;i<=N;i++)
            System.out.println(answer[i]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<=N;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            String temp = br.readLine();
            int node1 = Integer.parseInt(temp.split(" ")[0]);
            int node2 = Integer.parseInt(temp.split(" ")[1]);
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}
