package Programmers_CodingTest_Practice.Level2;


class Tiling3xN  {
    public long solution(int n) {
        //n=1 -> 0 n=2 -> 3 n=3 -> 0 n=4 -> 11
        //0->3->0->11->0->41
        long num=0;
        long [] answers = new long[n+1];

        for(int i = 0; i<=n; i++) {
            if(i%2!=0 || i<2) {
                answers[i]=0;
                continue;
            }
            if(i==2) {
                answers[i]=3;
            }else if(i==4) {
                answers[i]=11;
            }else {
                if(4*answers[i-2]>=answers[i-4]) {
                    answers[i] = (4*answers[i-2] - answers[i-4])%1000000007;
                }else {
                    answers[i] = (answers[i-4] - 4*answers[i-2])%1000000007;
                }
            }

        }
        long answer = answers[n]%1000000007;
        return answer;
    }
}

