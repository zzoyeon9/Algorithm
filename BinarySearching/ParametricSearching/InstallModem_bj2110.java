package BinarySearching.ParametricSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InstallModem_bj2110 {

    private static int N,C;
    private static int [] housePlaces;
    private static int answer;

    public static void func(){

        Arrays.sort(housePlaces);

        int reft = 0, right = housePlaces[N-1];
        while(reft<=right){
            int mid = (reft + right) /2;
            if(isPossible(mid)) {
                reft = mid + 1;
                answer=mid;
            }
            else
                right=mid-1;
        }
        System.out.println(answer);
    }

    public static boolean isPossible(int dist){
        int cnt=1;
        int last=housePlaces[0];
       for(int i=1;i<N;i++){
           if(housePlaces[i]-last>=dist){
               cnt++;
               last = housePlaces[i];
           }
       }
       return cnt >=C;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();

        N = Integer.parseInt(temp.split(" ")[0]);
        C = Integer.parseInt(temp.split(" ")[1]);
        housePlaces = new int[N];

        for(int i=0;i<N;i++)
            housePlaces[i] = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException{
        input();
        func();
    }
}
