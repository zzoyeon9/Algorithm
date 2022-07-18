package BinarySearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSolution_Bj {

    static int N;
    static int [] solutions;
    static int firstSolution, secondSolution;

    public static int find(int l, int r, int target){

        int secondTemp=r;

        while(l<=r){// -99 -2 -1 4 98
            int mid = (l + r)/2;
            if(solutions[mid]>=target) {
                secondTemp = mid;
                r = mid-1;
            }
            else
                l=mid+1;
        }
        return secondTemp;
    }

    public static void func(){

        int min=Integer.MAX_VALUE;
        int secondSolIdxCandi, left;

        Arrays.sort(solutions);

        for(left=0;left<N-1;left++){

            secondSolIdxCandi = find(left+1, N-1, -solutions[left]);

            if(secondSolIdxCandi<=N && Math.abs(solutions[left] + solutions[secondSolIdxCandi])<min) {
                min = Math.abs(solutions[left] + solutions[secondSolIdxCandi]);
                firstSolution = solutions[left];
                secondSolution = solutions[secondSolIdxCandi];
            }
            if(secondSolIdxCandi-1>left && Math.abs(solutions[left] + solutions[secondSolIdxCandi-1])<min){
                min = Math.abs(solutions[left] + solutions[secondSolIdxCandi-1]);
                firstSolution = solutions[left];
                secondSolution = solutions[secondSolIdxCandi-1];
            }
        }
        System.out.println(firstSolution + " " + secondSolution);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            solutions[i]=Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args)  throws IOException {
        input();
        func();
    }
}