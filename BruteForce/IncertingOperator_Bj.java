package Practice.src;

import java.util.Scanner;

public class IncertingOperator_Bj {

    static private int N, max, min, result;
    static private int [] nums, operators, operSeq;

    static StringBuilder sb = new StringBuilder();

    static public void func(int seq, int preResult){

        if(seq == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        }
        else
            for(int i=1;i<=4;i++)
                if(operators[i]>0) { //해당 연산자가 아직 남아있으면
                    operSeq[seq] = i; //이번 차례에 해당 연산자 등록
                    operators[i]--; // 해당 연산자 사용했으니 수량 -1
                    if(i==1)
                        result = preResult + nums[seq+1];
                    else if(i==2)
                        result = preResult - nums[seq+1];
                    else if(i==3)
                        result = preResult * nums[seq+1];
                    else
                        result = preResult / nums[seq+1];
                    func(seq + 1,result);
                    operators[i]++; //
                    }
            //
            // ++-*/
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
        func(1,nums[1]);
        Output();

    }
}
