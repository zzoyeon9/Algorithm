package SocarCordingTest202208;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution2 {
    /*
    public int[] solution(int n, int m, String [] survey){
       //1. 각 앱 별로 최근 5일 내 이용한 시간, 전체 시간을 조사해서 1차원 배열에 저장하자.
       //2. 삭제 할 앱 번호를 오름차순으로 1차원 정수 배열에 담아서 리턴하자

        HashMap<String, HashMap<String, Integer>> goods_grade_num = new HashMap<>();

        for(int i=0;i<survey.length;i++) {

            String goods = survey[i].split(" ")[0];
            String grade = survey[i].split(" ")[1];
            if(!goods_grade_num.containsKey(goods))
                goods_grade_num.put(goods, new HashMap<>());
            if(!goods_grade_num.get(goods).containsKey(grade))
                goods_grade_num.get(goods).put(grade, 0);
            goods_grade_num.get(goods).replace(grade, goods_grade_num.get(goods).get(grade)+1);

        }

        for(String goods : goods_grade_num.keySet()) {
            int first_count=0;
            int second_count=0;
            int third_count=0;
            int grades_count=0;
            HashMap<String, ArrayList<String>> goods_grade = new HashMap<>();
            for (String grade : goods_grade_num.get(goods).keySet()){//상품_등급_해당 등급 개수 해시맵 순회
                grades_count = goods_grade_num.get(goods).get(grade);//현재 상품의 현재 등급 개수
                if(first_count<grades_count) {//1순위 등급 개수보다 많으면
                    if (!goods_grade.containsKey(goods))
                        goods_grade.put(goods, new ArrayList<>());
                    first_count = grades_count;//1순위 등급 개수 갱신
                    if(!goods_grade.get(goods).contains(grade))//해당 등급이 처음 들어가는거라면
                        goods_grade.get(goods).add(grade);
                    else
                        goods_grade.get(goods).set(0,grade); //해당 등급 개수 갱신
                }
                else if(first_count>grades_count && second_count<grades_count) {
                    if (!goods_grade.containsKey(goods))
                        goods_grade.put(goods, new ArrayList<>());
                    second_count = grades_count;//1순위 등급 개수 갱신
                    if(!goods_grade.get(goods).contains(grade))//해당 등급이 처음 들어가는거라면
                        goods_grade.get(goods).add(grade);
                    else
                        goods_grade.get(goods).set(1,grade); //해당 등급 개수 갱신
                }
            }

        }
    }
*/
}
