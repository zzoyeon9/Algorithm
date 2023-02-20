package Implementation;

import java.util.*;
import java.io.*;

import static java.lang.Math.max;

public class Tetromino_bj14500 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int [][] dir = {{0,-1}, {0,1}, {-1,0}, {1,0}};
    private static boolean [][] isVisit;
    private static int [][] map;
    private static int N,M;
    private static int max = -1;

    public void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isVisit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!isVisit[i][j]) {
                    isVisit[i][j] = true;
                    dfs(i,j,1, map[i][j]);
                    fuckShape(i,j);
                    isVisit[i][j] = false;
                }
            }
        }
        System.out.println(max);
    }

    private void fuckShape(int r, int c) {
        int fuckMax = -1;

        for(int i = 0; i < 4; i++) {
            if(r - 1 >= 0 && c - 1 >= 0 && c + 1 < M) {
                fuckMax = max(fuckMax, map[r][c] + map[r][c-1] + map[r][c+1] + map[r-1][c]);
                max = max(max, fuckMax);
            }
            if(c-1 >= 0 && c+1 < M && r+1 < N) {
                fuckMax = max(fuckMax, map[r][c] + map[r][c-1] + map[r][c+1] + map[r+1][c]);
                max = max(max, fuckMax);
            }
            if(r-1 >= 0 && c+1 < M && r+1 < N) {
                fuckMax = max(fuckMax, map[r][c] + map[r-1][c] + map[r][c+1] + map[r+1][c]);
                max = max(max, fuckMax);
            }
            if(c-1 >= 0 && r-1 >= 0 && r+1 < N) {
                fuckMax = max(fuckMax, map[r-1][c] + map[r][c-1] + map[r][c] + map[r+1][c]);
                max = max(max, fuckMax);
            }
        }
    }

    private void dfs(int r, int c, int count, int sum) {

        if(count == 4) {
            max = max(max, sum);
        }
        else {
            for(int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M && !isVisit[nr][nc]) {
                    isVisit[nr][nc] = true;
                    dfs(nr, nc, count+1, sum + map[nr][nc]);
                    isVisit[nr][nc] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Tetromino_bj14500 m = new Tetromino_bj14500();
        m.solution();
    }
}