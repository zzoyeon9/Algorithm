package Practice.src;

public class Test3 {

    public int func(String[] games) {

        String result;
        int homeScore, awayScore, answer=0;

        for (int i = 0; i < games.length; i++) {

            result = games[i].replaceAll("\"", "");

            homeScore = Integer.parseInt(result.split(":")[0]);
            awayScore = Integer.parseInt(result.split(":")[1]);

            if(homeScore>awayScore)
                answer+=3;
            else if(homeScore==awayScore)
                answer+=1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Test3 t3 = new Test3();
        String [] arr = {"2:2", "1:3", "0:0", "2:2", "1:3", "0:0", "3:1", "4:2", "4:4", "1:2" };
        t3.func(arr);
    }
}
