package 프림;

import java.util.Scanner;

public class 프림01_반복문 {
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); //정점의 번호 0번부터 시작
		int E = sc.nextInt(); //간선의 수
		
		//인접행혛 방식으로
		int[][] adjArr = new int[V][V];
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjArr[A][B] = adjArr[B][A] = W; //무향
		}
		
		boolean[] visited = new boolean[V]; //해당 정점 뽑았다.
		int[] p = new int[V]; //내 부모는!, 사용하지 않을거라면 작성하지 않아도 됨.
		int[] dist = new int[V]; //key라고 표현했던 선택한 간선의 가중치
		
		//1. 초기화
		for(int i = 0; i < V; i++) {
			p[i] = -1;
			dist[i] = INF;
		}
		
//		Arrays.fill(dist, INF);
//		Arrays.fill(p, -1);
		
		//2.시작정점 결정
		dist[0] = 0;
		
		
		//3.가중치 배열을 돌면서 가장 값이 낮은 것을 골라서 방문체크
		//V번 돌아도 상관없음
		for(int i = 0; i < V - 1; i++) {
			int min = INF;
			int idx = -1;
			//방문하지 않았으면 가장 작은 값을 가져오기
			for(int j = 0; j < V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}//반복문이 종료되면, idx는 가장작은 값을 가지고 있다.
			visited[idx] = true;
			
			for(int j = 0; j < V; j++) {
				//갱신이 필요한 경우
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < V; i++) {
			ans += dist[i];
		}
		
		System.out.println(ans);
	}
}