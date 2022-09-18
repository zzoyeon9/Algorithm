package Programmers_Backend_Engineering;

public class Solution1 {

    public String solution(String src) {
        String first = src.split("")[0];
        String answer = first;

        while (src.length() != 0) {

            if (src.split("")[0].equals("0")) {
                int zeroCount = 0;

                while (src.split("")[0].equals("0")) {
                    src = src.replaceFirst("0", "");
                    zeroCount++;
                }
                answer += (char)(zeroCount + 64);

            } else {
                int oneCount = 0;

                while (src.split("")[0].equals("1")) {
                    src = src.replaceFirst("1", "");
                    oneCount++;
                }
                answer += (char)(oneCount + 64);
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.solution("01"));
    }


}
