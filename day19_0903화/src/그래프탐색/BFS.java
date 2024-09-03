package 그래프탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	static int V, E; //정점의 수, 간선의 수
	static List<Integer>[] adj; //인접리스트
	static boolean[] visited; //방문처리
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V + 1]; //배열만 만든거고 안에 리스트를 생성하지는 않은것
		for(int i = 1; i <= V; i++)
			adj[i] = new ArrayList<>();
		visited = new boolean[V + 1]; //시작번호가 1부터 이기 때문
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A].add(B);
			adj[B].add(A); //무향이니깐
		}//간선입력완료
		bfs(1);
		
	}//main
	
	//v: 시작 정점
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v); //시작정점을 큐에 넣는다.
		visited[v] = true; //시작 정점을 방문체크
		
		//큐가 공백이 아니면 돌겠다
		while(!q.isEmpty()) {
			int curr = q.poll(); //정점하나를 꺼낼거임
			System.out.println(curr);
			
			//인접하면서 방문하지 않은 노드 넣기
			for(int w : adj[curr]) {
				if(!visited[w]) {
					q.add(w);
					visited[w] = true;
				}
			}
			
//			for(int i = 0; i < adj[curr].size(); i++) {
//				int w = adj[curr].get(i);
//			}
		}
	}
}
