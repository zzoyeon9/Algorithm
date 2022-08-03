package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CombiningArray_bj11728 {

    private static int N,M;
    private static int [] A,B;

    public static void func() {

        Arrays.sort(A); Arrays.sort(B);
        int [] answer = new int[N+M];
        int aL=0, bL=0, index=0;

        while(aL<N && bL<M)
            if(A[aL] < B[bL])
                answer[index++] = A[aL++];
            else
                answer[index++] = B[bL++];

        while(bL<M)
                answer[index++] = B[bL++];
        while(aL<N)
                answer[index++] = A[aL++];

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<answer.length;i++)
            sb.append(answer[i] + " ");

        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N]; B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            A[i]=Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)
            B[i]=Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException{
        input();
        func();
    }
}