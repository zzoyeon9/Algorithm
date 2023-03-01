package Implementation;

import java.util.*;
import java.io.*;

public class BabyShark_bj16236 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static Queue<Integer> que;
    private static boolean [][] isVisit;
    private static int[][] map;
    private static int tall = 2;
    private static int count=0;
    private static int N;
    private static int eatD=Integer.MAX_VALUE;
    private static int eatStack = 0;
    private static int r,c;
    private int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BabyShark_bj16236 m = new BabyShark_bj16236();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    r = i;
                    c = j;
                    map[i][j] = 0;
                }
                else if(map[i][j] > 0 ) {
                    count++;
                }
            }
        }
        int answer = 0;

        while(count > 0) {
            int temp = count;
            m.solution();

            if(temp == count)
                break;

            answer += eatD;
        }
        System.out.println(answer);
    }

    private void solution() {

        int eatR = Integer.MAX_VALUE, eatC = Integer.MAX_VALUE;
        eatD = Integer.MAX_VALUE;

        que = new LinkedList<>();
        que.add(r);
        que.add(c);
        que.add(0);
        isVisit = new boolean[N][N];

        while(!que.isEmpty()) {
            int r = que.poll();
            int c = que.poll();
            int dist = que.poll();

            if(dist >= eatD) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr >= 0 && nc >= 0 && nr < N && nc < N && !isVisit[nr][nc] && map[nr][nc] <= tall) {
                    if(map[nr][nc] != 0 && map[nr][nc]< tall) {
                        if(eatR > nr) {
                            eatR = nr;
                            eatC = nc;
                            eatD = dist + 1;
                        }
                        else if(eatR == nr) {
                            if(eatC > nc) {
                                eatC = nc;
                            }
                        }
                    }
                    isVisit[nr][nc] = true;
                    que.add(nr);
                    que.add(nc);
                    que.add(dist+1);
                }
            }
        }
        if(eatR < Integer.MAX_VALUE) {
            map[eatR][eatC] = 0;
            count--;
            eatStack++;

            if(eatStack == tall) {
                tall++;
                eatStack=0;
            }
            r = eatR;
            c = eatC;
        }
    }
}