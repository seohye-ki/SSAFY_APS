package 프림;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 프림02_우선순위큐 {
	static final int INF = Integer.MAX_VALUE;
	
	static class Edge {
		int A, B, W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); //정점의 번호 0번부터 시작
		int E = sc.nextInt(); //간선의 수
		
		//인접리스트
		List<Edge>[] adjList = new ArrayList[V];
		
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjList[A].add(new Edge(A,B,W));
			adjList[B].add(new Edge(A,B,W));
		}
		
		boolean[] visited = new boolean[V]; //해당 정점 뽑았다.

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[0] = true;


		int ans = 0;
		int pick = 1;
		
//		//1.
//		for(int i = 0; i < adjList[0].size(); i++)
//			pq.add(adjList[0].get(1));
//		
//		//2.
//		for(Edge e : adjList[0])
//			pq.add(e);
		
		//3.
		pq.addAll(adjList[0]);
		
		while(pick != V) {
			Edge e = pq.poll();
			if(visited[e.B])
				continue;
			
			ans += e.W;
			visited[e.B] = true;
			pick++;
			
			pq.addAll(adjList[e.B]);
		}
		
		System.out.println(ans);
	}
}