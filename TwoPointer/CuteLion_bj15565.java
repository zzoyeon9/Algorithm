package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuteLion_bj15565 {

    private static int N,K;
    private static int [] dolls;


    public static void func() {

        int right=1, num=0, count=1,answer=Integer.MAX_VALUE;

        for(int left=1;left<=N;left++){
            if(dolls[left-1]==1)
                num--;
            count--;

            while(num<K && right <=N) {
                if (dolls[right++] == 1)
                    num++;
                count++;
            }
            if(num>=K)
                answer = Math.min(count, answer);
        }
        if(answer==Integer.MAX_VALUE)
            answer=-1;
        System.out.print(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        dolls = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++)
            dolls[i] = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException{
        input();
        func();
    }
}