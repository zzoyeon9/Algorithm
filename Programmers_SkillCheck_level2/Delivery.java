package Programmers_SkillCheck_level2;

import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int cost;
    int to;

    public Edge(int cost, int to) {
        this.cost = cost;
        this.to = to;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}


public class Solution {

    private static int[] dist;
    private PriorityQueue<Edge> que = new PriorityQueue<>();

    private void search(int[][] road) {

        while (!que.isEmpty()) {
            Edge edge = que.poll();
            int cost = edge.cost;
            int here = edge.to;

            if (dist[here] < cost)
                continue;

            for (int i = 0; i < road.length; i++) {
                int to, cost2;

                if (road[i][0] == here) {
                    to = road[i][1];
                    cost2 = cost + road[i][2];
                } else if (road[i][1] == here) {
                    to = road[i][0];
                    cost2 = cost + road[i][2];
                } else
                    continue;

                if (cost2 < dist[to]) {
                    dist[to] = cost2;
                    que.add(new Edge(cost2, to));
                }
            }
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist = new int[N + 1];
        for (int i = 0; i < dist.length; i++)
            dist[i] = K+1;

        que.add(new Edge(0, 1));
        dist[1] = 0;

        search(road);


        for (int i = 1; i < dist.length; i++)
            if (dist[i] <= K)
                answer++;

        return answer;
    }

    public static void main(String[] args) {

        int[][] arr1 = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int[][] arr2 = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};

        Solution s = new Solution();
        System.out.println(s.solution(5, arr1, 3));
        System.out.println(s.solution(6, arr2, 4));

    }
}
