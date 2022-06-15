import javax.swing.*;
import java.util.Arrays;

public class BinarySearch {

    static int [] arr = new int[10000000];
    static boolean [] searched = new boolean[10000000];

    public static void main(String[] args) {

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        for(int i=0; i<arr.length;i++)
            arr[i] = (int)(Math.random()*10000000)+1;



        Arrays.sort(arr);



        Search(0, 5000000, 9999999, 4599999);


        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    public static void Search(int fst, int mid, int lst, int target){

        int first, middle, last;

        if(searched[mid]) {
            System.out.println("No data in array");
            return;
        }
        searched[mid]=true;

        if(arr[mid] == target) {
            System.out.println("target data (" + target + ") spotted : " + mid);
            return;
        }
        else if(arr[mid] > target){
            first = fst;
            middle = (fst + mid) / 2;
            last = mid;
        }
        else{
            first = mid+1;
            middle = (mid + lst) / 2;
            last = lst;
        }

        Search(first, middle, last, target);

    }
}
