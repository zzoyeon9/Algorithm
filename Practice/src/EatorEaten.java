package Practice.src;

import java.util.Arrays;
import java.util.Scanner;

public class EatorEaten {

    static Scanner sc = new Scanner(System.in);
    static int [] A,B;
    static int N, M;

    public static int search(int[] arr, int target, int left, int right){
    //1 2 3 4 5 6 7 8 9 10       11 12 13 13     15 16 17 18 19 20 //13
        int result = -1;

        while (left <= right){

            int mid = (left + right) / 2;

            if(arr[mid]<target) {
                result = mid;
                left = mid + 1;
            }
            else
                right = mid-1;
        }
        if(result==-1)
            return 0;
        return result+1;
    }

    public static void func(){

        Arrays.sort(B);
        int sum=0;
        for(int i=0;i<N;i++)
            sum += search(B, A[i], 0, B.length-1);
        System.out.println(sum);
    }

    public static void input(){

        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N];
        B = new int[M];

        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        for(int i=0;i<M;i++)
            B[i] = sc.nextInt();
    }

    public static void main(String[] args) {

        int casenum = sc.nextInt();

        for(int i=0;i<casenum;i++){
            input();
            func();
        }
    }
}