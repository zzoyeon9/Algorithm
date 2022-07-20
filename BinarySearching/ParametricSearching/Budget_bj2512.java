package BinarySearching.ParametricSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Budget_bj2512 {

    static int N, M;
    static Integer[] budgets;
    static int answer;

    public static void func() {

        Arrays.sort(budgets);//110 120 140 150

        int left = 1;
        int right = budgets[budgets.length - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (budgets[i] > mid)
                    sum += mid;
                else
                    sum += budgets[i];
            }
            if (sum <= M && answer<mid) {
                answer = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        budgets = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        M = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}
