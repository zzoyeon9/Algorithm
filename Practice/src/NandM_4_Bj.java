package Practice.src;

import java.util.Scanner;

public class NandM_4 {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int [] seq;

    static public void Input(){
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        NandM_4.n = Integer.parseInt(num.split(" ")[0]);
        NandM_4.m = Integer.parseInt(num.split(" ")[1]);
    }

    public static void func(int count){

        if(count==m) {
            for (int i=0;i<m;i++)
                sb.append(seq[i] + " ");
            sb.append('\n');
            return;
        }
        int preNum = 0;
        if(count!=0)
            preNum = seq[count-1];
        for(int i=preNum+1; i<=n; i++){//113 count:3 i:4
            seq[count] = i;
            func(count+1);
        }
    }

    public static void main(String[] args) {

        Input();
        seq = new int [m];
        func(0);
        System.out.print(sb);
    }
}
