package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory_bj14502 {

    private static int N,M;
    private static int [][] map;
    private static int [][] wallCandiSpot;
    private static int wallNum;
    private static boolean [][] isVisit;
    private static Queue<Integer> que = new LinkedList<>();
    private static int [][] dir = {{0,-1}, {0,1}, {1,0}, {-1,0}};
    private static int answer = 0;
    public static void bfs() {

        while(!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for(int i=0;i<4;i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx>=0 && ny>=0 && nx<M && ny<N)
                    if(!isVisit[ny][nx])
                        if(map[ny][nx]==0) {
                            que.add(nx);
                            que.add(ny);
                            isVisit[ny][nx] = true;
                        }
            }
        }
       cleanSectorSearch();

    }

    public static void spreadVirus() {

        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++) {
                isVisit[i][j]=false;
                if (map[i][j] == 2) {
                    que.add(j);
                    que.add(i);
                    isVisit[i][j] = true;
                }
            }
        bfs();

    }

    public static void dfs(int idx, int selected_count) {
        if(selected_count==3){
            spreadVirus();
            return;
        }

        if(idx>wallNum)
            return;

        int nx = wallCandiSpot[idx][0];
        int ny = wallCandiSpot[idx][1];

        map[ny][nx]=1;
        dfs(idx+1,selected_count+1);
        map[ny][nx]=0;
        dfs(idx+1, selected_count);

    }

    public static void pickWall() {

        int selected_count=0, wall=0;
        for(int i=0;i<N;i++)
            for (int j = 0; j < M; j++)
                if(map[i][j]==0) {
                    wall++;
                    wallCandiSpot[wall][0]=j;
                    wallCandiSpot[wall][1]=i;
                }
        wallNum=wall;
        dfs(1,0);
    }

    public static void cleanSectorSearch() {
        int cleanSpotCount=0;
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                if(map[i][j]==0 && !isVisit[i][j]) {
                    isVisit[i][j]=true;
                    cleanSpotCount++;
                }
        answer = Math.max(answer,cleanSpotCount);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        wallCandiSpot = new int[N*M+1][2];
        isVisit = new boolean[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pickWall();
        System.out.println(answer);
    }
}