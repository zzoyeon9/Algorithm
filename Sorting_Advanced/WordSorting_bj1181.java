package Sorting_Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class WordSorting_bj1181 {

    private static int N;
    private static String [] dic;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<String> answer = new ArrayList<>();
    public static void func(){

        Arrays.sort(dic, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length())
                    return o1.length() - o2.length();
                else
                    return o1.compareTo(o2);
            }
        });

        for(int i=0;i<dic.length;i++){
            if(!answer.contains(dic[i])) {
                answer.add(dic[i]);
                sb.append(dic[i] + "\n");
            }
        }
        System.out.println(sb.toString());

    }

    public static void input() throws IOException {

        N = Integer.parseInt(br.readLine());
        dic = new String[N];
        for(int i=0;i<N;i++){
            dic[i] = br.readLine();
        }
    }

    public static void main(String[] args) throws IOException{

        input();
        func();
    }
}
