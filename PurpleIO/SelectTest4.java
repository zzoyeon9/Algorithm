package Practice.src;

import java.util.stream.Stream;

public class SelectTest4 {

    public int func(String[] numbers) {
        Integer[] nums = Stream.of(numbers).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        int answer = -1, oddNum = 0, evenNum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                evenNum++;
            else
                oddNum++;
        }

        if (oddNum == 1)
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 1)
                answer = i + 1;
            }
        else
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 0)
                answer = i + 1;
            }

        return answer;
    }

    public static void main(String[] args) {

        SelectTest4 selectTest4 = new SelectTest4();
        String[] str = {"2", "4", "7", "8", "10"}; // "" 이 있어서 String 배열을 넘기라는 의미로 해석하여 String 배열로 구현하였습니다.

        selectTest4.func(str);
    }
}