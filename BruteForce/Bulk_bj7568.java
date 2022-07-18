package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bulk_bj7568 {

    private static int N;
    private static int[] result;
    private static int[] weights;
    private static int[] heights;

    public static void func() {

        for (int i = 0; i < weights.length; i++) {
            int score = 1;
            int topweight = weights[i];
            int topheight = heights[i];

            for (int j = 0; j < weights.length; j++) {
                int weight2 = weights[j];
                int height2 = heights[j];

                if (topweight < weight2 && topheight < height2)
                    score++;
            }
            result[i]=score;
        }
        for(int i=0;i<N;i++)
            System.out.print(result[i] + " ");
    }

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N];
        weights = new int[N];
        heights = new int[N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            weights[i] = Integer.parseInt(temp.split(" ")[0]);
            heights[i] = Integer.parseInt(temp.split(" ")[1]);
        }
    }

    public static void main(String[] args) throws IOException {

        input();
        func();
    }
}