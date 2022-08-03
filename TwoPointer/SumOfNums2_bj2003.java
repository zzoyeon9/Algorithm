package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNums2_bj2003 {

    private static int N,M;
    private static int [] seqs;

    public static void func() {

        int L=0, R=0, sum=0, count=0; //L, R 정하기

        while(R<N){                 //M보다 작거나 같을때까지 R 증가
            sum+=seqs[R];

            if(sum==M)              //M과 같아지면 카운트++
               count++;

            while(sum>M && L<N) { //M보다 커지는순간 R스탑 L 이동 시작
                sum -= seqs[L++];
                if(sum==M)          //M과 같아지면 카운트++
                    count++;
            }
            R++;                    //다시 M보다 작아지면 L스탑 R 다시 이동 시작
        }
        System.out.println(count);
    }

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
