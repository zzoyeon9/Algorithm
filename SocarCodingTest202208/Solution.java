package SocarCordingTest202208;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static int sX,sY,sZ;
    private static int eX,eY,eZ;

    public int bfs(int[][][] map, boolean[][][] isVisited, int [][] dir, int xLength, int yLength, int zLength) {

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(sX,sY,sZ,0));
        isVisited[sZ][sY][sX]=true;

        while(!que.isEmpty()){
            Node node = que.poll();
            if((node.x == eX) && (node.y == eY) && (node.z == eZ))
                return node.cost;

            for(int i=0;i<6;i++) {
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];
                int nz = node.z + dir[i][2];

                if((nx<0 || nx>=xLength) || (ny<0 || ny >=yLength) || (nz<0 || nz >=zLength))
                    continue;
                if(map[nz][ny][nx]==0 || isVisited[nz][ny][nx])
                    continue;

                isVisited[nz][ny][nx]=true;
                que.add(new Node(nx, ny, nz, node.cost+1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String [][] map = {{"XXXXX", "OOSXO", "OOXOO"}, {"XEOOO", "OXXXO", "OOOOX"}};
        Solution a = new Solution();
        a.solution(map);
    }
    public void solution(String[][] map3d) {

        int xLength = map3d[0][0].length();
        int yLength = map3d[0].length;
        int zLength = map3d.length;

        boolean [][][] isVisited = new boolean[zLength][yLength][xLength];
        int [][][] map = new int[zLength][yLength][xLength];

        for(int z=0;z<zLength;z++) { //시작점 찾
            for (int y = 0; y < yLength; y++) {
                if (map3d[z][y].contains("S")) {
                    sX = map3d[z][y].indexOf("S");
                    sY = y;
                    sZ = z;
                }
                else if (map3d[z][y].contains("E")) {
                    eX = map3d[z][y].indexOf("E");
                    eY = y;
                    eZ = z;
                }
                for (int x = 0; x < xLength; x++)
                    if (!map3d[z][y].split("")[x].equals("X"))
                        map[z][y][x] = 1;
            }
        }
        int [][] dir = {{0, 0, -1}, {0, 0, 1}, {0, -1, 0}, {0, 1, 0}, {-1, 0, 0}, {1, 0, 0}};
        int answer = bfs(map, isVisited, dir, xLength, yLength, zLength);

        System.out.println(answer);
    }
}

class Node {
    int x, y, z, cost;

    public Node(int x, int y, int z, int cost) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cost = cost;
    }
}