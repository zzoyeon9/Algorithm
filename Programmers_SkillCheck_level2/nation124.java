package Programmers_SkillCheck_level2;

import java.util.*;

public class nation124 {

    public String solution(int n) {
        String[] nums = {"4", "1", "2"};
        String answer = "";
        ArrayList<String> thoOther = new ArrayList<>();

        if (n == 0)
            return answer;

        int tempNum = n;

        while (tempNum != 0) {
            int tempTheOther = tempNum % 3;

            thoOther.add(nums[tempTheOther]);
            tempNum /= 3;

            if (tempTheOther == 0)
                tempNum--;
        }
        while (!thoOther.isEmpty())
            answer += thoOther.remove(thoOther.size()-1);

        if (answer.equals("0"))
            return "1";

        return answer;
    }

    public static void main(String[] args) {
        nation124 s = new nation124();
        System.out.println(s.solution(16));
    }
}
