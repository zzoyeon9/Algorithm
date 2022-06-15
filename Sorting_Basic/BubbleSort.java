import java.util.ArrayList;

import java.util.Collections;

public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int i=0;i<dataList.size()-1;i++){
            boolean swap = false;

            for(int j=0;j<dataList.size()-1-i;j++){
                if(dataList.get(j) > dataList.get(j+1)) {
                    swap = true;
                    Collections.swap(dataList, j, j + 1);
                }
            }

            if(swap == false)
                break;
        }

        return dataList;
    }

    public static void main(String [] args){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<100; i++)
            list.add((int)(Math.random()*100)+1);

        for(int i=0; i<100; i++)
            System.out.print(list.get(i)+ " ");

        BubbleSort bs = new BubbleSort();
        bs.sort(list);

        System.out.println();

        for(int i=0; i<100; i++)
            System.out.print(list.get(i)+ " ");


    }
}
