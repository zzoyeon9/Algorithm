package Programmers_SkillCheck_level2;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution2 {

    ArrayList<String> idList;
    HashMap<String, String> id_nick;

    public String[] solution(String[] record) {

        idList = new ArrayList<>();
        id_nick = new HashMap<>();
        String[] answer = new String[record.length];
        for (int i = 0; i < record.length; i++) {
            String act, id, nickname;
            if(record[i].length()==3) {
                act = record[i].split(" ")[0];
                id = record[i].split(" ")[1];
                nickname = record[i].split(" ")[2];
            }else{
                act = record[i].split(" ")[0];
                id = record[i].split(" ")[1];
                nickname = id_nick.get(id);
            }

            if (act.equals("Enter")) {//손님이 들어왔을때
                if (!idList.contains(id)) {//처음 오는 손님이면
                    idList.add(id);
                    id_nick.put(id, nickname);
                } else {//이미 왔었던 손님이라면
                    if (!nickname.equals(id_nick.get(id)))//닉네임을 바꾸고 다시 들어왔다면
                        id_nick.replace(id, nickname);
                }
            }
            else if(act.equals("Change")){
                id_nick.replace(id, nickname);
            }
        }
        for (int i = 0; i < record.length; i++) {
            String act = record[i].split(" ")[0];
            String id = record[i].split(" ")[1];
            String nickname = record[i].split(" ")[2];

            if (act.equals("Enter"))
                answer[i] = id_nick.get(id) + "님이 들어왔습니다.";
            else if(act.equals("Leave"))
                answer[i] = id_nick.get(id) + "님이 나갔습니다.";
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2 a = new Solution2();

        String[] arr = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(a.solution(arr));
    }
}
