package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeSearch_bj2178 {

    private static int N, M;
    private static int[][] maze;
    private static boolean[][] isVisit;
    private static Queue<Integer> que = new LinkedList<>();

    public static void bfs() {
        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int [][] dist = new int[N+1][M+1];
        dist[1][1]=1;

        while(!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx >= 1 && ny >= 1 && nx <= M && ny <= N && maze[ny][nx]==1) {
                    if (!isVisit[ny][nx]) {
                        que.add(nx);
                        que.add(ny);
                        isVisit[ny][nx]=true;
                        dist[ny][nx] = dist[y][x] + 1;
                    }
                }
            }
        }
        System.out.println(dist[N][M]);
    }

    public static void func() {
        que.add(1);
        que.add(1);
        bfs();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N + 1][M + 1];
        isVisit = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= M; j++)
                maze[i][j] = Integer.parseInt(temp.split("")[j-1]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}