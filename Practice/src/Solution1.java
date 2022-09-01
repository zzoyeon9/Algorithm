package Practice.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution1 {


    public static String solution(String S, String C) {
        // write your code in Java SE 8
        //John Doe, Peter Parker,
        String[] str = S.split(", ");
        String[] result = new String[str.length];
        ArrayList<String> idList = new ArrayList<>();
        String company = "@" + C.toLowerCase() + ".com";

        for (int i = 0; i < str.length; i++) {//매 이름 사이클
            String[] temp = str[i].replaceAll("-","").split(" "); //하이픈 제거한 이름 통쨰로 저장


            String F = ""; String M = ""; String L = "";

            F = temp[0].split("")[0].toLowerCase();            //first name 넣기
                                                          //first name 넣었으므로 카운트 1 추가

            if (temp.length == 2) {//middle name이 없을 때
                int count = 0;

                for (int j = 0; j < temp[1].length(); j++) {//카운트가 8미만이면서 아직 L(last name)이 남아있다면
                    if (count >= 8)
                        break;

                    L += temp[1].split("")[j].toLowerCase();//L(last name)에 한글자씩 추가

                }
            } else {//middle name이 있을 때
                M = temp[1].toLowerCase().split("")[0];
                int count = 0;

                for(int j=0;j<temp[2].length();j++){
                    if(count>=8)
                        break;

                    L+= temp[2].split("")[j].toLowerCase();
                    count++;
                }
            }
            String tempId = F + M + L;
            if(idList.contains(tempId)) {//해당아이디가 이미 존재하면
                int n=2;

                while (idList.contains(tempId+n))//중복되지 않을때까지  뒤에 숫자 증가
                    n++;

                tempId = tempId + n;             //중복되지 않는 최소 숫자 아이디 뒤에 합치기
            }
            idList.add(tempId);                 //해당 아이디 Id리스트에 저장
            result[i] = tempId + company;       //답에 저장
        }
        String answer="";
        for(int i=0; i< result.length;i++)
            if(i == result.length-1)
                answer+=str[i] + " <" + result[i] + ">";
            else
                answer+=str[i] + " <" + result[i] + ">, ";
        return answer;
    }

    public static void ioput() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String c = sc.nextLine();
        String solution = solution(s, c);
        System.out.println(solution);
    }

    public static void main(String[] args) {
        ioput();
    }
}
