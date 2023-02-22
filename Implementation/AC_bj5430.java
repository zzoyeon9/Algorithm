package Implementation;

import java.io.*;
import java.util.*;

public class AC_bj5430 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int isReverse = 0;
    private static boolean isError = false;

    public void ac(String str, Deque<String> myList) {

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='D'){
                if(myList.isEmpty()) {
                    System.out.println("ERROR");
                    isError = true;
                    return;
                }

                if(isReverse%2==0)
                    myList.pollFirst();
                else
                    myList.pollLast();
            }
            else {
                isReverse++;
            }
        }
    }

    public void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
            Deque<String> myList = new ArrayDeque<>();

            for(int j = 0; j < n; j++)
                myList.add(st.nextToken());

            isReverse=0;
            isError = false;
            ac(str, myList);

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while(!myList.isEmpty()){
                if(isReverse%2==0)
                    sb.append(myList.pollFirst());
                else
                    sb.append(myList.pollLast());
                if(!myList.isEmpty())
                    sb.append(",");
            }
            sb.append("]");
            if(!isError)
                System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        AC_bj5430 m = new AC_bj5430();
        m.solution();
    }
}