package Practice.src;

import java.util.*;

public class Solution {

    public String solution(String p) {

        String answer = dfs(p);
        return answer;
    }

    public static String dfs(String w) {

        if (w.isEmpty())
            return w;

        String u = "", v = "";

        int openCount = 0;
        int closeCount = 0;
        //p 문자열을 u,v로 분리
        for (Character ch : w.toCharArray()) {

            if (String.valueOf(ch).equals("("))
                openCount++;
            else closeCount++;

            u += String.valueOf(ch);

            if (openCount == closeCount) {
                v = w.substring(u.length());
                break;
            }
        }

            if(isPerfect(u)) {
                u += dfs(v);
                return u;
            }
            else{
                String newStr = "(";
                newStr+=dfs(v);
                newStr+=")";
                u = u.substring(1, u.length()-1);

                for(int i=0;i<u.length();i++)
                    if(String.valueOf(u.charAt(i)).equals("("))
                        newStr+=")";
                    else
                        newStr+="(";

                return newStr;
            }
            //


    }

    private static boolean isPerfect(String u) {

        Stack<String> stack = new Stack<>();

        for(int i=0;i<u.length();i++){
            int leftCount=0;
            int rightCount=0;
            String temp = String.valueOf(u.charAt(i));

            if(temp.equals("("))
                stack.add(temp);
            else{
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "(()())()";
        String b = ")(";
        String c ="()))((()";
        System.out.println(s.solution(a));
        System.out.println(s.solution(b));
        System.out.println(s.solution(c));
    }
}
