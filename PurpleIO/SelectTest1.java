package Practice.src;

public class SelectTest1 {

    public int func(String str) {
        int beforeStrLength = str.length();
        int afterStrLength = str.replaceAll("a", "")
                .replaceAll("e", "")
                .replaceAll("i", "")
                .replaceAll("o", "")
                .replaceAll("u", "").length();

        return beforeStrLength - afterStrLength;
    }

    public static void main(String[] args) {
        SelectTest1 selectTest1 = new SelectTest1();
        String str = "abebabiboebabu";
        selectTest1.func(str);
    }
}
