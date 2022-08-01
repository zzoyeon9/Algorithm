package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence_bj2559 {

    private static int N,K;
    private static int [] seqs;

    public static void func() {
        int left=0, answer=Integer.MIN_VALUE;
        while(left+K<=N){
            int sum=0, count=0;

           for(int i=left;i<left+K;i++)
               sum +=seqs[i];

            if(sum > answer)
                answer = sum;

            left++;
        }
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        seqs = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            seqs[i] = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {

        input();
        func();
    }
}
