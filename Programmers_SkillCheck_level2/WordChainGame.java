package Programmers_SkillCheck_level2;

import java.util.ArrayList;

public class WordChainGame {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> usedWords = new ArrayList<>();
        int seq=1;
        int round=1;
        for(int i=0;i< words.length;i++){//7명
            if(i%n==0 && i!=0) {
                seq = 1;
                round++;
            }
            if(i>0) {
                int last = words[i - 1].length() - 1;
                if (usedWords.contains(words[i]) || (words[i].charAt(0) != words[i-1].charAt(last))) {
                    answer[0] = seq;
                    answer[1] = round;
                    break;
                }
            }
            usedWords.add(words[i]);
            seq++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String [] arr = {"hello", "one", "even", "never", "now", "world", "draw"};
        int n = 2;
        WordChainGame s = new WordChainGame();
        int [] answer =  s.solution(n,arr);
        System.out.println("{" + answer[0] + "," + answer[1] + "}");
    }
}
