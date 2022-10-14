package Programmers_SkillCheck_level2;

public class TargetNumber {

    int count = 0;

    public int solution(int[] numbers, int target) {
        int seq = 0;
        int sum = 0;

        dfs(seq + 1, sum + numbers[0], target, numbers);
        dfs(seq + 1, sum - numbers[0], target, numbers);

        int answer = count;
        return answer;
    }

    private void dfs(int seq, int sum, int target, int[] numbers) {

        if (seq == numbers.length) {
            if (sum == target)
                count++;
            return;
        }
        dfs(seq + 1, sum + numbers[seq], target, numbers);
        dfs(seq + 1, sum - numbers[seq], target, numbers);
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 1, 1};
        int tar1 = 3;
        int[] nums2 = {4, 1, 2, 1};
        int tar2 = 4;

        TargetNumber s = new TargetNumber();
        System.out.println(s.solution(nums1, tar1));
        s.count = 0;
        System.out.println(s.solution(nums2, tar2));
    }
}
