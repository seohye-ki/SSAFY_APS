package 그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 간선배열 {
	static class Edge{
		int A, B, W; //시작, 끝, 가중치
		
		public Edge(int a, int b, int w) {
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
		
		//V, E의 개수를 준다.
		int V = sc.nextInt(); //정점의 수(0 또는 1로 시작한다)
		int E = sc.nextInt(); //간선의 개수
		
		Edge[] edges = new Edge[E];
		/////////////////////////////
		//1. 객체 배열
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges[i] = new Edge(A, B, W);
		}
		
		/////////////////////////////
		//2.객체배열 리스트
		List<Edge> edges2 = new ArrayList<>();
		for(int i = 0; i < E; i++) {
			edges2.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		////////////////////////////
		//3. 굳이 객체를 안만들고 싶다면
		int[][] edges3 = new int[E][3];
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges3[i][0] = A; //시작정점
			edges3[i][1] = B; //도착정점
			edges3[i][2] = W; //가중치
		}
	}
}
