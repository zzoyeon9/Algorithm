package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gonyangee_bj16472 {

    static String [] str;
    static int N;

    public static void func() {
        int left = 0, right = 0, answer = 0;
        Map<String, Integer> alpabet = new HashMap<>();

        while (left <= right && right < str.length) {

            while (alpabet.size() <= N && right < str.length) {//N이하일떄까지계속right이동
                if (alpabet.containsKey(str[right])) {
                    alpabet.replace(str[right], alpabet.get(str[right]) + 1);
                    right++;
                } else
                    alpabet.put(str[right], 0);
            }
                answer = Math.max(answer, right - left);


            while (alpabet.size() > N) {//n-1이 될때까지 left 계속이동
                alpabet.replace(str[left], alpabet.get(str[left]) - 1);
                if (alpabet.get(str[left]) == 0)
                    alpabet.remove(str[left]);
                left++;
            }//ba    /ba
        }
            System.out.println(answer);
 /*       for(int left=0;left<str.length;left++) {
            int right = left; int count = 0;

            while(right< str.length && alpabet.size()<=N)
                if(alpabet.contains(str[right]))
                    right++;

            answer = Math.max(answer, right-left);
        }*/
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine().split("");
    }

    public static void main(String[] args) throws IOException{
        input();
        func();
    }
}