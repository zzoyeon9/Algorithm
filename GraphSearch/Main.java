package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int R,C;
    private static String [][] map;
    private static boolean [][] isVisit;
    private static int Wx, Wy, Sx, Sy, Dx, Dy;

    public static void func() {
        int [][] dir = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        int [][] sec = new int[R][C];
        Queue<Integer> waterQue = new LinkedList<>();
        Queue<Integer> que = new LinkedList<>();
        waterQue.add(Wx); waterQue.add(Wy);
        que.add(Sx); que.add(Sy);
        isVisit[Sy][Sx]=true;
        int Wsync=0, Ssync=0;
        while(!que.isEmpty() && !waterQue.isEmpty()) {
            while(Wsync == Ssync){
            int wx = waterQue.poll();
            int wy = waterQue.poll();


            for(int i=0;i<4;i++){
                int nwx = wx + dir[i][0];
                int nwy = wy + dir[i][1];
                if((nwx >=0 && nwy>=0) && (nwx<C && nwy<R) && (map[nwy][nwx].equals(".") || map[nwy][nwx].equals("S"))) {
                    map[nwy][nwx] = "*";
                    waterQue.add(nwx);
                    waterQue.add(nwy);
                }
            }
            }
            int sx = que.poll();
            int sy = que.poll();

            for(int i=0;i<4;i++){
                int nsx = sx + dir[i][0];
                int nsy = sy + dir[i][1];
                if((nsx >=0 && nsy>=0 && nsx<C && nsy<R) && !map[nsy][nsx].equals("*") && !isVisit[nsy][nsx]){
                    que.add(nsx);
                    que.add(nsy);
                    isVisit[nsy][nsx]=true;
                    sec[nsy][nsx]=sec[sy][sx]+1;
                }
            }
        }
        if(sec[Dy][Dx]==0)
            System.out.println("KAKTUS");
        else
            System.out.println(sec[Dy][Dx]);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C]; isVisit = new boolean[R][C];

        for(int i=0;i<R;i++) {
            String [] temp = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
                if(map[i][j].equals("S")){
                    Sx = j;
                    Sy = i;
                }else if(map[i][j].equals("D")){
                    Dx = j;
                    Dy = i;
                }else if(map[i][j].equals("*")){
                    Wx=j;
                    Wy=i;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        func();
    }
}
