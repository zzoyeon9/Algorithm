package Practice.src;

import java.util.Arrays;
import java.util.Scanner;

public class MakingPassword_Bj {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int L, C, consonant = 0, vowel = 0;
    static String[] alphabet;
    static boolean[] isUsed;

    public static void func(int seq, String pw, int cons, int vowel) {

        if (pw.length() == L) {
            if (cons > 0 && vowel > 1)
                sb.append(pw + "\n");
        } else {
            for (int i = seq; i < C; i++)
                if (!isUsed[i]) {
                    isUsed[i] = true;
                    if (alphabet[i].contains("a") || alphabet[i].contains("e") || alphabet[i].contains("i") || alphabet[i].contains("o") || alphabet[i].contains("u")) {
                        func(i + 1, pw + alphabet[i], ++cons, vowel);
                        cons--;
                    }
                    else {
                        func(i + 1, pw + alphabet[i], cons, ++vowel);
                        vowel--;
                    }
                    isUsed[i] = false;
                }
        }
    }

    public static void input() {
        L = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        isUsed = new boolean[C];
        alphabet = sc.nextLine().split(" ");
    }

    public static void main(String[] args) {

        input();
        Arrays.sort(alphabet);
        func(0, "", consonant, vowel);
        System.out.print(sb.toString());
    }
}