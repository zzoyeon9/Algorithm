package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NumOfIsland_bj4963 {

    private static ArrayList<Integer> answers = new ArrayList<>();
    private static int w, h;
    private static int[][] map;
    private static boolean[][] isVisit;

    private static void dfs(int h, int w) {
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

        for (int i = 0; i < 8; i++) {
            int nw = w + dir[i][0];
            int nh = h + dir[i][1];

            if (nw < 0 || nh < 0 || nw >= NumOfIsland_bj4963.w || nh >= NumOfIsland_bj4963.h)
                continue;
            if (isVisit[nh][nw] || map[nh][nw] == 0)
                continue;
            isVisit[nh][nw] = true;
            dfs(nh, nw);
        }

    }

    public static int searchIslandNum() {
        int count = 0;

        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (!isVisit[i][j] && map[i][j] == 1) {
                    isVisit[i][j] = true;
                    count++;
                    dfs(i, j);
                }
        return count;
    }


    public static void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();

        while (!temp.equals("0 0")) {

            w = Integer.parseInt(temp.split(" ")[0]);
            h = Integer.parseInt(temp.split(" ")[1]);
            map = new int[h][w];
            isVisit = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                temp = br.readLine();

                if (temp.length() == 1)
                    map[0][0] = Integer.parseInt(temp);
                else
                    for (int j = 0; j < temp.split(" ").length; j++)
                        map[i][j] = Integer.parseInt(temp.split(" ")[j]);
            }
            answers.add(searchIslandNum());
            temp = br.readLine();
        }
        for (int i = 0; i < answers.size(); i++)
            System.out.println(answers.get(i));
    }

    public static void main(String[] args) throws IOException {
        func();
    }
}
