package Implementation;

import java.util.*;
import java.io.*;

public class Zero_bj10773 {

    static public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static public Stack<Integer> stack = new Stack<>();

    public int solution(int K) throws IOException {

        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0 && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            stack.push(num);
        }
        int answer = 0;

        while(!stack.isEmpty())
            answer+=stack.pop();

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Zero_bj10773 m = new Zero_bj10773();
        int K = Integer.parseInt(br.readLine());

        System.out.println(m.solution(K));
    }
}