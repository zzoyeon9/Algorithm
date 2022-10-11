package Programmers_SkillCheck_level2;

import java.util.ArrayList;
import java.util.Arrays;


public class ttangttameokgi {

    private static ArrayList<Integer> scoreList = new ArrayList<>();
    private static int answer=0;

   /* private void dfs(int y, int x, int score, int[][] land) {
        if (y == land.length-1) {
            if(score>answer)
                answer=score;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int ny = y + 1;
            int nx = i;

            if (ny >= land.length || nx == x)
                continue;

            dfs(ny, nx, score + land[ny][nx], land);
        }
    }*/

        int solution ( int[][] land){

            for(int i=1;i< land.length; i++){
                land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
                land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
                land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
                land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
            }
            Arrays.sort(land[land.length-1]);
            return land[land.length-1][3];
        }

        public static void main (String[]args){
            ttangttameokgi s = new ttangttameokgi();
            int [][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
            System.out.println(s.solution(land));
        }
    }
