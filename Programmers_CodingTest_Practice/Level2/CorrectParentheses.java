package Programmers_CodingTest_Practice.Level2;

import java.util.*;

class CorrectParentheses{
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> open = new Stack();

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i)=='(') {
                open.push(s.charAt(i));
                continue;
            }
            if(open.isEmpty()) {
                return false;
            }
            open.pop();
        }

        if(open.size()>0) {
            return false;
        }
        return answer;
    }
}
