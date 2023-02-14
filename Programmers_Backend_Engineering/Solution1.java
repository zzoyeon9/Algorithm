package Programmers_Backend_Engineering;

import java.util.*;
class Solution1 {
    public int solution(int[][] lotteries) {

        double [] chance = new double [lotteries.length];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < lotteries.length; i++) {
            double winner = lotteries[i][0];
            double buyer = lotteries[i][1];
            int sum = lotteries[i][2];
            double probabilty = (winner / (buyer+1)) * 100.0;
            if(probabilty>100)
                probabilty=100.0;

            System.out.println("winner : " + winner + " buyer : " + buyer + " 당첨 확률 : " + probabilty);
            chance[i] = probabilty;
        }
        int answer = 0;
        double max = 0;
        int maxSum = 0;

        for(int i = 0; i < chance.length; i++) {
            if(chance[i] > max) {
                max = chance[i];
            }
        }

        for(int i = 0; i < chance.length; i++) {
            if(chance[i] == max) {
                if(maxSum<lotteries[i][2]){
                    maxSum = lotteries[i][2];
                    answer = i+1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int [][] arr= {{100,100,500}, {1000,1000,100}};
        System.out.println(s.solution(arr));
    }
}
