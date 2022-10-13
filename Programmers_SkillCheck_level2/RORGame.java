package Practice.src;

import java.util.*;

public class RORGame {

    public int solution(int[][] maps) {
        Queue<Integer> que = new LinkedList<>();
        boolean [][] isVisit = new boolean[maps.length][maps[0].length];
        int [][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
        int [][] dist = new int[maps.length][maps[0].length];

        que.add(0);
        que.add(0);
        isVisit[0][0]=true;

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();

            for(int i=0;i<4;i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx<0 || ny<0 || nx==maps[0].length || ny == maps.length)
                    continue;
                if(isVisit[ny][nx] || maps[ny][nx]==0)
                    continue;

                dist[ny][nx] = dist[y][x] + 1;
                que.add(nx);
                que.add(ny);
                isVisit[ny][nx]=true;
            }
        }
        int answer = dist[maps.length-1][maps[0].length-1];
        if(answer==0)
            return -1;
        return answer+1;
    }

    public static void main(String[] args) {
        RORGame s = new RORGame();
        int [][]arr1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int [][]arr2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(s.solution(arr1));
        System.out.println(s.solution(arr2));
    }
}
