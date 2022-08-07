package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static String[] seq;

    public static void func() {

        ArrayList<String> isExistedIdx = new ArrayList<>();
        ArrayList<String> isExisted = new ArrayList<>();
        int left = 0, right = 0, count = 0;

        while (left < seq.length) {
            String indexs="";

            if (right < seq.length) // 더 탐색할 구간이 있다면
                while(isPossible(right, isExistedIdx, isExisted)) { // 이번 인덱스를 추가했을 때 기존에 없던 인덱스 조합이면서 중복된 수가 없다면 (해당 검사 메서드 구현)
                    indexs+=String.valueOf(right); //현재 인덱스 조합에 추가해주고
                    isExistedIdx.add(indexs);// 인덱스 조합 리스트에 등록
                    isExisted.add(seq[right++]); // 사용된 숫자 리스트에 등록
                    count++; //새로운 경우의 수니까 카운트 세기
                }
            while(left<r) { // 이번 인덱스를 추가했을 때 기존에 없던 인덱스 조합이면서 중복된 수가 없다면 (해당 검사 메서드 구현)
                indexs+=String.valueOf(right); //현재 인덱스 조합에 추가해주고
                isExistedIdx.add(indexs);// 인덱스 조합 리스트에 등록
                isExisted.add(seq[right++]); // 사용된 숫자 리스트에 등록
                count++; //새로운 경우의 수니까 카운트 세기
            }
            left++;
        }

    }

    private static boolean isPossible(int index, ArrayList<String> isExistedIdx, ArrayList<String> isExisted) {
        //1. 그 인덱스 조합이 있는지 확인 2. 동일한 숫자가 있는지 확인
        return (!isExistedIdx.contains(String.valueOf(index)) && !isExisted.contains(seq[index]));
    }

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        seq = br.readLine().split(" ");
    }

    public static void main(String[] args) throws IOException {

    }
}