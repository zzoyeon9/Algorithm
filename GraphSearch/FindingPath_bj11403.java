package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingPath_bj11403 {

    private static int N;
    private static String [][] G;
    private static boolean[] isVisit;
    private static int [][] answer;


    public static void dfs(int init, int vertex) {

        for(int i=0;i<G[vertex].length;i++)
            if(!isVisit[i] && G[vertex][i].equals("1")) {
                isVisit[i]=true;
                answer[init][i]=1;
                dfs(init, i);
            }
    }

    public static void func() {
        for(int i=0;i<N;i++){
            isVisit = new boolean[N];
            dfs(i, i);
        }
        for(int y=0;y<N;y++) {
            for (int x = 0; x < N; x++)
                System.out.print(answer[y][x] + " ");
            System.out.println();
        }

    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        G = new String[N][N];
        answer = new int[N][N];

        for(int i=0;i<N;i++)
            G[i]=br.readLine().split(" ");
    }

    public static void main(String[] args) throws IOException{
        input();
        func();
    }


}
