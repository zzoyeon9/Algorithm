package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrinterQueue {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int solution(int N, int M) throws IOException {

        StringTokenizer st =  new StringTokenizer(br.readLine(), " ");
        Queue<int []> que = new LinkedList<>();

        for(int i = 0; i < N; i++){
            que.add(new int [] {i, Integer.parseInt(st.nextToken())});
        }
        int count=0;
        while(true) {

            int[] idx_imp = que.poll();
            boolean isBiggest = true;

            for(int [] ele : que) {    //2번쨰가 타겟 ///23165
                if(idx_imp[1] < ele[1]) {
                    isBiggest = false;
                    break;
                }
            }

            if(isBiggest) {
                count++;
                if(idx_imp[0] == M)
                    break;
            }else {
                que.add(idx_imp);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        PrinterQueue pq = new PrinterQueue();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        for(int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = st.nextToken().charAt(0)-'0';
            int M = st.nextToken().charAt(2)-'0';
            System.out.println(pq.solution(N, M));
        }
    }
}