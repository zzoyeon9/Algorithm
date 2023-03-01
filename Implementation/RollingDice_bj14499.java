package Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class RollingDice_bj14499 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int [][] dir = {{}, {0,1}, {0,-1}, {-1,0}, {1,0}};
    private static int [] dice = {0,0,0,0,0,0};
    private static int [][] map;
    private static int N,M;
    private static int x;
    private static int y;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x =  Integer.parseInt(st.nextToken());
        y =  Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        RollingDice_bj14499 m = new RollingDice_bj14499();
        m.solution(K);
    }

    private void solution(int K) throws IOException {

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            roll(dir);
        }
    }

    private void roll(int dir) {

        if(x + RollingDice_bj14499.dir[dir][0] >=0 && y + RollingDice_bj14499.dir[dir][1] >= 0 && x + RollingDice_bj14499.dir[dir][0] < N && y + RollingDice_bj14499.dir[dir][1] < M) {
            x += RollingDice_bj14499.dir[dir][0];
            y += RollingDice_bj14499.dir[dir][1];
        }
        else return;

        int tmp = dice[5];

        switch (dir) {
            case 1: dice[5] = dice[3];
                dice[3] = dice[2];
                dice[2] = dice[1];
                dice[1] = tmp;
                break;
            case 2: dice[5] = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[3];
                dice[3] = tmp;
                break;
            case 3: dice[5] = dice[4];
                dice[4] = dice[2];
                dice[2] = dice[0];
                dice[0] = tmp;
                break;
            case 4: dice[5] = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[4];
                dice[4] = tmp;
                break;
        }

        if(map[x][y]!=0) {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }else {
            map[x][y] = dice[5];
        }
        System.out.println(dice[2]);
    }
}