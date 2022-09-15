package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class WiseKnight_bj18404 {

    private static int N, M, sx, sy;
    private static String[][] map;
    private static boolean[][] isVisit;
    private static int[][] dist;
    private static Queue<Integer> que = new LinkedList<>();
    private static Queue<Integer> knightSpot = new LinkedList<>();

    public static void func(int startX, int startY) {

        int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        que.add(startX);
        que.add(startY);
        isVisit[startY][startX] = true;

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

                for (int i = 0; i < 8; i++) {
                    int nx = x + dir[i][1];
                    int ny = y + dir[i][0];

                    if (nx <= 0 || nx > N || ny <= 0 || ny > N)
                        continue;
                    if (isVisit[ny][nx])
                        continue;

                    isVisit[ny][nx] = true;
                    dist[ny][nx] = dist[y][x] + 1;
                    que.add(nx);
                    que.add(ny);
                }
        }
        while(!knightSpot.isEmpty()) {
            int x = knightSpot.poll();
            int y = knightSpot.poll();

            System.out.print(dist[y][x]+ " ");
        }
    }

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        map = new String[N+1][N+1];
        dist = new int[N+1][N+1];
        isVisit = new boolean[N+1][N+1];

        input = br.readLine();
        sx = Integer.parseInt(input.split(" ")[0]);
        sy = Integer.parseInt(input.split(" ")[1]);

        for (int i = 0; i < M; i++) {
            input = br.readLine();
            int x = Integer.parseInt(input.split(" ")[0]);
            int y = Integer.parseInt(input.split(" ")[1]);
            knightSpot.add(x); knightSpot.add(y);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        func(sx, sy);
    }
}