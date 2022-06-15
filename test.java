public class test {
    public static void main(String[] args) {

        Edge a = new Edge("A",5);

        Edge b;

        b = a;
        a.distance=6;

        System.out.println(b.distance);

    }
}
