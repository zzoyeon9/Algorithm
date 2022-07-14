package Practice.src;

import java.util.Arrays;
import java.util.Scanner;

public class RotationalSearching_PgOrNaver {

    public static int[][] solution(int n, boolean horizontal) {
        //로봇은 반드시 ixi가 끝날때마다 아래 혹은 오른쪽으로만 탐색을 시작
        //시작을 수평으로 할 경우, i가 홀수일땐 오른쪽, i가 짝수일땐 아래쪽
        //시작을 수직으로 할 경우, i가 홀수일땐 아래족, i가 짝수일땐 오른쪽
        int[][] answer = new int[n][n];
        int count = 1;
        int curRow = 0;
        int curCol = 0;
        int i = 0;
        int icount=0;
        answer[0][0] = count++;
        i++;
        if (horizontal)
            while (i < n) {//전부 탐색하기 전까지
                if (icount==0 && i % 2 != 0)//다음 행 OR 열로 넘어갈 때
                    curCol++;
                else if(icount==0 && i % 2 == 0)
                    curRow++;
                /////////////////////이상 무
                if (curRow == 0 && curCol == i) {//아래로 탐색할 때
                    for (int j = 0; j <= i; j++) {
                        if (answer[curRow][curCol] != 0) {
                            curRow++;
                            continue;
                        }
                        answer[curRow][curCol] = count++;
                        if(curRow!=i)
                            curRow++;
                    }
                    icount++; //가로, 세로 총 2번 그었는지 검사하여 다음 행 or 열로 진출해야
                }
                else if (i%2!=0 && curRow == i && curCol == i) {//왼쪽으로 탐색할 때
                    for (int j = 0; j <= i; j++) {
                        if (answer[curRow][curCol] != 0) {
                            curCol--;
                            continue;
                        }
                        answer[curRow][curCol] = count++;
                        if(curCol>0)
                            curCol--;
                    }
                    icount++;
                }
                else if (i%2==0 && curRow == i && curCol == i) {// 위로 탐색할 때
                    for (int j = 0; j <= i; j++) {
                        if (answer[curRow][curCol] != 0) {
                            curRow--;
                            continue;
                        }
                        answer[curRow][curCol] = count++;
                        if(curRow>0)
                            curRow--;
                    }
                    icount++;
                }
                else{
                    for (int j = 0; j <= i; j++) {
                        if (answer[curRow][curCol] != 0) {
                            curCol++;
                            continue;
                        }
                        answer[curRow][curCol] = count++;
                        if(curCol!=i)
                            curCol++;
                    }
                    icount++;
                }
                if(icount==2) {
                    i++;
                    icount=0;
                }
            }
        else
            while (i < n) {//전부 탐색하기 전까지
                if (icount==0 && i % 2 == 0)//다음 행 OR 열로 넘어갈 때
                    curCol++;
                else if(icount==0 && i % 2 != 0)
                    curRow++;
                /////////////////////이상 무
                if (curRow == 0 && curCol == i) {//아래로 탐색할 때
                    for (int j = 0; j <= i; j++) {
                        if (answer[curRow][curCol] != 0) {
                            curRow++;
                            continue;
                        }
                        answer[curRow][curCol] = count++;
                        if(curRow!=i)
                            curRow++;
                    }
                    icount++; //가로, 세로 총 2번 그었는지 검사하여 다음 행 or 열로 진출해야
                }
                else if (i%2!=0 && curRow == i && curCol == i) {//왼쪽으로 탐색할 때
                    for (int j = 0; j <= i; j++) {
                        if (answer[curRow][curCol] != 0) {
                            curRow--;
                            continue;
                        }
                        answer[curRow][curCol] = count++;
                        if(curRow>0)
                            curRow--;
                    }
                    icount++;
                }
                else if (i%2==0 && curRow == i && curCol == i) {// 위로 탐색할 때
                    for (int j = 0; j <= i; j++) {
                        if (answer[curRow][curCol] != 0) {
                            curCol--;
                            continue;
                        }
                        answer[curRow][curCol] = count++;
                        if(curCol>0)
                            curCol--;
                    }
                    icount++;
                }
                else{
                    for (int j = 0; j <= i; j++) {
                        if (answer[curRow][curCol] != 0) {
                            curCol++;
                            continue;
                        }
                        answer[curRow][curCol] = count++;
                        if(curCol!=i)
                            curCol++;
                    }
                    icount++;
                }
                if(icount==2) {
                    i++;
                    icount=0;
                }
            }
        return answer;
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[][] answer = solution(N,false);

        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++)
                sb.append(answer[i][j] + "\t");
              sb.append("\n");
        }
        System.out.println(sb.toString());

        //solution(N,true);
    }
}
