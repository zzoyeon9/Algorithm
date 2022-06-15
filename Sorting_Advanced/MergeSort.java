import java.util.ArrayList;

public class MergeSort {




    //1. 분할 00000000 -> 0000 0000 -> 00 00 00 00 -> 0 0 0 0 0 0 0 0
    public static ArrayList<Integer> split(ArrayList<Integer> list){

        if(list.size()<=1)
            return list;

        int mid = list.size()/2;

        ArrayList<Integer> left;
        ArrayList<Integer> right;

        left = split(new ArrayList<>(list.subList(0, mid)));
        right = split(new ArrayList<>(list.subList(mid, list.size())));
        //2. 병합
        return merge(left, right);

    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){

        ArrayList<Integer> sorted = new ArrayList<>();

        while(!left.isEmpty() && !right.isEmpty())
            if(left.get(0)>=right.get(0))
                sorted.add(right.remove(0));
            else
                sorted.add(left.remove(0));


            while(right.size()!=0)
                sorted.add(right.remove(0));
            while(left.size()!=0)
                sorted.add(left.remove(0));

        System.out.println(sorted);
        return sorted;
    }

    public static void main(String[] args) {


            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < 16; i++)
                list.add((int) (Math.random() * 20 + 1));

            System.out.println(list);

            ArrayList<Integer> sorted = split(list);

            System.out.println(sorted);

    }

}
