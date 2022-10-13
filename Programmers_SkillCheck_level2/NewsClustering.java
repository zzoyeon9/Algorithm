package Practice.src;

import java.util.ArrayList;
import java.util.Locale;

public class NewsClustering {

    //두 집합 A, B 사이의 자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의

    public int solution(String str1, String str2) {

        ArrayList<String> one = new ArrayList<>();
        ArrayList<String> thoOther = new ArrayList<>();
        ArrayList<String> both = new ArrayList<>();
        ArrayList<String> or = new ArrayList<>();

        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);

        for(int i=0;i<str1.length()-1;i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            if(first >= 'a' && first <='z' && second >= 'a' && second <='z')
                one.add("" + first + second);
        }

        for(int i=0;i<str2.length()-1;i++) {
           char first = str2.charAt(i);
           char second = str2.charAt(i+1);
           if(first >= 'a' && first <='z' && second >= 'a' && second <='z')
            thoOther.add("" + first + second);
        }
        or.addAll(one);
        or.addAll(thoOther);
        int index = one.size();

        for(int i=0;i<index;i++){
            if(thoOther.contains(one.get(i))) {
                both.add(one.get(i));
                thoOther.remove(one.get(i));
            }
        }


        double answer = ((double)both.size() / (double)(or.size()- both.size()));
        if(or.size() == 0)
            answer =1.0;
        int realAnswer = (int) (answer * 65536);
        return realAnswer;
    }

    public static void main(String[] args) {
        String str1 = "abc"; //ha an nd ds sh ha ak ke
        String str2 = "def";
        NewsClustering s = new NewsClustering();
        System.out.println(s.solution(str1,str2));
    }
}
