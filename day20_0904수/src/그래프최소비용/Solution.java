package 그래프최소비용;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static class Edge implements Comparable<Edge>{
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
		
		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
//			return Integer.compare(this.W, o.W);
		}
	}
	
	static int[] p; //대표자 저장 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); //정점의 개수(정점의 시작번호를 보고)
		int E = sc.nextInt(); //간선의 개수
		
		Edge[] edges = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			edges[i] = new Edge(A, B, W);
			
//			edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		//1. 가중치 순으로 정렬을 해라
		
//		Arrays.sort(edges, new Comparator<Edge>() {
//			@Override
//			public int compare(Solution.Edge o1, Solution.Edge o2) {
//				return o1.W - o2.W;
//			}
//		});
		
		Arrays.sort(edges);
		
		//2. V - 1개의 간선을 뽑아라!
		//상호배타집합(서로소집합, 유니온 파인드 이용)
		p = new int[V]; //0번부터 시작
		
		//make-set을 통해 전체 자신을 대표로 만드는 작업을 수행한다.
		for(int i = 0; i < V; i++) {
//			makeSet(i);
			p[i] = i;
		}
		
		int ans = 0;
		int pick = 0;
		
		for(int i = 0; i < E; i++) {
			int x = edges[i].A;
			int y = edges[i].B;
			// 사이클 확인
//			if(findSet(x) != findSet(y)) {
//				//사이클 아님
//				union(x, y); //union에서 findset을 해서 2번함
//				ans += edges[i].W;
//				pick++;
//			}
			
			//대표내려보내면서 사이크 확인
			int px = findSet(edges[i].A);
			int py = findSet(edges[i].B);
			if(px != py) {
				union(px, py);
				ans += edges[i].W;
				pick++;
			}
		}
		
	}//main
	
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
		//해당 방식이 원래 우리가 알던 코드
//		if(x == p[x])
//			return x;
//		return findSet(p[x]);
		//위의 코드에는 똑같은 작업을 도 할 수 있어서 효율이 떨어진다.
		//path compression적용
		if(x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		//x와 y가 대표자여야한다.
		p[findSet(y)] = findSet(x); //X그룹에 Y그룹을 넣는것
	}
}