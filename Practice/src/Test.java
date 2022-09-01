package Practice.src;

public class Test {
    int a=0;
    public static void main(String[] args) {
        Test a = new Test();
        Test b = a;
        System.out.println(b.a);
        a.a=5;
        System.out.println(b.a);

    }
}
