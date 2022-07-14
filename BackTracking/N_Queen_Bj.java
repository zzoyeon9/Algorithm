package Practice.src;

import java.util.Scanner;

public class N_Queen_Bj {

    static int [] board;
    static int [] queen;
    static int count=0;
    static int N;

    public static void Searching(int row){

        if(row == N+1)
            count++;
        else
            for(int col=1; col<=N; col++)
                if(isPossible(row, col)) {
                    queen[row] = col;
                    Searching(row + 1);
                    queen[row] = 0;
                }
    }

    public static boolean isPossible(int row, int col){
        for(int i=1;i<row;i++) {
            if (col == queen[i] || (Math.abs(row - i) == Math.abs(col - queen[i])))
                return false;
        }
        return true;
    }

    public static void Input(){
        Scanner sc = new Scanner(System.in);
        N =  sc.nextInt();
        board = new int[N+1];
        queen = new int[N+1];
    }

    public static void main(String[] args) {
        Input();
        Searching(1);
    }
}
