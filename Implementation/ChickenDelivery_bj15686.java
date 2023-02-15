package Implementation;

import java.util.*;
import java.io.*;

public class ChickenDelivery_bj15686 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Spot> houseList = new ArrayList<>();
    private static List<Spot> chickList = new ArrayList<>();
    private static boolean [] pick;
    private static int N,M;
    private static int answer = 2501;

    public void solution(List<Spot> houseList, List<Spot> chickList, int m) {
        //치킨집들 리스트를 받아와서 그중에서 3개를 조합으로 뽑고 bfs -> 최소 거리 구해보자
        pick = new boolean[chickList.size()];

        for(int i = 0; i < chickList.size(); i++) {
            pick[i] = true;
            combi(i + 1, 1);
            pick[i] = false;
        }
        System.out.println(answer);
    }

    private void combi(int next, int count) {
        if(count == M) {
            int cityChickDist = 0;

            for(int i = 0; i < houseList.size(); i++) {
                int houseChickDist = 2501;

                for(int j = 0; j < chickList.size(); j++) {
                    if(pick[j])
                        houseChickDist = Math.min(Math.abs(houseList.get(i).x - chickList.get(j).x) + Math.abs(houseList.get(i).y - chickList.get(j).y), houseChickDist);
                }
                cityChickDist += houseChickDist;
            }
            answer = Math.min(cityChickDist, answer);
        }
        else
            for(int i = next; i < chickList.size(); i++) {
                pick[i] = true;
                combi(i + 1, count + 1);
                pick[i] = false;
            }
    }

    public static void main(String[] args) throws IOException {

        ChickenDelivery_bj15686 m = new ChickenDelivery_bj15686();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houseList = new ArrayList<>();
        chickList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++) {
                int X = Integer.parseInt(st.nextToken());

                if(X==1)
                    houseList.add(new Spot(j,i));
                else if(X==2)
                    chickList.add(new Spot(j,i));
            }
        }
        m.solution(houseList, chickList, M);
    }
}

class Spot {
    int x, y;

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}