package Practice.src;

import java.util.Scanner;

public class SubSequence {

    static private int N, S, count=0;
    static private int [] seq;
    static private boolean [] isUsed;

    public static void Func(int n, int sum) {//코어 로직

        if (n == N) {
            if (sum == S)
                count++;
        } else {
            Func(n + 1, sum);
            isUsed[n] = true;
            Func(n + 1, sum + seq[n]);
        }
    }

    public static void Input(){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); S = sc.nextInt();

        isUsed = new boolean[N];
        seq = new int [N];

        for(int i=0;i<seq.length;i++)
            seq[i] = sc.nextInt();
    }

    public static void main(String[] args) {
        Input();
        isUsed[0]=true;
        Func(0, 0);
        if(S==0)
            count--;
        System.out.println(count);
    }
}
