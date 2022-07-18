package Practice.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Card_Bj11652 {

    static int N;
    static long [] cardDec;

    public static long func(){

        Arrays.sort(cardDec);

        int maxCount= 1;
        long maxValue=cardDec[0];
        int cnt=1;

        System.out.println(Arrays.toString(cardDec));
        for(int i=1;i<N;i++) {
            if(cardDec[i]==cardDec[i-1])
                cnt++;
            else
                cnt=1;

            if (maxCount < cnt) {
                maxCount = cnt;
                maxValue = cardDec[i];
            }
        }
        return maxValue;
    }

    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cardDec = new long[N];

        for(int i=0;i<N;i++)
            cardDec[i] = Long.parseLong(br.readLine());
    }

    public static void main (String[] args) throws IOException{

        input();
        System.out.println(func());

    }
}
