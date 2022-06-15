import java.util.ArrayList;

public class myStack<T> {
    private ArrayList<T> stack = new ArrayList<T>();
    private Integer count = 0;

public void push(T data)
{
    stack.add(data);
    count++;
}

public T pop()
{
    if(stack.isEmpty())
        return null;
    else {
        this.count--;
        return stack.remove(stack.size()-1);
    }
}

    public static void main(String[] args) {
        myStack<Integer> ms = new myStack<Integer>();
        ms.push(1);
        ms.push(2);
        System.out.println(ms.pop());
        ms.push(3);
        System.out.println(ms.pop());
        System.out.println(ms.pop());
    }

}



