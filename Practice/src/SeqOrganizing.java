package Practice.src;

import java.util.Scanner;

public class SeqOrganizing {
    static private int [] solArr; //
    static private int [] result;
    static private int N;

    public static void func(){

        int min = 1001;
        int minIdx=0;
        int count=0;
        for(int j=0;j<N;j++) {
            for (int i = 0; i < N; i++)
                if (min > solArr[i]) {
                    min = solArr[i];

                    minIdx = i;
                }
            result[minIdx]=count++;
            solArr[minIdx] = 1001;
            min = Integer.MAX_VALUE;
            minIdx = Integer.MIN_VALUE;
        }
    }

    public static void Output(){

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++)
            sb.append(result[i]+" ");
        System.out.println(sb);
    }

    public static void Input(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        solArr = new int[N];
        result = new int[N];

        for(int i=0;i<N;i++)
            solArr[i]=sc.nextInt();
    }

    public static void main(String[] args) {
        Input();
        func();
        Output();
    }
}
