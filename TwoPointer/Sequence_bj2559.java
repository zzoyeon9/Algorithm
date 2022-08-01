package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence_bj2559 {

    private static int N,K;
    private static int [] seqs;

    public static void func() {
        int right=1, sum=0, answer=Integer.MIN_VALUE;
        for(int left=1;left+K-1<=N;left++){
            sum-=seqs[left-1];

           while(right<=left+K-1)
                sum+=seqs[right++];

           answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        seqs = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++)
            seqs[i] = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {

        input();
        func();
    }
}