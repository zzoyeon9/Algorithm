package Implementation;

import java.util.*;
import java.io.*;

public class Statistics_bj2108 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Statistics_bj2108 m = new Statistics_bj2108();
        m.solution(arr);
    }

    private void solution(int [] arr) {

        Map<Integer, Integer> num_count = new HashMap<>();
        int[] clone = arr.clone();
        Arrays.sort(clone);

        double ave = 0;
        int max = -4001, min = 4001;
        int cenVal = clone[clone.length/2];
        int mode = 0;

        for(int i = 0; i < arr.length; i++) {
            ave += arr[i];
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

            num_count.put(arr[i], num_count.getOrDefault(arr[i],0) + 1);
        }//555 444 333 222 / 5 4 3 2
        int mostFre = 0;
        ave = Math.round(ave /= arr.length);

        for(int key : num_count.keySet()) {//최고 빈도수 파악
            int numCount = num_count.get(key);
            mostFre = Math.max(mostFre, numCount);
        }

        List<Integer> mostFreNums = new ArrayList<>();

        for(int key : num_count.keySet()) {
            if(num_count.get(key)==mostFre)
                mostFreNums.add(key);
        }

        if(mostFreNums.size()==1) {
            mode = mostFreNums.remove(0);
        }
        else {
            Collections.sort(mostFreNums);
            mode = mostFreNums.get(1);
        }
        int bounds = max - min;

        System.out.println((int)ave);
        System.out.println(cenVal);
        System.out.println(mode);
        System.out.println(bounds);
    }
}