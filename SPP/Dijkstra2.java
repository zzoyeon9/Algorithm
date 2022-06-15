package asdasd;

import java.util.Scanner;

public class Dijkstra2 {

	static int legionnum, itemnum, goldnum;
	static int [] shortestpath;
	static String [] itemlocation; static String [][] map;
	static boolean [] visited; 
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		legionnum = input.nextInt();
		input.nextLine();

		map = new String[legionnum][legionnum];
		shortestpath = new int[legionnum];
		
		for(int i=0;i<legionnum;i++) {
			String temp = input.nextLine();
			map[i] = temp.substring(temp.indexOf(":")+2).split(" ");
		}
		itemnum = input.nextInt();
		input.nextLine();

		itemlocation = new String[itemnum];
		shortestpath = new int[legionnum];
		
		for(int i=0;i<itemnum;i++)
			itemlocation[i]=input.nextLine();
		
		for(int i=0;i<itemnum;i++) {
			
			visited = new boolean[legionnum];
			for(int j=0;j<legionnum;j++)
				shortestpath[j]=1000;
			
			if(i==0)
				Searching(0, shortestpath);
			else
				Searching(Integer.parseInt(itemlocation[i-1]), shortestpath);
			
			goldnum+=shortestpath[Integer.parseInt(itemlocation[i])];
		}
		System.out.println(goldnum);
	}
	static public int getMinindex() {  //최소 거리 정점 반환

		int min = 1000; int index=0;	

		for(int i=0;i<shortestpath.length;i++)
			if(shortestpath[i]<min) 
				if(!visited[i]){
					min = shortestpath[i];
					index= i;
				}
		return index;
	}

	static public void Searching(int currentnode, int[] shortestpath) {

		visited[currentnode]=true;
		shortestpath[currentnode]=0;

		for(int i=0;i<map[currentnode].length;i++)//처음 시작 노드에서 인접노드까지의 비용 갱신
		{
			if(!map[currentnode][i].equals("0"))
				shortestpath[i]=Integer.parseInt(map[currentnode][i]);
		}
		for(int i=0;i<legionnum;i++)//모든 노드를 다 돌 때 까지
		{
			int next = getMinindex();//방문하지 않은 노드들 중 가장 비용이 적은 노드 선택
			visited[next]=true;

			for(int j=0;j<legionnum;j++)
			{
				if(!map[next][j].equals("0"))
					if(!visited[j])
						if((shortestpath[next] + Integer.parseInt(map[next][j])) < shortestpath[j])
							shortestpath[j] = shortestpath[next] + Integer.parseInt(map[next][j]); 
			}
		}
	}
}