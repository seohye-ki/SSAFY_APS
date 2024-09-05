package 다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*		구현중		*/

public class 다익스트라02_우선순위큐 {
	static class Edge{
		int V, W;

		public Edge(int v, int w) {
			super();
			V = v;
			W = w;
		}

		@Override
		public String toString() {
			return "Edge [V=" + V + ", W=" + W + "]";
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Edge>[] adjList;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		//공간 만들기
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		//간선 정보 추가
		for(int i = 0; i < E; i++) {
			adjList[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		dijkstra(0);
		System.out.println(Arrays.toString(dist));
	}

	private static void dijkstra(int st) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		boolean[] visited = new boolean[V];
		dist[st] = 0;
				
		for(int i = 0; i < V; i++) {
			
		}
	}
}
