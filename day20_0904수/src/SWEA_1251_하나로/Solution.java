package SWEA_1251_하나로;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static class Edge implements Comparable<Edge>{
		int A, B;
		double W;

		public Edge(int a, int b, double w) {
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
			if(this.W - o.W < 0)
				return -1;
			else if(this.W - o.W == 0)
				return 0;
			else
				return 1;
		}
	}
	
	
	static int[] p;
	static List<Long> posX;
	static List<Long> posY;
	static double price;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int tc = 1; tc <= C; tc++) {
			int N = sc.nextInt(); //섬 개수
			int E = (N * (N - 1)) / 2; //간선의 개수
			
			//x좌표 받기
			posX = new LinkedList<>();
			for(int i = 0;  i < N; i++)
				posX.add(sc.nextLong());
			
			//y좌표 받기
			posY = new LinkedList<>();
			for(int i = 0;  i < N; i++)
				posY.add(sc.nextLong());
			
			price = sc.nextDouble();
			
			//간선배열 만들기
			Edge[] edges = new Edge[E];
			int idx = 0;	
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					int x = i;
					int y = j;
					double w = cal(i, j);
					edges[idx++] = new Edge(x, y, w);
				}
			}
				
			Arrays.sort(edges);
			
			//모든 간선의 개수 구하고 자신을 대표로 
			p = new int[N];
			for(int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			double ans = 0;
			int pick = 0;
			
			for(int i = 0; i < E; i++) {
				//대표내려보내면서 사이크 확인
				int px = findSet(edges[i].A);
				int py = findSet(edges[i].B);
				
				if(px != py) {
					union(px, py);
					ans += edges[i].W;
					pick++;
				}
				
				if(pick == N - 1)
					break;
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
	
	static int findSet(int x) {
		if(p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}