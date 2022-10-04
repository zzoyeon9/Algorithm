package Tree;

import java.io.*;
import java.util.*;

public class RealEstateFight_bj20364 {

    private static int N, Q;
    private static ArrayList<Integer>[] tree;
    private static int[] ducks;
    private static boolean[] isUsed;
    private static StringBuilder sb = new StringBuilder();

    public static void func() {

        for (int i = 0; i < Q; i++)
            if (isPossible(ducks[i]) && !isUsed[ducks[i]])
                isUsed[ducks[i]] = true;

        System.out.println(sb.toString());
    }

    private static boolean isPossible(int target) {

        ArrayList<Integer> passList = new ArrayList<>();
        passList.add(target);

        while (target != 1) {
            target/=2;
            passList.add(target);
        }

        while(passList.size()!=0){
            int cur = passList.get(passList.size() - 1);

            if (isUsed[cur]) {
                sb.append(cur+"\n");
                return false;
            }
            passList.remove(passList.size()-1);
        }
        sb.append(0 + "\n");
        return true;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        isUsed = new boolean[N + 1];
        ducks = new int[Q];

        for (int i = 1; i <= N; i++)
            tree[i] = new ArrayList<>();

        for (int i = 2; i <= N; i++)
            insert(i);

        for (int i = 0; i < Q; i++) {
            ducks[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void insert(int i) {
        if (i == 1)
            return;

        tree[i].add(i / 2);
        tree[i / 2].add(i);
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}
