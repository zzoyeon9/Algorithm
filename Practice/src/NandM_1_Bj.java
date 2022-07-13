package Practice.src;

import java.util.Arrays;
import java.util.Scanner;

    public class NandM_1 {

        static StringBuilder sb = new StringBuilder();
        static int n, m;
        static Integer [] seq;


        static public void Input(){
            Scanner input = new Scanner(System.in);
            String num = input.nextLine();
            NandM_1.n = Integer.parseInt(num.split(" ")[0]);
            NandM_1.m = Integer.parseInt(num.split(" ")[1]);
        }

        public static void func(int count){

            if(count==m) {
                for (int i=0;i<m;i++)
                    sb.append(seq[i] + " ");
                sb.append('\n');
                return;
            }
            for(int i=1; i<=n; i++){
                if(!Arrays.asList(Arrays.copyOfRange(seq, 0, count)).contains(i)) {
                    seq[count] = i;
                    func(count + 1);
                }
            }
        }



        public static void main(String[] args) {

            Input();

            seq = new Integer[m];

            func(0);

            System.out.print(sb);


        }
    }
