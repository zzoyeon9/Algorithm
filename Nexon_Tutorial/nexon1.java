package Nexon_Tutorial;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result1 {

    /*
     * Complete the 'minNum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER samDaily
     *  2. INTEGER kellyDaily
     *  3. INTEGER difference
     */

    public static int minNum(int samDaily, int kellyDaily, int difference) {

        if(kellyDaily<=samDaily)
            return -1;
        else{
            int count=1;
            int samSolves = samDaily + difference;
            int kellySolves = kellyDaily;

            while(samSolves>=kellySolves){
                samSolves+=samDaily;
                kellySolves+=kellyDaily;
                count++;
            }
            return count;
        }
    }
}

public class nexon1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int samDaily = Integer.parseInt(bufferedReader.readLine());
        int kellyDaily = Integer.parseInt(bufferedReader.readLine());
        int difference = Integer.parseInt(bufferedReader.readLine());

        int result = Result1.minNum(samDaily, kellyDaily, difference);

        System.out.println(result);
    }
}