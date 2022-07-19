package BinarySearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CuttingLANcord_bj1654 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int K,N;
    private static int answer;
    private static int [] lines;

    public static void func(){

        int left=1, right;

        Arrays.sort(lines);
        right = lines[K-1];

        while(left<=right){
            long mid = (left+right)/2;
            int sum=0;
            for(int i=0;i<K;i++)
                sum+=lines[i]/mid;
            if(sum>=N) {
                answer = mid;
                left = mid + 1;
            }
            else if(sum<N)
                right = mid-1;
        }
        System.out.println(answer);
    }

    public static void input() throws IOException {
        String temp = br.readLine();

        K = Integer.parseInt(temp.split(" ")[0]);
        N = Integer.parseInt(temp.split(" ")[1]);
        lines = new int[K];

        for(int i=0;i<K;i++)
            lines[i]=Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException{
        input();
        func();
    }
}