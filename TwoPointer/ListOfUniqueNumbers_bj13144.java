package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_bj13144 {

    private static int[] seq;
    private static int[] isUsed = new int[100001];

    public static void func() {

        long answer=0;
       for(int left=0, right=-1;left< seq.length;left++) {

            while(right+1< seq.length && isUsed[seq[right+1]]==0)
                isUsed[seq[++right]] = 1;

            answer+=right-left+1;
           isUsed[seq[left]]=0;
       }
        System.out.println(answer);
    }

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            seq[i]=Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}