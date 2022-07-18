package BinarySearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Nonamed_bj1764 {

    static int N, M;
    static String[] names1, names2;
    static ArrayList<String> answer = new ArrayList<>();

    public static boolean isExist(int left, int right, String target) {

        while (left <= right) {
            int mid = (left + right) / 2;
            if (0 > names2[mid].compareTo(target))
                left = mid + 1;
            else if (0 < names2[mid].compareTo(target))
                right = mid - 1;

            else
                return true;
        }
        return false;
    }

    public static void func() {
        int count = 0;
        Arrays.sort(names2);

        for (int i = 0; i < names1.length; i++) {
            String target = names1[i];
            if (isExist(0, names2.length - 1, target)) {
                count++;
                answer.add(target);
            }
        }
        Collections.sort(answer);
        System.out.println(count);
        for(int i=0;i<answer.size();i++)
            System.out.println(answer.get(i));
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();

        N = Integer.parseInt(temp.split(" ")[0]);
        M = Integer.parseInt(temp.split(" ")[1]);
        names1 = new String[N];
        names2 = new String[M];

        for (int i = 0; i < N; i++)
            names1[i] = br.readLine();

        for (int i = 0; i < M; i++)
            names2[i] = br.readLine();
    }

    public static void main(String[] args) throws IOException {

        input();
        func();

    }
}
