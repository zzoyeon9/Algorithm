import java.util.ArrayList;

public class Nqueen {

    private boolean [][] possible;

    public Nqueen(int n){
        this.possible = new boolean[n][n];

    }

    public boolean isAvailable(ArrayList<Integer> candidate, Integer curCol){
        Integer curRow = candidate.size();
        for (int i=0; i<curRow; i++){
            if(candidate.get(i) == curCol || (Math.abs(candidate.get(i) - curCol) == curRow - i)) //수직 검사, 대각 검사
                return false;

        }
        return true;
    }
    public void Tracking(int n, int curRow, ArrayList<Integer> curCandidate){//1. DFS 탐색 2. promising(해당 루트 조건 검사) 3. Pruning(가지 치기)

       if(curRow == n){
           System.out.println(curCandidate);
           return;
       }
       for (int i=0; i<n; i++){//행의 모든 열을 체크
           if(this.isAvailable(curCandidate, i) == true){//퀸을 넣을 자리에 적합하다
               curCandidate.add(i);
               this.Tracking(n, curRow + 1, curCandidate);
               curCandidate.remove(curCandidate.size()-1);
           }

       }
    }

    public static void main(String[] args) {

        Nqueen obj = new Nqueen(4);
        obj.Tracking(4,0,new ArrayList<Integer>());
    }
}
