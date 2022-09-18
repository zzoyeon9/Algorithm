package Programmers_Backend_Engineering;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class Solution2 {

    PriorityQueue<Integer> ipList = new PriorityQueue<>();
    ArrayList<Integer> useList = new ArrayList<>();
    ArrayList<Integer> tempList = new ArrayList<>();
    int[] comHist;

    public String[] solution(int n, String[] queries) {
        comHist = new int[queries.length + 1];
        String ipFrame = "192.168.0.";
        String reject = "reject";
        ArrayList<String> tempAnswer = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            ipList.add(i);

        for (int i = 0; i < queries.length; i++) {
            String input = queries[i];
            String com = input.split(" ")[0];
            int comNum = Integer.parseInt(com.split("")[com.length() - 1]);
            String api = input.split(" ")[1];

            if (api.equals("request")) {            //할당 요청이면
                if (ipList.isEmpty())               //현재 남은 ip가 없으면
                    tempAnswer.add(com + " " + reject); //ip할당 거절
                else                                //ip가 있으면
                    if (comHist[comNum] != 0)          //이미 한번 할당받았던 컴퓨터라면
                        if (ipList.contains(comHist[comNum])) {//전에 할당받았던 ip가 현재 남아있다면
                            while(ipList.peek()!=comHist[comNum]){//전에 할당받았던 ip가 나올때까지 뒤지고
                                tempList.add(ipList.poll());    //뒤진 ip를 임시 리스트에 저장
                            }
                            int ipNum = ipList.poll();          //나왔다면 할당받았던 ip 저장
                            while(!tempList.isEmpty())          //그리고 임시 리스트가 없어질떄까지
                                ipList.add(tempList.remove(0));//뒤졌던 ip 싹다 원복
                            tempAnswer.add(com + " " + ipFrame + ipNum);//할당
                            useList.add(ipNum);                     //사용중인 ip 리스트에 기
                        }
                        else {                                //전에 할당받았던 ip가 이미 사용중이라면
                            int ipNum = ipList.poll();
                            tempAnswer.add(com + " " + ipFrame + ipNum);//남은 ip중 젤 작은거 할당
                            comHist[comNum] = ipNum;                //새로 할당 받은 ip 기록 삽입록
                            useList.add(ipNum);
                        }
                    else {                                          //처음 할당 받는 컴퓨터라면
                        int ipNum = ipList.poll();
                        tempAnswer.add(com + " " + ipFrame + ipNum);
                        comHist[comNum] = ipNum;
                        useList.add(ipNum);
                    }
            }
            else{//할당 해제 요청이면
                useList.remove(Integer.valueOf(comHist[comNum]));
                ipList.add(comHist[comNum]);
            }
        }
        String[] answer = tempAnswer.toArray(new String[tempAnswer.size()]);
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        String [] queries = {"desktop1 request", "desktop2 request", "desktop3 request",
                "desktop2 release", "desktop3 release", "desktop3 request", "desktop1 release"
        , "desktop4 request"};
        Solution2 s = new Solution2();
        String [] answers = s.solution(n,queries);
        for(int i=0;i< answers.length;i++)
            System.out.print(answers[i] + " ");
    }
}
