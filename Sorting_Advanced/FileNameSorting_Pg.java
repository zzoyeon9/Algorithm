package Practice.src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FileNameSorting_Pg {

    private static String[] files;

    public static void func(){

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //asd12asd221a
                String HEAD1 = o1.split("[0-9]")[0];
                String HEAD2 = o2.split("[0-9]")[0];
                String temp = o1.replaceAll(HEAD1,"");
                String NUMBER1="", NUMBER2="";

                for(char tmp : temp.toCharArray())
                    if(Character.isDigit(tmp) && NUMBER1.length()<5)
                        NUMBER1+=tmp;
                    else
                        break;
                temp = o2.replaceAll(HEAD2,"");

                for(char tmp : temp.toCharArray())
                    if(Character.isDigit(tmp) && NUMBER2.length()<5)
                        NUMBER2+=tmp;
                    else
                        break;

                    int result = HEAD1.toLowerCase().compareTo(HEAD2.toLowerCase());

                if(result==0) {
                    int num1 = Integer.parseInt(NUMBER1);
                    int num2 = Integer.parseInt(NUMBER2);
                    if (num1 > num2)
                        return 1;
                    else if (num1 < num2)
                        return -1;
                    else
                        return 0;
                }else
                    return result;
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