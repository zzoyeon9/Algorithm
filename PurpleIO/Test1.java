package Practice.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

    public int func(int input) {
        int quarter= (input/4) + 1;
        return quarter;
    }

    public int input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        return input;
    }

    public static void main(String[] args) throws IOException{
        Test1 t = new Test1();
        int num = t.input();
        t.func(num);
    }
}