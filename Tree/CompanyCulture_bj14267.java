package Tree;

import java.io.*;
import java.util.*;

public class CompanyCulture_bj14267 {

    private static int n, m, i, w, root;
    private static ArrayList<Integer>[] tree;
    private static int[] compliment;

    public static void func() {

        dfs(root);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(compliment[i] + " ");

        System.out.println(sb.toString());
    }

    private static void dfs(int node) {

        if (tree[node].isEmpty())
            return;

        for (int i = 0; i < tree[node].size(); i++) {
            compliment[tree[node].get(i)] += compliment[node];
            dfs(tree[node].get(i));
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n + 1];
        st = new StringTokenizer(br.readLine());
        compliment = new int[n + 1];


        for (int i = 0; i <= n; i++)
            tree[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
                continue;
            }

            tree[parent].add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            CompanyCulture_bj14267.i = Integer.parseInt(st.nextToken());
            CompanyCulture_bj14267.w = Integer.parseInt(st.nextToken());
            compliment[CompanyCulture_bj14267.i] += CompanyCulture_bj14267.w;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}