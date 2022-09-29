package Programmers_SkillCheck_level2;

import java.util.ArrayList;

public class Solution1 {

    private ArrayList<String> requiredList;
    private ArrayList<String> thisTree;

    public int solution(String skill, String[] skill_trees) {
        int count = 0;

        //배울 스킬이 선행 스킬에 속하면 arrayList에 넣어두기
        //스킬을 하나씩 배울때마다 선행 스킬이 필요한 스킬인지 확인
        //해당 스킬의 선행스킬을 이미 배웠는지 확인 후 배웠으면 진행, 안배웠으면 false 리턴
        for (int i = 0; i < skill_trees.length; i++) {
            requiredList = new ArrayList<>();
            thisTree = new ArrayList<>();

            for (int j = 0; j < skill_trees[i].length(); j++) {
                String target = skill_trees[i].split("")[j];

                if (skill.contains(target))//이번에 배울 스킬이 선행 스킬이면
                    if (isPossible(skill, target)) //배울 수 있는 스킬이면
                        requiredList.add(target);
                    else//스킬트리를 위반하면
                        break;

                thisTree.add(target);
            }
            if(thisTree.size()==skill_trees[i].length())
                count++;
        }
        int answer = count;
        return answer;
    }

    private boolean isPossible(String skill, String target) {
        for (int i = 0; i < skill.length(); i++) {
            if (!skill.split("")[i].equals(target))
                continue;
            if (requiredList.size() == i)
                return true;
            else
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] st = {"BACDE", "CBADF", "AECB", "BDA"};
        String s = "CBD";
        Solution1 a = new Solution1();
        System.out.println(a.solution(s, st));
    }
}
