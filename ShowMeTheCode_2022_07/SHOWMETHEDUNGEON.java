package Practice.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public class SHOWMETHEDUNGEON {

    static int N, K, sum;
    static Integer [] monHp, peopleNum;
    static Double [] efficiency;
    static Boolean [] isVisit;
    static ArrayList<Integer> goodChoice;

    public static void func(){
        //1. 효율이 좋은 순서대로 정렬
        for(int i=0;i<N;i++)
            efficiency[i] = (double) peopleNum[i] / (double) monHp[i];

        Arrays.sort(efficiency, Collections.reverseOrder());

        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                if((double) peopleNum[j] / (double) monHp[j] == efficiency[i])
                    goodChoice.add(j);

        int count = 0;
        while (count<5) {
            if (K > monHp[goodChoice.get(count)] && !isVisit[goodChoice.get(count)]) {
                int index = goodChoice.get(count);
                isVisit[index]=true;
                K -= monHp[index];
                sum += peopleNum[index];
            }
            else
                count++;
        }

    }
    public static void output(){
        System.out.println(sum);
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();
        K = sc.nextInt();
        sum=0;
        sc.nextLine();

        monHp = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        peopleNum = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        efficiency = new Double[N];
        isVisit = new Boolean[N];

        for(int i=0;i<isVisit.length;i++)
            isVisit[i]=false;

        goodChoice = new ArrayList<Integer>();

    }

    public static void main(String[] args) {
        input();
        func();
        output();
    }

}
