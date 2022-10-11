package Nexon_Tutorial;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result2 {

    static HashMap<String, Integer> alpabets = new HashMap<>();//target 각 알파벳 개수 저

    public static int getMaximumRemovals(List<Integer> order, String source, String target) {
        // Write your code here
        ArrayList<Integer> subs = new ArrayList<>();

        for (int i = 0; i < target.length(); i++) {
            String st = target.split("")[i];

            if (alpabets.containsKey(st)) {
                alpabets.replace(st, alpabets.get(st) + 1);
                continue;
            }
            alpabets.put(st, 1);
        }
        int count = 0;
        String tempSource = source;

        for (int i = 0; i < order.size(); i++) {
            String thisAlpabet = source.split("")[order.get(i)-1];
            if (alpabets.containsKey(thisAlpabet)) {
                tempSource = tempSource.replaceFirst(thisAlpabet, "");
                if (!isPossible(tempSource))
                    return count;
            }//target : abbc //subs abbbccc
            count++;
        }
        return count;
    }

    private static boolean isPossible(String tempSource) {
        for(String key : alpabets.keySet()) {
            int thisNum = tempSource.length() - tempSource.replace(String.valueOf(key), "").length();

            if(thisNum<alpabets.get(key))
                return false;
        }
        return true;
    }

}

public class nexon2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int orderCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> order = IntStream.range(0, orderCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        String source = bufferedReader.readLine();

        String target = bufferedReader.readLine();

        int result = Result2.getMaximumRemovals(order, source, target);
        System.out.println(result);
    }
}
