package Programmers_Backend_Engineering;

import java.util.*;


public class Solution2 {

    static Queue<Integer> que;
    static boolean [][] isVisit;
    static char [][] map;

    public String[] solution(String[] grid) {
        String [] answer = {};
        map = new char[grid.length][grid[0].length()];
        isVisit = new boolean[grid.length][grid[0].length()];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length(); j++) {
                map[i][j] = grid[i].charAt(j);
            }
        }
        for(int i = 0; i < map.length; i++)
            System.out.println(Arrays.toString(map[i]));

        que = new LinkedList<>();

        for(int y = 0; y < map.length; y++) {
            for(int x = 0; x < map[y].length; x++) {
                if(!isVisit[y][x] && map[y][x]=='#') {
                    que.add(x); que.add(y);
                    isVisit[y][x]=true;
                    searching(1);
                }
            }
        }
        return answer;
    }
    public void searching(int area) {
        int [][] dir = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        while(!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for(int i = 0; i < 8; i++) {
                int nx = dir[i][0];
                int ny = dir[i][1];

                if(nx >= 0 && ny >= 0 && nx < map[y].length && ny < map.length)
                    if(isVisit[ny][nx] && map[ny][nx]=='#') {
                        isVisit[ny][nx]=true;
                        que.add(nx); que.add(ny);
                    }
            }
        }
    }

    public static void main(String[] args) {
        String [] gird = {".....####", "..#...###", ".#.##..##", "..#..#...", "..#...#..", "...###..."};
        Solution2 s = new Solution2();
        s.solution(gird);
    }
}
