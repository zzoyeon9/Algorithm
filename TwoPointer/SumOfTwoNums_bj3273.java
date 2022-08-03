package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfTwoNums_bj3273 {

    private static int n, x;
    private static int [] a;


    public static void func() {

        Arrays.sort(a);

        int left = 0; int right = n-1;
        int count=0;

        if(left==right && a[right]==x)
            count++;
        //1 2 3 5 7 9 10 11 12
        while(left!=right) {
            if (a[left] + a[right] > x)
                right--;
            else if (a[left] + a[right] < x)
                left++;
            else {
                count++;
                right--;
            }
        }
        System.out.println(count);
    }

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(st.nextToken());

        x = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        input();
        func();
    }
}