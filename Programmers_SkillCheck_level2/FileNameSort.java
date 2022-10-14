package Programmers_SkillCheck_level2;

import java.util.*;

public class FileNameSort {

    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String str1 = o1.toLowerCase(Locale.ROOT);
                String str2 = o2.toLowerCase(Locale.ROOT);

                String head1 = str1.split("[0-9]")[0];
                String head2 = str2.split("[0-9]")[0];

                if(!head1.equals(head2))
                    return head1.compareTo(head2);

                String num1 = str1.substring(head1.length()).split("[^0-9]")[0];
                String num2 = str2.substring(head2.length()).split("[^0-9]")[0];

                while(num1.split("")[0].equals("0") && num1.length()>1)
                    num1 = num1.substring(1);

                while(num2.split("")[0].equals("0") && num2.length()>1)
                    num2 = num2.substring(1);

                if(!num1.equals(num2))
                    return Integer.parseInt(num1) - Integer.parseInt(num2);

                return 0;
            }
        });
        String[] answer = files;
        return answer;
    }

    public static void main(String[] args) {
        FileNameSort s = new FileNameSort();
        String [] arr = {"A0","AbC12","a1"};
        System.out.print(Arrays.toString(s.solution(arr)));
    }
}
