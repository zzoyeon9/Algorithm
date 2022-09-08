package GraphSearch;

import java.util.Scanner;

public class NumofConElements_bj11724 {

    private static int N,M;
    private static int [][] G;
    private static boolean[][] isVisit;

    public static void dfs(int vertex) {

        for(int i=1;i<=N;i++)
            if(!isVisit[vertex][i] && G[vertex][i]==1) {
                isVisit[vertex][i]=true;
                dfs(i);
            }
    }

    public static boolean isInit(int v) {
        for(int i=1;i<=N;i++)
            if(G[v][i]==1 && isVisit[v][i])
                return false;

        return true;
    }

    public static void func() {
        int count=0;
        for(int i=1;i<=N;i++){
            if(isInit(i)){
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine(); // 6 5

        N = Integer.parseInt(temp.split(" ")[0]); M = Integer.parseInt(temp.split(" ")[1]);
        G = new int[N+1][N+1]; isVisit = new boolean[N+1][N+1];

        int u,v;
        for(int i=0;i<M;i++) {
            temp = sc.nextLine();
            u = Integer.parseInt(temp.split(" ")[0]); v = Integer.parseInt(temp.split(" ")[1]);
            G[u][v] = 1;
            G[v][u] = 1;
        }
    }

    public static void main(String[] args) {
        input();
        func();
    }
}