package SWEA_1251_하나로;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Edge implements Comparable<Edge>{
		int A;
		double W;

		public Edge(int a, double w) {
			super();
			A = a;
			W = w;
		}
		
		@Override
        public int compareTo(Edge o) {
            return Double.compare(this.W, o.W);
        }
	}
	
	static List<Long> posX;
	static List<Long> posY;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int tc = 1; tc <= C; tc++) {
			int N = sc.nextInt(); //섬 개수

			//x좌표 받기
			posX = new LinkedList<>();
			for(int i = 0;  i < N; i++)
				posX.add(sc.nextLong());
			
			//y좌표 받기
			posY = new LinkedList<>();
			for(int i = 0;  i < N; i++)
				posY.add(sc.nextLong());
			
			//세율
			double price = sc.nextDouble();
			
			boolean[] visited = new boolean[N]; //방문처리
			double[] cost = new double[N]; //비용저장
			Arrays.fill(cost, Double.MAX_VALUE);
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			//0번부터 시작
			cost[0] = 0;
			pq.add(new Edge(0, 0));
			
			double ans = 0;
			
			while (!pq.isEmpty()) {
                Edge cur = pq.poll();
                int idx = cur.A;
                
                if (visited[idx]) continue;
                
                visited[idx] = true;
                ans += cur.W;
                
                for (int i = 0; i < N; i++) {
                    if (!visited[i]) {
                        double weight = cal(idx, i);
                        if (weight < cost[i]) {
                            cost[i] = weight;
                            pq.add(new Edge(i, weight));
                        }
                    }
                }
            }
			
			System.out.println("#" + tc + " " + Math.round(ans * price));
		}
		sc.close();
	}
	
	//비용계산
	static double cal(int a, int b) {
		double len = Math.pow(posX.get(a) - posX.get(b), 2);
		double hei = Math.pow(posY.get(a) - posY.get(b), 2);
		return len + hei;
	}
}