package Practice.src;

import java.util.Arrays;

public class SelectTest2 {

    public int func(int[] arr) {

        Arrays.sort(arr);
        int count = 1;
        int answer = arr[0];

        while (count < arr.length) {
            if (answer < arr[count]) {
                answer = arr[count];
                break;
            }
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        SelectTest2 selectTest2 = new SelectTest2();
        int[] arr = {5, 1, 2};
        selectTest2.func(arr);
    }
}
