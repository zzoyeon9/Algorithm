package Practice.src;

import java.util.ArrayList;

public class SelectTest3 {
    public String[] func(String[] users) {

        ArrayList<String> friendList = new ArrayList<>();

        for (int i = 0; i < users.length; i++)
            if (users[i].length() == 4)
                friendList.add(users[i]);//이름이 동일한 친구는 중복 허용 안한다는 주의사항이 없었기에
                                         // 중복 검사 없이 단순하게 삽입했습니다.

        String[] answer = friendList.toArray(new String[friendList.size()]);

        for (int i = 0; i < answer.length; i++)
            System.out.print(answer[i] + " ");

        return answer;
    }

    public static void main(String[] args) {

        SelectTest3 selectTest3 = new SelectTest3();
        String[] str = {"asdb", "Ryan", "asdb", "Kieran", "Mark"};
        selectTest3.func(str);
    }
}
