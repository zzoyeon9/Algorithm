package Practice.src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FileNameSorting {
    private static String NUMBER1="", NUMBER2="";
    private static String HEAD1, HEAD2;
    private static String[] files;

    public static void func(){

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
            //asd12asd221a
                HEAD1 = o1.split("[0-9]")[0];
                HEAD2 = o2.split("[0-9]")[0];

                String temp = o1.replaceAll(HEAD1,"");

                NUMBER1=""; NUMBER2="";

                while(temp.length()>0){
                    String isNum = temp.split("")[0];
                    if(isNum.matches("[0-9]")) {
                        NUMBER1 += temp.split("")[0];
                        temp = temp.substring(1, temp.length());
                    }
                    else
                        break;
                }
                temp = o2.replaceAll(HEAD2, "");

                while(temp.length()>0){
                    String isNum = temp.split("")[0];
                    if(isNum.matches("[0-9]")) {
                        NUMBER2 += temp.split("")[0];
                        temp = temp.substring(1, temp.length());
                    }
                    else
                        break;
                }
                HEAD1 = HEAD1.toUpperCase();
                HEAD2 = HEAD2.toUpperCase();
                int num1 = Integer.parseInt(NUMBER1);
                int num2 = Integer.parseInt(NUMBER2);
                if(HEAD1.compareTo(HEAD2)>0)
                    return 1;
                else if(HEAD1.compareTo(HEAD2)<0)
                    return -1;
                else
                    if(num1>num2)
                        return 1;
                    else if(num1<num2)
                        return -1;
                    else
                        return 0;
            }
        });
    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        files = sc.nextLine().replaceAll("\\[","").replaceAll("]","").split(", ");
    }

    public static void main(String[] args) {

        input();
        func();
        System.out.println(Arrays.toString(files));
    }
}
