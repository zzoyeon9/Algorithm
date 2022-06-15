import java.util.ArrayList;

public class myQueue<T> {

    private ArrayList<T> queue = new ArrayList<T>();

    public static void main(String[] args) {

        myQueue<Integer> a = new myQueue<Integer>();
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
    }

    public void enqueue(T data)
    {
        queue.add(data);
    }

    public T dequeue()
    {
        if(queue.isEmpty())
            return null;
        else
            return queue.remove(0);
    }
}
