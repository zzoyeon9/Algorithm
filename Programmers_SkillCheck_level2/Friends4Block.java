package Programmers_SkillCheck_level2;

import java.util.LinkedList;
import java.util.Queue;

public class Friends4Block {

    public int solution(int m, int n, String[] board) {

        char [][] boards = new char[m][n];


        for(int i=0;i<m;i++)
            boards[i] = board[i].toCharArray();


        boolean continues = true;
        int answer=0;
        while (continues) {
            boolean [][] isRemove = new boolean[m][n];
            continues=false;
            for (int y = 0; y < m - 1; y++) {//부술 블럭 탐색
                for (int x = 0; x < n - 1; x++) {

                    if(boards[y][x]=='#')
                        continue;

                    int nx1 = x + 1; int ny1 = y;
                    int nx2 = x + 1; int ny2 = y + 1;
                    int nx3 = x; int ny3 = y + 1;

                    if (boards[y][x] == boards[ny1][nx1] && boards[y][x] == boards[ny2][nx2]
                            && boards[y][x] == boards[ny3][nx3]) {
                        isRemove[y][x]=true;
                        isRemove[ny1][nx1]=true;
                        isRemove[ny2][nx2]=true;
                        isRemove[ny3][nx3]=true;
                        continues=true;
                    }
                }
            }

            int count=0;

            for(int x=0;x<n;x++) {
                Queue<Character> remainQue = new LinkedList<>();
                for (int y = m - 1; y >= 0; y--) {
                    if (isRemove[y][x]) {
                        count++;
                        continue;
                    }

                    remainQue.add(boards[y][x]);
                }

                int y=m-1;
                if(count!=0) {
                    while (!remainQue.isEmpty())
                        boards[y--][x] = remainQue.poll();

                    while (y >= 0)
                        boards[y--][x] = '#';
                }
            }
            answer+=count;
        }
        return answer;
    }

    public static void main(String[] args) {
        int m1 = 4;
        int n1 = 5;
        String[] arr1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"}; //정답 14
        int m2 = 6;
        int n2 = 6;
        String[] arr2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};//정답 15
        Friends4Block s = new Friends4Block();
        System.out.println(s.solution(2, 4, new String[]{"baab", "baab"}));
    }
}
