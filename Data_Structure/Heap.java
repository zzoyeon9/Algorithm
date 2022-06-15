import java.util.ArrayList;
import java.util.Collections;

public class Heap {

    private ArrayList<Integer> heapArray = null;

    public Heap (Integer data){
        heapArray = new ArrayList<Integer>();

        heapArray.add(null);
        heapArray.add(data);
    }

    public boolean move_up(Integer inserted_idx){
        if(inserted_idx <= 1){
            return false;
        }
        Integer parent_idx = inserted_idx/2;
        if(this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)){
            return true;
        }else{
            return false;
        }
    }

    public boolean insert(Integer data){
        Integer inserted_idx, parent_idx;
        if(heapArray==null){
            heapArray = new ArrayList<Integer>();

            heapArray.add(null);
            heapArray.add(data);
        }
        this.heapArray.add(data);

        inserted_idx = this.heapArray.size()-1;

        while(this.move_up(inserted_idx)){//조건 검사 결과, 바뀌어야한다면
            parent_idx = inserted_idx/2;
            Collections.swap(this.heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }

        return true;
    }
    public Integer pop(){
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;

        if(this.heapArray.size() <= 1)
            return null;

            returned_data = this.heapArray.get(1);
            this.heapArray.set(1, heapArray.get(this.heapArray.size()-1));
            this.heapArray.remove(heapArray.size()-1);
            popped_idx = 1;

            while(move_down(popped_idx)){
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 + 1;

                //CASE 2 : 오른쪽 자식 노드만 없을 때
                if(right_child_popped_idx >= this.heapArray.size()) {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                }
                else //CASE 3 : 양쪽 자식 노드 모두 있을 때
                    if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                            Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                            popped_idx = left_child_popped_idx;
                        }
                    }
                    else
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                            Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
                            popped_idx = right_child_popped_idx;
                        }
            }
            return returned_data;
    }

    public boolean move_down(Integer popped_idx){

        Integer left_child_popped_idx,right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        //CASE 1 : 왼쪽 자식 노드도 없을 때(자식 노드가 아예 없을 때)
        if(left_child_popped_idx >=this.heapArray.size())
            return false;
        //CASE 2 : 오른쪽 자식 노드만 없을 때
        else if(right_child_popped_idx >= this.heapArray.size())
            if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(popped_idx))
                return true;
            else
                return false;
        else//CASE 3 : 양쪽 자식 노드가 모두 있을 때
            if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx))
                if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx))
                    return true;
                else
                    return false;
            else
                if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx))
                    return true;
                else
                    return false;

    }
    public static void main(String [] args){
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);

        System.out.println(heapTest.heapArray);
        System.out.println(heapTest.heapArray);
        System.out.println(heapTest.pop());

        System.out.println(heapTest.heapArray);
    }
}
