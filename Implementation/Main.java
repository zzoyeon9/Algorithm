package Implementation;

import java.util.*;
import java.io.*;

public class Main {

    private static StringTokenizer st;
    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static List<String[]> turnList;
    private static String[][] map;
    private static int N;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main m = new Main();

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        map = new String[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = "0";
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = "1";
        }

        int L = Integer.parseInt(br.readLine());
        turnList = new ArrayList<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            turnList.add(new String[2]);
            turnList.get(i)[0] = st.nextToken();
            turnList.get(i)[1] = st.nextToken();
        }

        int D = 0;
        int r = 1, c = 1;

        m.solution(D,r,c);
        System.out.println(count);
    }

    private void solution(int D, int r, int c) {

        Queue<String> snake = new LinkedList<>();
        snake.add(String.valueOf(r) + "," + String.valueOf(c));

        while (true) {
            count++;
            r += dir[D][0];
            c += dir[D][1];
            //여기서부터 시작
            if (snake.contains(r + "," + c) || r < 1 || c<1 || r>N || c>N)//자기 몸이나 벽에 닿을 경우
                return;

            snake.add(r + "," + c);

            if (map[r][c].equals("1"))//꼬리 위치는 그대로고 대가리를 늘리고 사과 없애기
                map[r][c] = "0";
            else
                snake.poll();//꼬리 한칸 당기기 (무조건 대갈통 방향이 아니라 과거에 대가리가 어디를 보고있었는지 기억해놓고 거기에 맞춰서 한칸 줄여야함

            if (!turnList.isEmpty() && count == Integer.parseInt(turnList.get(0)[0])) {
                if (turnList.get(0)[1].equals("L"))
                    D--;
                else
                    D++;
                turnList.remove(0);
            }
            if(D<0)
                D=3;
            else if(D>=4)
                D=0;
        }
    }
}