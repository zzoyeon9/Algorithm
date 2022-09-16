package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Virus_bj2606 {

    private static int comNum, coupleNum;
    private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private static boolean[] isVisit;

    public static void dfs(int node) {
        for (int i = 0; i < tree.get(node).size(); i++) {
            int nextNode = tree.get(node).get(i);

            if (isVisit[tree.get(node).get(i)])
                continue;

            isVisit[nextNode] = true;
            dfs(nextNode);
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        comNum = Integer.parseInt(br.readLine());
        coupleNum = Integer.parseInt(br.readLine());
        isVisit = new boolean[comNum + 1];

        for (int i = 0; i <= comNum; i++)
            tree.add(new ArrayList<>());

        StringTokenizer st;

        for (int i = 0; i < coupleNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        isVisit[1] = true;
        dfs(1);
        int count = -1;

        for (int i = 0; i < isVisit.length; i++)
            if (isVisit[i])
                count++;
        if (count == -1)
            System.out.println(0);
        else
            System.out.println(count);
    }
}