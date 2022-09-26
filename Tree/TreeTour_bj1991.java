package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeTour_bj1991 {

    private static int N;
    private static int [][] adj;
    private static StringBuilder sb;

    public static void func() {
        sb = new StringBuilder();
        pre(0);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        in(0);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        post(0);
        System.out.println(sb.toString());
    }

    private static void post(int root) {
        if(adj[root][0]!=-1)
            post(adj[root][0]);
        if(adj[root][1]!=-1)
            post(adj[root][1]);
        sb.append((char)(root+'A'));
    }

    private static void in(int root) {

        if(adj[root][0]!=-1)
            in(adj[root][0]);
        sb.append((char)(root+'A'));
        if(adj[root][1]!=-1)
            in(adj[root][1]);
    }

    private static void pre(int root) {
        sb.append((char)(root+'A'));
        if(adj[root][0]!=-1)
        pre(adj[root][0]);
        if(adj[root][1]!=-1)
        pre(adj[root][1]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int [N][N];

        StringTokenizer st;
        for(int i=0;i<adj.length;i++){
            st = new StringTokenizer(br.readLine());
            int cur = (int)(st.nextToken().charAt(0)) - 'A';
            
            for(int j=0;j<2;j++){
                char ch = st.nextToken().charAt(0);

                if(ch == '.')
                    adj[cur][j]=-1;
                else
                    adj[cur][j]=ch-'A';
            }

        }

    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}
