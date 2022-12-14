package Programmers_CodingTest_Practice.Level2;

import java.util.*;

class CandiKey {

    private int row, col;
    private HashSet<String> usedCombis;
    private String [][] relation;

    public boolean isMinimal(String combis) {

        for(String str : usedCombis) {
            boolean flag = true;
            for(int i = 0; i < str.length(); i++){
                if(!combis.contains(str.charAt(i)+"")) {
                    flag = false;
                }
            }
            if(flag)
                return false;
        }
        return true;
    }

    public boolean isUnique(String combis) {

        HashSet<String> values = new HashSet();
        int [] cols = new int[combis.length()];

        for(int i = 0; i < combis.length(); i++) {
            cols[i] = combis.charAt(i)-'0';
        }

        for(int i = 0; i < row; i++) {
            String temp="";

            for(int j = 0; j < cols.length; j++) {
                temp += relation[i][cols[j]];
            }

            if(values.contains(temp)) {
                return false;
            }
            values.add(temp);
        }
        return true;
    }

    public void search(String combis, int cur, int max) {

        if(combis.length()==max) {
            if(isUnique(combis) && isMinimal(combis)) {
                usedCombis.add(combis);
            }
            return;
        }

        for(int i = cur; i < col; i++) {
            search(combis+String.valueOf(i),i+1, max);
        }
    }

    public int solution(String[][] relation) {

        this.relation = relation;
        this.row = relation.length;
        this.col = relation[0].length;
        usedCombis = new HashSet();

        for(int i = 1; i <= col; i++) {
            search("", 0, i);
        }

        int answer = usedCombis.size();
        return answer;
    }
}