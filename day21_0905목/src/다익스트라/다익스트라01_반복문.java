package 다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다익스트라01_반복문 {
	static class Node {
		int V, W;

		public Node(int v, int w) {
			super();
			V = v;
			W = w;
		}

		@Override
		public String toString() {
			return "Node [V=" + V + ", W=" + W + "]";
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList; //인접리스트
	static int[] dist; //거리배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for(int i = 0; i < V; i++)
			adjList[i] = new ArrayList<>();

		dist = new int[V];
		Arrays.fill(dist, INF);
		
		for(int i = 0; i < E; i++) {
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
}

	private static void dijkstra(int st) {
		boolean[] visited = new boolean[V];
		
		dist[st] = 0; //시작노드까지의 거리는 0으로 초기화
		//어디까지 할지는 문제를 보고 결정(도착지가 있으면 while문으로 거기를 방문하는 순가 멈추게)
		for(int i = 0; i < V - 1; i++) {
			int min = INF;
			int idx = -1;
			
			for(int j = 0; j < V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			
			//갈 수 있는게 없다.
			if(idx == -1)
				break;
				
			visited[idx] = true; //지점 뽑음
			
			for(Node node : adjList[idx]) {
				if(!visited[node.V] && dist[node.V] > dist[idx] + node.W) {
					dist[node.V] = dist[idx] + node.W;
				}
			}
		}
	}
}