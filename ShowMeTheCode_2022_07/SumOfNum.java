package Practice.src;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfNum {

    private static int N;
    private static int[] A, B;
    private static boolean[] isVisited;
    private static long answer=0;

    public static void func() {

            for(int i=0;i<N;i++){//시작 지점
                int tempAsum = 0, tempBsum = 0;

                for(int j=i;j<N;j++){//더하는 개수
                    tempAsum += A[j];
                    tempBsum += B[j];
                    if(tempAsum==tempBsum && tempAsum!=0)
                        answer++;
                }//N=10^5
            }
            System.out.println(answer);
    }


    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        A = new int[N];
        B = new int[N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        for (int i = 0; i < N; i++)
            B[i] = sc.nextInt();
    }

    public static void main(String[] args) {
        input();
        isVisited[0]=true;
        func();
    }
}
