package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CalculatingDegreeOfKinship_bj2644 {

    private static int n, m;
    private static int targetOne, targetTheOther;
    private static ArrayList<ArrayList<Integer>> relations = new ArrayList<>();
    private static Queue<Integer> que = new LinkedList<>();
    private static boolean[] isVisit;
    private static int[] dist;

    public static void func() {
        que.add(targetOne);
        isVisit[targetOne] = true;

        while (!que.isEmpty()) {
            int one = que.poll();

            for (int i = 0; i < relations.get(one).size(); i++) {
                int nextOne = relations.get(one).get(i);

                if (isVisit[nextOne])
                    continue;

                que.add(nextOne);
                isVisit[nextOne] = true;
                dist[nextOne] = dist[one] + 1;
            }
        }
        if (dist[targetTheOther] == 0)
            System.out.println(-1);
        else
            System.out.println(dist[targetTheOther]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isVisit = new boolean[n + 1];
        dist = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        targetOne = Integer.parseInt(st.nextToken());
        targetTheOther = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++)
            relations.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int one = Integer.parseInt(st.nextToken());
            int theOther = Integer.parseInt(st.nextToken());

            relations.get(one).add(theOther);
            relations.get(theOther).add(one);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}
