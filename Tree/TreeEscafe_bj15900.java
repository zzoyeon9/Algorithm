package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TreeEscafe_bj15900 {

    private static int N,a,b;
    private static ArrayList<Integer> [] adj;
    private static int sum_leaf_depth=0;

    public static void func(int node, int pre, int depth) {
        if(node != 1 && adj[node].size()==1)
            sum_leaf_depth+=depth;

        for(int i=0;i<adj[node].size();i++)
            if(adj[node].get(i)!=pre)
                func(adj[node].get(i),node,depth+1);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];

        for(int i=0;i<=N;i++)
            adj[i] = new ArrayList<>();

        for(int i=0;i<N-1;i++) {
            String input = br.readLine();
            int a = Integer.parseInt(input.split(" ")[0]);
            int b = Integer.parseInt(input.split(" ")[1]);
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        func(1,-1,0);
        if(sum_leaf_depth%2!=0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
