package asdasd;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Dijkstra {

	static int casenum, edgenum, vertexnum, startedge, auxiliarynode, finishnode, result;
	static boolean ispossible=true;
	static int []  shortestpath; static int [][] graph;
	static boolean [] visited; static String path=""; 

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		casenum = input.nextInt();
		input.nextLine();

		for(int i=0;i<casenum;i++){

			String temp = input.nextLine();
			StringTokenizer temp2 = new StringTokenizer(temp," ");

			edgenum = Integer.parseInt(temp2.nextToken());
			vertexnum = Integer.parseInt(temp2.nextToken());
			result = 0;

			shortestpath = new int[edgenum+1];

			for(int j=1;j<=edgenum;j++) 
				shortestpath[j]=1000;//ó���� �ּ� ��θ� �������� �ʱ�ȭ

			graph = new int [edgenum+1][edgenum+1];
			visited = new boolean[edgenum+1];

			for(int j=0;j<vertexnum;j++) {

				StringTokenizer temp3 = new StringTokenizer(input.nextLine()," ");

				int node0 = Integer.parseInt(temp3.nextToken());
				int node1 = Integer.parseInt(temp3.nextToken());
				int distance = Integer.parseInt(temp3.nextToken());

				graph[node0][node1] = distance;
				graph[node1][node0] = distance;
			}

			temp = input.nextLine();
			temp2 = new StringTokenizer(temp, " ");

			startedge = Integer.parseInt(temp2.nextToken());
			auxiliarynode = Integer.parseInt(temp2.nextToken());
			finishnode = Integer.parseInt(temp2.nextToken());






			Searching(startedge,shortestpath);//�� �������κ��� ������������ �ּҰŸ��� ���� ��
			result +=shortestpath[auxiliarynode];

			visited = new boolean[edgenum+1];
			for(int j=1;j<=edgenum;j++) 
				shortestpath[j]=1000;//ó���� �ּ� ��θ� �������� �ʱ�ȭ

			Searching(auxiliarynode,shortestpath);//�� �������κ��� ������������ �ּҰŸ��� ���� ��
			result +=shortestpath[finishnode];

			int count=0; 

			for(int y=1;y<graph[finishnode].length;y++) 
				if(graph[finishnode][y]==0)
					count++;
			if(count == graph[finishnode].length-1)
				ispossible=false;

			if(ispossible)
				System.out.println(result);
			else System.out.println(-1);
		}
	}
	static public int getMinindex() {  //�ּ� �Ÿ� ���� ��ȯ

		int min = 1000; int index=0;	

		for(int i=1;i<shortestpath.length;i++)
			if(shortestpath[i]<min) 
				if(!visited[i]){
					min = shortestpath[i];
					index= i;
				}
		return index;
	}

	static public void Searching(int currentnode, int[] shortestpath) {
		int count=0;
		for(int y=1;y<graph[currentnode].length;y++) 
			if(graph[currentnode][y]==0)
				count++;
		if(count == graph[currentnode].length-1) {
			ispossible=false;
			return;
		}
		visited[currentnode]=true;
		shortestpath[currentnode]=0;

		for(int i=1;i<graph[currentnode].length;i++)//ó�� ���� ��忡�� ������������ ��� ����
		{
			if(graph[currentnode][i]!=0)
				shortestpath[i]=graph[currentnode][i];
		}
		for(int i=1;i<=edgenum;i++)//��� ��带 �� �� �� ����
		{
			int next = getMinindex();//�湮���� ���� ���� �� ���� ����� ���� ��� ����
			visited[next]=true;

			for(int j=1;j<=edgenum;j++)
			{
				if(graph[next][j]!=0)
					if(!visited[j])
						if((shortestpath[next] + graph[next][j]) < shortestpath[j])
							shortestpath[j] = shortestpath[next] + graph[next][j]; 
			}
		}
	}
}