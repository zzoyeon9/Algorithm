package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int T, N, M, K;
    private static int field[][];
    private static boolean isVisited[][];
    private static Queue<Integer> que = new LinkedList();
    private static int [] answer;

    public static void bfs() {
        int [][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while(!que.isEmpty()) {
            int x = que.poll(); int y = que.poll();
            for(int i=0;i<4;i++){
                int nx = x + dir[i][0]; int ny = y + dir[i][1];
                if((nx>=0 && ny>=0) && (nx<M && ny<N))
                    if(field[ny][nx]==1  && !isVisited[ny][nx]) {
                        isVisited[ny][nx] = true;
                        que.add(nx);
                        que.add(ny);
                    }
            }
        }
    }

    public static void func(int answer) {

        for(int y=0;y<N;y++)
            for(int x=0;x<M;x++){
                if(field[y][x]==1 && !isVisited[y][x]) {
                    answer++;
                    isVisited[y][x]=true;
                    que.add(x); que.add(y);
                    bfs();
                }
            }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        answer = new int[T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            field = new int[N][M];
            isVisited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }
            func(answer[i]);
        }
    }
}