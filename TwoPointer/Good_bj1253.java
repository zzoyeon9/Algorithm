package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Good_bj1253 {

    private static int N;
    private static int[] arr;

    public static void func() {
        Arrays.sort(arr, 1, N+1);
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int left = 1, right = N, target = arr[i];
            while (left < right) {
                if (left == i)
                    left++;
                else if (right == i)
                    right--;
                else {
                    if (arr[left] + arr[right] == target) {
                        count++;
                        break;
                    } else if (arr[left] + arr[right] > target)
                        right--;
                     else
                        left++;
                }
            }
        }
        System.out.println(count);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}
