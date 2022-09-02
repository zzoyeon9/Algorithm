package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int R, C;
    private static String[][] map;
    private static boolean[][] isVisit;
    private static int Sx, Sy, Dx, Dy;
    private static Queue<Integer> waterQue = new LinkedList<>();

    public static void func() {
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int[][] sec = new int[R][C];
        int[][] wsec = new int[R][C];

        Queue<Integer> que = new LinkedList<>();

        que.add(Sx);
        que.add(Sy);
        isVisit[Sy][Sx] = true;

        while (!waterQue.isEmpty()) {

            int wx = waterQue.poll();
            int wy = waterQue.poll();

            for (int i = 0; i < 4; i++) {
                int nwx = wx + dir[i][0];
                int nwy = wy + dir[i][1];
                if ((nwx >= 0 && nwy >= 0) && (nwx < C && nwy < R))
                    if (!isVisit[nwy][nwx] && map[nwy][nwx].equals(".")) {
                        wsec[nwy][nwx] = wsec[wy][wx] + 1;
                        waterQue.add(nwx);
                        waterQue.add(nwy);
                        isVisit[nwy][nwx] = true;
                    }
            }
        }
        isVisit = new boolean[R][C];

        while (!que.isEmpty()) {
            int sx = que.poll();
            int sy = que.poll();

            for (int i = 0; i < 4; i++) {
                int nsx = sx + dir[i][0];
                int nsy = sy + dir[i][1];
                if (nsx >= 0 && nsy >= 0 && nsx < C && nsy < R)
                    if ((sec[sy][sx] + 1 < wsec[nsy][nsx] | map[nsy][nsx].equals("D") | (wsec[nsy][nsx] == 0 && !map[nsy][nsx].equals("*") && !map[nsy][nsx].equals("X"))) && !isVisit[nsy][nsx]) {
                        que.add(nsx);
                        que.add(nsy);
                        isVisit[nsy][nsx] = true;
                        sec[nsy][nsx] = sec[sy][sx] + 1;
                    }
            }
        }
        if (sec[Dy][Dx] == 0)
            System.out.println("KAKTUS");
        else
            System.out.println(sec[Dy][Dx]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        isVisit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
                if (map[i][j].equals("S")) {
                    Sx = j;
                    Sy = i;
                } else if (map[i][j].equals("D")) {
                    Dx = j;
                    Dy = i;
                } else if (map[i][j].equals("*")) {
                    int Wx = j;
                    int Wy = i;
                    waterQue.add(Wx);
                    waterQue.add(Wy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}
