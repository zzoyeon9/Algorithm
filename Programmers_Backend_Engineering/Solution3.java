package Programmers_Backend_Engineering;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    private static boolean [][] isVisit;
    private static Queue<Integer> que = new LinkedList<>();

    public int solution(int N, int[][] mine, int[] P) {
        int[][] map = new int[N + 1][N + 1];
        int[][] dir = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

        for (int i = 0; i < mine.length; i++) {
            map[mine[i][0]][mine[i][1]] = -1;

            for(int j=0;j<8;j++) {
                if(mine[i][0] + dir[j][0]>0 && mine[i][1] + dir[j][1]>0 &&
                        mine[i][0] + dir[j][0]<=N && mine[i][1] + dir[j][1]<=N
                        && map[mine[i][0] + dir[j][0]][mine[i][1] + dir[j][1]]!=-1)
                map[mine[i][0] + dir[j][0]][mine[i][1] + dir[j][1]] += 1;
            }
        }
        int answer = 0;
        isVisit = new boolean[N + 1][N + 1];
        que.add(P[0]); que.add(P[1]);
        isVisit[P[0]][P[1]]=true;
        answer++;
        while(!que.isEmpty()) {
            int sY = que.poll();
            int sX = que.poll();

            for (int i = 0; i < 8; i++){
                int nY = sY+dir[i][0];
                int nX = sX+dir[i][1];
                if(nY>0 && nX>0 && nY<=N && nX<=N)
                    if(!isVisit[nY][nX] && map[nY][nX]!=-1){
                        isVisit[nY][nX]=true;
                        answer++;
                        if(map[nY][nX]==0) {
                            que.add(nY);
                            que.add(nX);
                        }
                    }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int [][] mine = {{1,2},{2,2},{1,1},{2,1},{2,3},{3,1},{3,3}};
        int [] p = {3,2};
        System.out.println(s.solution(3,mine,p));
    }
}
