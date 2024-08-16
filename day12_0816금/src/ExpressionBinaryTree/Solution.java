package ExpressionBinaryTree;

public class Solution {
	//연산자는 루트 노드이거나 가지노드
	//피연산자는 모두 잎 노드(단말노드)
	
	static char[]tree = {0, '+', 'X', '-', '1', '2', '3', '4'};
	
	public static void main(String[] args) {
		inorder(1);
	}
	
	static void inorder(int root) {
//		//기저조건 1 : 인덱스가 배열 범위를 벗어남
//		if(root >= tree.length)
//			return ;
//		
//		//기저조건 2 : 리프노드인 경우
//		if('0' <= tree[root] && tree[root] <= '9') {
//			System.out.println(tree[root]);
//			return ;
//		}

		if(root * 2 < tree.length)
			inorder(root * 2);
		System.out.println(tree[root]);
		if(root * 2 + 1 < tree.length)
			inorder(root * 2 + 1);
	}
	
	static void postorder(int root) {
//		//기저조건 1 : 인덱스가 배열 범위를 벗어남
//		if(root >= tree.length)
//			return ;
//		
//		//기저조건 2 : 리프노드인 경우
//		if('0' <= tree[root] && tree[root] <= '9') {
//			System.out.println(tree[root]);
//			return ;
//		}

		if(root * 2 < tree.length)
			postorder(root * 2);
		if(root * 2 + 1 < tree.length)
			postorder(root * 2 + 1);
		System.out.println(tree[root]);
	}
	
	static void preorder(int root) {
//		//기저조건 1 : 인덱스가 배열 범위를 벗어남
//		if(root >= tree.length)
//			return ;
//		
//		//기저조건 2 : 리프노드인 경우
//		if('0' <= tree[root] && tree[root] <= '9') {
//			System.out.println(tree[root]);
//			return ;
//		}

		System.out.println(tree[root]);
		if(root * 2 < tree.length)
			postorder(root * 2);
		if(root * 2 + 1 < tree.length)
			postorder(root * 2 + 1);
	}
}
