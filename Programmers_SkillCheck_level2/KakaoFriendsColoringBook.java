package Practice.src;

import java.util.*;

public class KakaoFriendsColoringBook {

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        Queue<Integer> que = new LinkedList<>();
        boolean [][] isVisit = new boolean[m][n];
        int [][] dir = {{0,-1}, {0,1}, {-1,0}, {1,0}};



        for(int j=0;j<m;j++) {
            for (int k = 0; k < n; k++) {
                if(isVisit[j][k] || picture[j][k]==0)
                    continue;

                que.add(k);
                que.add(j);
                isVisit[j][k]=true;
                numberOfArea++;
                int curAreaSize=1;

                while(!que.isEmpty()){
                    int x = que.poll();
                    int y = que.poll();

                    for(int i=0;i<4;i++){
                        int nx = x + dir[i][0];
                        int ny = y + dir[i][1];

                        if(nx<0 || ny<0 || nx==n || ny==m)
                            continue;
                        if(isVisit[ny][nx] || picture[ny][nx]==0 || picture[y][x]!=picture[ny][nx])
                            continue;

                        que.add(nx);
                        que.add(ny);
                        curAreaSize++;
                        isVisit[ny][nx]=true;
                    }
                }
                if(curAreaSize>maxSizeOfOneArea)
                    maxSizeOfOneArea = curAreaSize;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        KakaoFriendsColoringBook s = new KakaoFriendsColoringBook();
        int [][] arr = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int m = 6; int n = 4;
        int [] answer = s.solution(m,n,arr);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
