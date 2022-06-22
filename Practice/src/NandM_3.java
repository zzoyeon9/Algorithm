package Practice.src;

import java.util.Scanner;

public class NandM_3 {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int [] seq;


    static public void Input(){
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        NandM_3.n = Integer.parseInt(num.split(" ")[0]);
        NandM_3.m = Integer.parseInt(num.split(" ")[1]);


    }

    public static void func(int count){



        if(count==m) {
            for (int i=0;i<m;i++)
                sb.append(seq[i] + " ");
            sb.append('\n');
            return;
        }

        for(int i=1; i<=n; i++){
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
