package Practice.src;

import java.util.Arrays;
import java.util.Scanner;

public class Drop7 {
    static String [][] board = new String[7][7];
    static int ballNum;


    public static void widthBingo(){

    }

    public static void func(){
/*
        for(int i=0;i<7;i++){
            int sum, count = 0;
            while(board[count+1][i]==0)//떨굴 위치 파악
                count++;

            if(widthBingo) //가로 빙고 검사 ->터트릴 때, 자기 자신은 뒤이을 세로빙고 검사를 위해 냅두자
                crash();
            if(lengthBingo) //세로 빙고 검사 ->
                crash();

        }
        */
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<7;i++)
            board[i] = sc.nextLine().split(" ");

        ballNum = sc.nextInt();
        sc.nextLine();
    }
    public static void main(String[] args) {
        input();
        func();
    }
}
