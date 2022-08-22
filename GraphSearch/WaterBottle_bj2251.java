package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WaterBottle_bj2251 {

    private static int [] limits;
    private static boolean [][][] isVisited;
    private static boolean [] possible;
    private static int [][] idxArr = {{0,1}, {0,2}, {1,0}, {1,2}, {2,0}, {2,1}};


    public static void dfs(Status prestatus) {

        for(int i=0;i<6;i++){
            Status status = prestatus.move(idxArr[i][0], idxArr[i][1], limits[idxArr[i][1]]);
            int w1 = status.basketlist[0], w2 = status.basketlist[1], w3 = status.basketlist[2];
            if(!isVisited[w1][w2][w3]) {
                isVisited[w1][w2][w3] = true;
                if(w1==0)
                    possible[w3]=true;
                dfs(status);
            }
        }
    }

    public static void func() {
        // 1. 현재 물 담겨있는 상태 저장
        int [] init = {0,0,limits[2]};
        // 2. 탐색 시작
        dfs(new Status(init));
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limits = new int[3];
        for(int i=0;i<3;i++)
            limits[i]=Integer.parseInt(st.nextToken());

        isVisited = new boolean[limits[0]+1][limits[1]+1][limits[2]+1];
        possible = new boolean[limits[2]+1];
    }
    private static void output() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<possible.length;i++)
            if(possible[i])
                sb.append(i+" ");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
        output();
    }

    static class Status {
        int [] basketlist;

        public Status(int [] list) {
            basketlist = new int[3];
            for(int i=0;i<3;i++)
                basketlist[i]=list[i];
        }

        public Status move(int from, int to, int toLimit) {
            int [] list = {basketlist[0], basketlist[1], basketlist[2]};
            if(list[to]+list[from] > toLimit) {
                list[from] = list[to] + list[from] - toLimit;
                list[to] = toLimit;
            }else {
                list[to] += list[from];
                list[from]=0;
            }
            return new Status(list);
        }
    }
}