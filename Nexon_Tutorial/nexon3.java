package Nexon_Tutorial;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result3 {

    /*
     * Complete the 'getMinimumHealth' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY initial_players
     *  2. INTEGER_ARRAY new_players
     *  3. INTEGER rank
     */

    public static long getMinimumHealth(List<Integer> initial_players, List<Integer> new_players, int rank) {
        // Write your code here
        long requestPower=0;
        Collections.sort(initial_players, Collections.reverseOrder());
        requestPower+=initial_players.get(rank-1);
        for(int i=0;i<new_players.size();i++){
            initial_players.add(new_players.get(i));
            Collections.sort(initial_players, Collections.reverseOrder());
            requestPower+=initial_players.get(rank-1);
        }
        return requestPower;
    }//432211   1+2+2+3

}
public class nexon3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int initial_playersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> initial_players = IntStream.range(0, initial_playersCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int new_playersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> new_players = IntStream.range(0, new_playersCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int rank = Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result3.getMinimumHealth(initial_players, new_players, rank);
        System.out.println(result);
    }
}
