package Practice.src;

import java.util.ArrayList;
import java.util.Collections;

public class Test2 {//해당 테스트부터는 입력 얘기가 없어서 입력 코드를 따로 구현하지 않았습니다.

    public int func(int[] ids) {

        ArrayList<Integer> numList = new ArrayList<>();

        for (int id : ids)
            if (!numList.contains(id))
                numList.add(id);

        Collections.sort(numList);
        int answer = numList.get(numList.size()-1)+1;

        for(int i=0;i<numList.get(numList.size()-1);i++)
            if(!numList.contains(i)) {
                answer = i;
                break;
            }

        return answer;
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        int[] arr = {1};
        t.func(arr);
    }
}