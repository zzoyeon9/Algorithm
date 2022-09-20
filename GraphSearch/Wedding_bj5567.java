package GraphSearch;

import java.io.*;
import java.util.*;

public class Wedding_bj5567 {

    private static int n,m;
    private static boolean [] isVisit;
    private static ArrayList<ArrayList<Integer>> friendsList = new ArrayList<>();

    public static void func() {

        Queue<Integer> que = new LinkedList<>();
        int [] dist = new int[n+1];
        que.add(1);
        isVisit[1] = true;

        while (!que.isEmpty()) {
            int one = que.poll();

            for (int i = 0; i < friendsList.get(one).size(); i++) {
                int nextOne = friendsList.get(one).get(i);

                if (isVisit[nextOne])
                    continue;

                isVisit[nextOne]=true;
                dist[nextOne] = dist[one] + 1;
                que.add(nextOne);
            }
        }

        int count=0;
        for(int i=0;i<dist.length;i++)
            if(dist[i]>2 || dist[i]==0)
                continue;
            else
                count++;

        System.out.println(count);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); m = Integer.parseInt(br.readLine());
        isVisit = new boolean[n+1];

        for(int i=0;i<=n;i++)
            friendsList.add(new ArrayList<>());

        StringTokenizer st;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friendsList.get(a).add(b);
            friendsList.get(b).add(a);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}
