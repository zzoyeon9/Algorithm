package Implementation;

import java.io.*;
import java.util.*;

public class RobotCleaner_bj14503 {

    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private String[][] map;
    static private int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static private int count = 1;

    public void solution(int x, int y, int D) {

        map[x][y] = "2";

        for (int i = 0; i < 4; i++) {
            D = (D + 3) % 4;
            int nx = x + dir[D][0];
            int ny = y + dir[D][1];
            ////3-2
            if (map[nx][ny].equals("0")) {
                count++;
                solution(nx, ny, D);
                return;
            }
        }
        int nx = x + dir[(D+2)%4][0];
        int ny = y + dir[(D+2)%4][1];

        if(!map[nx][ny].equals("1"))
            solution(nx, ny, D);
    }


    public static void main(String[] args) throws IOException {
        RobotCleaner_bj14503 m = new RobotCleaner_bj14503();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken();
            }
        }
        m.solution(x, y, D);
        System.out.println(count);
    }
}