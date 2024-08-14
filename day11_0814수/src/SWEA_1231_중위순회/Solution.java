package SWEA_1231_중위순회;

import java.util.Scanner;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); //노드의 수
			String[] tree = new String[N];
			for(int i = 1; i <= N; i++) {
				sc.nextInt(); //노드 인덱스
				tree[i - 1] = sc.next(); //노드 내용
				if(i * 2 <= N)
					sc.nextInt(); //left
				if(i * 2 + 1 <= N)
					sc.nextInt(); //right
			}
			inorder(tree, N, 1);
			
			//출력
			System.out.println("#" + test_case + " " + sb);
			sb.setLength(0);
		}
		
		sc.close();
	}
	
	static void inorder(String[] tree, int N, int root) {
		if(root > N)
			return ;
		inorder(tree, N, root * 2); //왼쪽
		sb.append(tree[root - 1] + " "); 
		inorder(tree, N, root * 2 + 1); //오른쪽
	}
}