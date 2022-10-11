package Practice.src;

public class Solution {

    public int solution(String[] maps) {
        int answer = 0;
        String [][] map = new String[maps.length][maps[0].length()];
        boolean [][] isVisit = new boolean[maps.length][maps[0].length()];
        int [] sumCount = new int[26];

        for(int i=0;i< maps.length;i++)
            map[i] = maps[i].split("");

        for(int i=0;i<map.length;i++){

            for(int j=0;j<map[i].length;j++){//map 탐색
                int [] count = new int[26];
                if(map[i][j].equals("."))
                    continue;
                if(isVisit[i][j])
                    continue;
                isVisit[i][j]=true;
                dfs(i,j,isVisit,map,count);//전쟁일으킴

                int biggestAlpabet=0;
                int biggestcount=0;

                for(int k=0;k<count.length;k++){//제일 영토가 많은 나라 추출
                    if(count[k]>=biggestcount) {
                        biggestcount = count[k];
                        biggestAlpabet = k;
                    }
                }
                int sum=0;
                for(int k=0;k<count.length;k++) {//제일 영토가 많은 나라에 합병
                    if (count[k] < biggestcount) {
                        sum += count[k];
                        count[k]=0;
                    }
                }
                count[biggestAlpabet] += sum;

                for(int k=0;k<26;k++)
                    sumCount[k] += count[k];
            }
        }
        int biggestcount=0;
        int biggestAlpabet=0;
        for(int k=0;k<sumCount.length;k++){//제일 영토가 많은 나라 추출
            if(sumCount[k]>=biggestcount)
                biggestcount=sumCount[k];
            biggestAlpabet=k;
        }
        return biggestcount;
    }

    private void dfs(int y, int x, boolean[][] isVisit, String[][] map, int [] count) {
        int [][] dir = {{0,-1}, {0,1}, {-1,0}, {1,0}};

        if(!map[y][x].equals(".")) {

            count[(int) (map[y][x].charAt(0) - 65)]++;
        }
        for(int i=0;i<4;i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx<0 || nx >= map[0].length || ny<0 || ny >= map.length)
                continue;
            if(map[ny][nx].equals("."))
                continue;
            if(isVisit[ny][nx])
                continue;

            isVisit[ny][nx]=true;
            dfs(ny,nx,isVisit,map,count);


        }
    }


    public static void main(String[] args) {
        Solution a = new Solution();
        String [] maps = {"AABCA.QA", "AABC..QX", "BBBC.Y..", ".A...T.A", "....EE..",
                ".M.XXEXQ","KL.TBBBQ"};
        System.out.println(a.solution(maps));
    }
}
