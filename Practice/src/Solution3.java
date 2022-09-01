package Practice.src;

public class Solution3 {
    //홀, 짝이 서로 다른 수일 경우

    public boolean isPossible(int[] A, int left, int right) {
        int odd = 0, even = 0;
        if ((right - left) % 2 == 0 && left != right) {
            odd = A[left];
            even = A[left + 1];
        } else {
            odd = A[left];
            even = A[right];
        }

        if (odd == even)//홀,짝이 같은 수일 경우
            for (int i = left; i <= right; i++) {
                if (A[i] != odd)
                    return false;
            }
        else {//홀, 짝이 서로 다른 수일 경우
            for (int i = left; i <= right; i = i + 2)
                if (A[i] != odd)
                    return false;

            for (int i = left + 1; i <= right; i = i + 2)
                if (A[i] != even)
                    return false;
        }
        return true;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int L = 0, R = 0;
        int answer = 0;

        while (L <= R && R < A.length) {
            if (isPossible(A, L, R)) {//L ~ R까지 거리가 배열 스위칭을 만족한다면
                answer = Math.max(answer, (R - L + 1));//최대 값 갱신
                R++;                              //R을 늘리기
            } else
                L++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] arr = {{3,-7,3,-7,3,-7,-7,3,-7,-7,3},{5,5,4,5,4},{3,-7,3,-7},{3,-7,3,-7,3}};
        Solution3 a = new Solution3();
        for(int i=0;i<4;i++)
        System.out.println(a.solution(arr[i]));

    }
}
