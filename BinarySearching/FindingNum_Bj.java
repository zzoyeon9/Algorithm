package Practice.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class FindingNum_Bj {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int[] Aarr, Barr;
    static int N, M;

    static int binarySearching(int[] arr, int left, int right, int target) {

        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else
                return result = 1;
        }
        return result;
    }

    static void func() {
        Arrays.sort(Aarr);
        for (int i = 0; i < Barr.length; i++) {
            sb.append(binarySearching(Aarr, 0, Aarr.length - 1, Barr[i]));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void input() {
        N = sc.nextInt();
        Aarr = new int[N];

        for (int i = 0; i < N; i++)
            Aarr[i] = sc.nextInt();

        M = sc.nextInt();
        Barr = new int[M];

        for (int i = 0; i < M; i++)
            Barr[i] = sc.nextInt();
    }

    public static void main(String[] args) {

        input();
        func();
    }
}