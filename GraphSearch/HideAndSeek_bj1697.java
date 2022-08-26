package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek_bj1697 {

    private static int N, K;
    private static Queue<Integer> que = new LinkedList<>();
    private static int[] sec = new int[100001];

    public static void func(int n) {
        boolean[] isVisit = new boolean[100001];
        int[] dir = {1, 2, -1};

        que.add(n);
        isVisit[n] = true;

        while (!que.isEmpty()) {
            int v = que.poll();
            int nv;
            for (int i = 0; i < 3; i++) {
                if (i == 1)
                    nv = v * dir[i];
                else
                    nv = v + dir[i];
                if ((nv >= 0 && nv <= 100000) && !isVisit[nv]) {
                    que.add(nv);
                    isVisit[nv] = true;
                    sec[nv] = sec[v] + 1;
                }
            }
        }
        System.out.println(sec[K]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        input();
        func(N);
    }
}
