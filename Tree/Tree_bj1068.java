package Tree;

import java.io.*;
import java.util.*;

public class Tree_bj1068 {

    private static int N,removeNode,root;
    private static ArrayList<Integer> [] tree;
    private static int [] leafNum;

    public static void func(int removeNode) {
        if(removeNode==root) {
            System.out.println("0");
            return;
        }

        for(int i=0;i<tree.length;i++)
            if(tree[i].contains(removeNode)){
                tree[i].remove(tree[i].indexOf(removeNode));
            }

        dfs(root);

        System.out.println(leafNum[root]);
    }

    public static void dfs(int node) {

        if(tree[node].isEmpty()) {
            leafNum[node] = 1;
            return;
        }
        for(int i=0;i<tree[node].size();i++) {
            dfs(tree[node].get(i));
            leafNum[node] += leafNum[tree[node].get(i)];
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        leafNum = new int[N];

        for (int i = 0; i < N; i++)
            tree[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
                continue;
            }

            tree[parent].add(i);
        }
        removeNode = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        input();
        func(removeNode);
    }
}