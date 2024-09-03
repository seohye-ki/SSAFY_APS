package 그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//V, E의 개수를 준다.
		int V = sc.nextInt(); //정점의 수(0 또는 1로 시작한다)
		int E = sc.nextInt(); //간선의 개수
		
		List<Integer>[] adjList = new ArrayList[V];
		
		//기본적으로 전부 생성을 해주어야 널 포인트 익셉션이 뜨지 않는다.
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			//가중치를 같이 저장하고 싶다면 1. 클래스를 정의해서 넣던지, 2. int[] 이용해서 넣던지
			adjList[A].add(B);
			adjList[B].add(A);
		}
	}
	
	//인접 행렬 VS 인접 리스트(장단점을 알고있자)
	//인접행렬은 간선의 수와 무관하게 항상 n² 크기의 2차원 배열이 필요하므로 메모리 공간이 낭비된다.
	//그래프의 모든 간선의 수를 알아내려면 인접행렬 전체를 확인해야 하므로 O(n²)의 시간이 소요된다.
	//A와 B의 인접여부를 확인하려면 인접행렬이 편하다.
}
