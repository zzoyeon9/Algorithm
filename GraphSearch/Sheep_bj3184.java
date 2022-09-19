package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sheep_bj3184 {

    private static int R, C;
    private static String[][] map;
    private static boolean[][] isVisit;
    private static int sheepNum, wolfNum;


    public static void dfs(int y, int x) {
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for (int i = 0; i < 4; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C)
                continue;
            if (isVisit[ny][nx])
                continue;

            if (map[ny][nx].equals("#"))
                continue;

            else if (map[ny][nx].equals("v"))
                wolfNum++;
            else if (map[ny][nx].equals("o"))
                sheepNum++;

            isVisit[ny][nx] = true;
            dfs(ny, nx);
        }
    }

    public static void func() {
        int sheepSum=0, wolfSum=0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sheepNum = 0;
                wolfNum = 0;

                if (isVisit[i][j] || map[i][j].equals("#"))
                    continue;

                if (isVisit[i][j] || map[i][j].equals("v"))
                    wolfNum++;
                else if (isVisit[i][j] || map[i][j].equals("o"))
                    sheepNum++;

                isVisit[i][j]=true;
                dfs(i, j);

                if(wolfNum>=sheepNum)
                    wolfSum+=wolfNum;
                else
                    sheepSum+=sheepNum;
            }
        }
        System.out.println(sheepSum + " " + wolfSum);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        isVisit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().split("");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}