import java.util.ArrayList;

public class RecursiveCall {

    public int operation(int n){
        if(n==1)
            return 1;
        else if(n==2)
            return 2;
        else if(n==3)
            return 4;
        return operation(n-1) + operation(n-2) + operation(n-3);
    }


    public static void main(String[] args) {
        RecursiveCall a = new RecursiveCall();

        System.out.println(a.operation(6));
    }
}
