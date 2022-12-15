package Programmers_CodingTest_Practice.Level2;

class TargetNumber {

    private int [] numbers;
    private int count = 0;
    private int max;
    private int target;

    public void dfs(int value, int cur) {

        if(cur==max) {
            if(value == target) {
                count++;
            }
            return;
        }
        dfs(value+numbers[cur], cur+1);
        dfs(value-numbers[cur], cur+1);
    }

    public int solution(int[] numbers, int target) {

        this.numbers = numbers;
        this.max = numbers.length;
        this.target = target;

        dfs(numbers[0], 1);
        dfs(-numbers[0], 1);

        int answer = count;
        return answer;
    }
}