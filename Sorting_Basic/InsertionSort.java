import java.util.ArrayList;

import java.util.Collections;

public class InsertionSort {

    public void sort(ArrayList<Integer> dataList){

        for(int i=1; i<dataList.size();i++){
            for(int j=i;j>0;j--){
                if(dataList.get(j)<dataList.get(j-1))
                    Collections.swap(dataList,j,(j-1));
                else
                    break;
            }
        }

    }

    public static void main(String [] args){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<30; i++)
            list.add((int)(Math.random()*100)+1);

        for(int i=0; i<30; i++)
            System.out.print(list.get(i)+ " ");

        InsertionSort is = new InsertionSort();
        is.sort(list);

        System.out.println();

        for(int i=0; i<30; i++)
            System.out.print(list.get(i)+ " ");


    }
}
