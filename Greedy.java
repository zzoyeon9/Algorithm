import java.util.Arrays;
import java.util.Comparator;

public class Greedy {

    public void knapsackFunc(Integer [][] objectList, double capacity){
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return (o2[1]/o2[0]) - (o1[1]/o1[0]);
            }
        });

        for(int i=0; i<objectList.length; i++)
            if(capacity - (double)objectList[i][0]>0) {
                capacity -= (double) objectList[i][0];
                totalValue += (double)objectList[i][1];
                System.out.println("무게 : " + objectList[i][0] + " 가치 : " + objectList[i][1]);
            }
            else{
                fraction = capacity/(double) objectList[i][0];
                totalValue += (double) objectList[i][1]*fraction;
                System.out.println("무게 : " + objectList[i][0] + " 가치 : " + objectList[i][1] + " 비율 : " + fraction);
                break;
            }
        System.out.println("총 담을 수 있는 가치 : " + totalValue);
    }

    public static void main(String[] args) {
        Greedy gObject = new Greedy();
        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        gObject.knapsackFunc(objectList, 30);
    }
}
