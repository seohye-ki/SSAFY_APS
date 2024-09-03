package 그래프;

import java.util.Scanner;

public class 인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//V, E의 개수를 준다.
		int V = sc.nextInt(); //정점의 수(0 또는 1로 시작한다)
		int E = sc.nextInt(); //간선의 개수
		
		int[][] adjArr = new int[V][V]; //만약 시작정점이 1이라면 [v + 1][v + 1]
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt(); //두개의 정점이 주어진다.
			int W = sc.nextInt(); //가중치가 있다면 값은 3개
			
			adjArr[A][B] = 1; //가중치가 없다면 연결되었다는 의미의 1, 가중치가 있다면 W
			adjArr[B][A] = 1; //만약에 무향이라면 반대의 경우도 같이 작성을 해주어야 한다.
			
			//adjArr[A][B] = adjArr[B][A] = W; //한줄 작성 코드
		}
		sc.close();
	}
}