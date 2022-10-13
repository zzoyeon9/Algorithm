package Practice.src;

public class FibonacciDP {

    public int solution(int n) {

        int [] fibo = new int[n+1];
        fibo[0]=0; fibo[1]=1;

        for(int i=2;i<=n;i++)
            fibo[i] = (fibo[i-2] + fibo[i-1])%1234567; // 0 + 1 / 1 + 2 / 2 + 3/

        int answer = fibo[n];

        return answer;
    }

    public static void main(String[] args) {
        FibonacciDP s = new FibonacciDP();
        System.out.println(s.solution(100000));


    }
}
