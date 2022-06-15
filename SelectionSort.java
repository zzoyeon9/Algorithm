import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {

    public void Sort(ArrayList<Integer> list){
        int min;
        for(int i=0; i<list.size()-1;i++){
            min = i;
            for(int j=i+1; j<list.size();j++)
                if(list.get(j)<list.get(min))
                    min = j;
            Collections.swap(list, min, i);
        }
    }

    public static void main(String [] args){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<30; i++)
            list.add((int)(Math.random()*100)+1);

        for(int i=0; i<30; i++)
            System.out.print(list.get(i)+ " ");

        SelectionSort ss = new SelectionSort();
        ss.Sort(list);

        System.out.println();

        for(int i=0; i<30; i++)
            System.out.print(list.get(i)+ " ");
    }
}
