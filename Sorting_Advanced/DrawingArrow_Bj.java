package Practice.src;

import java.util.*;

public class DrawingArrow_Bj {

    private static int N; // 점 개수
    private static int x, y; //x : 점 위치 y : 점 색깔
    private static HashMap<Integer, ArrayList<Integer>> place = new HashMap<>();
    private static boolean [] isUsed;
    private static int lengthSum = 0;

    public static void func(){

        for(int color : place.keySet()){
           Collections.sort(place.get(color));
        }
        for(int color : place.keySet()){

            ArrayList<Integer> targetColor = place.get(color);

            for(int i=0;i<place.get(color).size();i++)
                if(i-1<0)//첫 인덱스의 경우
                    lengthSum+=targetColor.get(i+1) - targetColor.get(i);
                else if(i+1==place.get(color).size())
                    lengthSum+=targetColor.get(i) - targetColor.get(i-1);
                else
                    if(targetColor.get(i+1) - targetColor.get(i)>targetColor.get(i)-targetColor.get(i-1))
                        lengthSum+=targetColor.get(i)-targetColor.get(i-1);
                    else
                        lengthSum+=targetColor.get(i+1) - targetColor.get(i);
        }
        System.out.println(lengthSum);
    }


    public static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        isUsed = new boolean[N];

        for(int i=0;i<N;i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            if(place.get(y)==null) {//이미 있는 색상이면
                place.put(y, new ArrayList<Integer>());
                place.get(y).add(x);
            }else
            place.get(y).add(x);
            sc.nextLine();
        }
    }

    public static void main(String[] args) {

        input();
        func();

    }
}
