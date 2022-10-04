package Practice.src;

import java.util.ArrayList;

public class Solution {

    public String solution(String[] registered_list, String new_id) {

        //S+N 형식
        //S는 알파벳 소문자 문자열, 길이 3~6
        //N은 숫자 문자열 길이 0~6 (null 가능, 첫자리0 불가)능
        //이미 등록된 아이디라면 N을 숫자로 변환하고 1을 더해서 다시 문자열로 변환하고 S랑 합쳐서 추천
        
        String answer = new_id;
        while (true) {

            for (int i = 0; i < registered_list.length; i++) {//이미 존재하는 아이디인지 검사
                if (registered_list[i].equals(answer)) //이미 등록된 아이디 라면
                    break;
                if(i == registered_list.length-1)       // 끝까지 돌았다면
                    return answer;
            }

            String S = answer.replaceAll("[^a-z]", "");
            System.out.println("S = " + S);
            String N = answer.replaceAll("[^0-9]", "");
            System.out.println("N = " + N);

            if (N.equals(""))
                N = "0";

            Integer n1 = Integer.parseInt(N) + 1;
            String N1 = String.valueOf(n1);
            answer = S + N1;
        }
    }

    public static void main(String[] args) {
        String [] arr1 = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
        String [] arr2 = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9","cow7","cow5","cow6","cow8"};
        String [] arr3 = {"bird99", "bird98", "bird101", "gotoxy"};
        String [] arr4 = {"apple1", "orange", "banana3"};
        String st1 ="ace15";
        String st2 ="cow";
        String st3 ="bird98";
        String st4 ="apple";
        Solution a = new Solution();
        System.out.println(a.solution(arr2,st2));
    }
}
