package Practice.src;

import java.util.Scanner;

public class Insert_Operator {

    static private int N, max, min;
    static private int [] nums, operators, operSeq;

    static StringBuilder sb = new StringBuilder();

    static public void func(int seq){

        if(seq == N) {
            int result = Calculation();
            max = Math.max(max, result);
            min = Math.min(min, result);
        }
        else
            for(int i=1;i<=4;i++)
                if(operators[i]>0) {
                    operSeq[seq] = i;
                    operators[i]--;
                    func(seq + 1);
                    operators[i]++;
                }
    }

    private static int Calculation() {
        int result = nums[1];

        for(int i=1;i<N;i++){
            if(operSeq[i]==1)
                result = result + nums[i+1];
            if(operSeq[i]==2)
                result = result - nums[i+1];
            if(operSeq[i]==3)
                result = result * nums[i+1];
            if(operSeq[i]==4)
                result = result / nums[i+1];
        }
        return result;
    }


    static public void Input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        nums = new int[N+1];
        operSeq = new int[N]; //연산자 순서
        operators = new int[5]; //[1]:+ [2]:- [3]:* [4]:/

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for(int i=1; i<=N; i++)
        nums[i] = sc.nextInt();
        sc.nextLine();
        String ops = sc.nextLine();

        for(int i=1; i<=4;i++)
            operators[i]=Integer.parseInt(ops.split(" ")[i-1]);
    }

    static public void Output(){
        System.out.println(max);
        System.out.println(min);
    }


    public static void main(String[] args) {

        Input();
        func(1);
        Output();

    }
}
