package Practice.src;

public class Test4 {

    public String func(int n, String str) {

        String[] strNum = String.valueOf(n).split("");
        int num, sum = 0;

        for (int i = 0; i < strNum.length; i++) {
            sum += Integer.parseInt(strNum[i]);
        }
        num = n - sum;
        System.out.println("num = " + num);

        while (num > 23)
            num -= 23;

        String seq = String.valueOf(num);
        String answer="";
        String [] strArr = str.split("\n");

        for (int i = 0; i < strArr.length; i++)
            if (strArr[i].split("-")[0].equals(seq)) {
                answer = strArr[i].split("-")[1];
                break;
            }

        return answer;
    }

    public static void main(String[] args) {
        Test4 t4 = new Test4();
        int num = 99;
        String str = "1-kiwi\n" + "2-pear\n" + "3-kiwi\n" + "4-banana\n" +
                "5-melon\n" + "6-banana\n" + "7-melon\n" + "8-pineapple\n" +
                "9-apple\n" + "10-pineapple\n" + "11-cucumber\n" + "12-pineapple\n" +
                "13-cucumber\n" + "14-orange\n" + "15-grape\n" + "16-orange\n" +
                "17-grape\n" + "18-apple\n" + "19-grape\n" + "20-cherry\n" +
                "21-pear\n" + "22-cherry\n" + "23-pear";//배열로의 구현 없이 과일 코드를 그대로 복사해서 사용하도록 의도한 듯하여
                                                        //단순 string으로 구현 후, 함수 안에서 배열을 구현하였습니다.
        t4.func(num, str);
    }
}