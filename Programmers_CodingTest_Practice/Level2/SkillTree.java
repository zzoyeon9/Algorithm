package Programmers_CodingTest_Practice.Level2;

import java.util.*;

class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        List<Character> priorSkills = new LinkedList();
        int answer = 0;

        for(int i =0; i < skill.length(); i++)
            priorSkills.add(skill.charAt(i));

        for(int i = 0; i < skill_trees.length; i++) {
            List<Character> list = new LinkedList();
            String curSkillTree = skill_trees[i];
            boolean isPossible = true;

            for(int j = 0; j < curSkillTree.length(); j++) {
                char curSkill = curSkillTree.charAt(j);

                if(priorSkills.contains(curSkill)) {
                    if(list.size()==priorSkills.indexOf(curSkill)) {
                        list.add(curSkill);
                    }
                    else {
                        isPossible=false;
                        break;
                    }
                }
            }
            if(isPossible)
                answer++;
        }
        return answer;
    }
}