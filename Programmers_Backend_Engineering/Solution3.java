package Programmers_Backend_Engineering;

import java.util.*;

class Solution {
    public int[] solution(int[][] queries) {
        //전체 배열 길이를 구하고 짝수면 i, length - i -1 / 홀수면 length/2 +-i
        int[] answer = new int [queries.length];

        for(int i = 0; i < queries.length; i++) {
            int result = 0;
            if (queries[i].length % 2 == 0) {//짝수
                for (int j = 0; j < queries[i].length / 2; j++) {
                    while (queries[i][j] > queries[i][queries[i].length - 1 - j]) {
                        queries[i][j]--;
                        result++;
                    }
                    while (queries[i][j] < queries[i][queries[i].length - 1 - j]) {
                        queries[i][queries[i].length - j - 1]--;
                        result++;
                    }

                }
            } else {//홀수
                for (int j = 1; j <= queries[i].length / 2; j++) {
                    int center = queries[i].length / 2;

                    while (queries[i][center - j] > queries[i][center + j]) {
                        queries[i][center - j]--;
                        result++;
                    }
                    while (queries[i][center - j] < queries[i][center + j]) {
                        queries[i][center + j]--;
                        result++;
                    }
                }
            }
            answer[i] = result % 2;
            System.out.println("answer[" + i +"] = " + answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [][] arr = {{0,0,0,0,1},{5,4,3,2,1}, {0,1,0,1}, {1,3,2}};

        s.solution(arr);
    }
}
/*
— 코드를 입력하세요
BRANCH_ID, NAME, ID, SALARY
SELECT BRANCH_ID, NAME
FROM EMPLOYEES e JOIN (SELECT BRANCH_ID, MAX(SALARY)
                      FROM EMPLOYEES
                      GROUP BY BRANCH_ID) m
ON e.BRANCH_ID = m.BRANCH_ID
GROUP BY BRANCH_ID
ORDER BY BRANCH_ID, NAME ASC;
 */
