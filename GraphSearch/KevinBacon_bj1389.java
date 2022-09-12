package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KevinBacon_bj1389 {

    private static int N,M;
    private static ArrayList<ArrayList<Integer>> relations = new ArrayList<>();
    private static Queue<Integer> que;
    private static boolean [] isVisit;
    private static int [] answers;
    private static int [] kevinBacon;

    public static void bfs(int startUser) {
        isVisit[startUser]=true;
        kevinBacon[startUser]=0;

        while(!que.isEmpty()){
            int thisUser = que.poll();

            for(int i=0;i<relations.get(thisUser).size();i++) {
                int newUser = relations.get(thisUser).get(i);

                if (isVisit[newUser])
                    continue;

                que.add(newUser);
                isVisit[newUser]=true;
                kevinBacon[newUser]=kevinBacon[thisUser]+1;
            }
        }
        int sum=0;

        for(int i=1;i<=N;i++) {
            if (i == startUser)
                continue;
            sum += kevinBacon[i];
        }
        answers[startUser] = sum;
    }

    public static void func() {

        for(int i=1;i<=N;i++) {
            que  = new LinkedList<>();
            isVisit = new boolean[N+1];
            kevinBacon = new int[N+1];
            que.add(i);
            bfs(i);
        }

        int answer=-1;
        int answerKevinBacon=5001;
        for(int i=1;i<=N;i++)
            if(answerKevinBacon>answers[i]) {
                answer = i;
                answerKevinBacon = answers[i];
            }


        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();

        N = Integer.parseInt(temp.split(" ")[0]); M = Integer.parseInt(temp.split(" ")[1]);
        answers = new int[N+1];

        for(int i=0;i<=N;i++)
            relations.add(new ArrayList<>());

        for(int i=0;i<M;i++) {
            String temp2 = br.readLine();
            int A = Integer.parseInt(temp2.split(" ")[0]);
            int B = Integer.parseInt(temp2.split(" ")[1]);
            relations.get(A).add(B);
            relations.get(B).add(A);
        }


    }
    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}
