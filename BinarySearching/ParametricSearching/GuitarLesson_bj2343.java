package BinarySearching.ParametricSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GuitarLesson_bj2343 {

    private static int N, M;
    private static int[] lectures;

    public static void func() {

        int right = 1000000000; int left=0;
        int answer = 0;
        for(int i=0;i<N;i++)
            left = Math.max(left, lectures[i]);

        while (left <= right) {
            int sum = 0, count = 1;
                int capacity = (left + right) / 2;
            for (int i = 0; i < N; i++) {
                if (sum + lectures[i] <= capacity)
                    sum += lectures[i];
                else {  //용량이 꽉차서 새로 담을 때
                    sum = lectures[i];
                    count++;
                }
            }
            if (count > M)
                left = capacity + 1;
            else {
                answer = capacity;
                right = capacity - 1;
            }
        }
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lectures = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            lectures[i] = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}