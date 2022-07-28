package BinarySearching.ParametricSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BudgetManagement_bj6236 {

    private static int N,M,K;
    private static int [] usedMoneys;

    public static void func() {

        int left=0, right = 1000000000;

        for(int i=0;i<N;i++)
            left = Math.max(left, usedMoneys[i]);

        while(left<=right){
            int tempK = (left+right)/2;
            int sum=tempK, count=1;

            for(int i=0;i<N;i++) {
                if (sum - usedMoneys[i] >= 0)
                    sum -= usedMoneys[i];
                else {
                    count++;
                    sum = tempK - usedMoneys[i];
                }
            }
            if(count <= M) {
                K = tempK;
                right = tempK - 1;
            }
            else
                left = tempK + 1;
        }
        System.out.println(K);
    }

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        usedMoneys = new int[N];

        for(int i=0;i<N;i++)
            usedMoneys[i] = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException{
        input();
        func();
    }
}