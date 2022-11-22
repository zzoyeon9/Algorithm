package Programmers_CodingTest_Practice;

import java.util.*;

class Solution {
    public int solution(int n) {

        Stack<Integer> stack = new Stack();
        String candN="";
        int oneNum=0;
        int answer = 0;
        int temp = n;

        while(temp!=0) {
            stack.push(temp%2);

            if(temp%2==1) {
                oneNum++;
            }
            temp/=2;
        }

        while(!stack.isEmpty()) {
            candN +=String.valueOf(stack.pop());
        }
        StringBuilder sb = new StringBuilder(candN);
        String nextLargeNum="";

        if(candN.contains("0")){
            int nextCandi=n;

            while(true) {
                int nextOneNum=0;
                nextCandi++;
                stack = new Stack();

                while(nextCandi!=0) {
                    stack.push(nextCandi%2);

                    if(nextCandi%2==1) {
                        nextOneNum++;
                    }
                    nextCandi/=2;
                }
                if(nextOneNum==oneNum) {
                    break;
                }
            }
            answer = nextCandi;

            while(!stack.isEmpty()) {
                nextLargeNum +=String.valueOf(stack.pop());
            }

        }else {
            sb.insert(1,"0");
            nextLargeNum = sb.toString();
        }

        System.out.println(nextLargeNum);


        for(int i = 0; i < nextLargeNum.length(); i++) {
            if(nextLargeNum.charAt(i)=='1') {
                answer+=Math.pow(2,nextLargeNum.length()-i-1);

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(78));
    }
}