package 트리구현;

public class Solution {
	static char[] tree = {0, 'A', 'B', 'C', 'D', 'E', 'F', 'G', ' ', ' ', 'H', 'I'};
	
	public static void main(String[] args) {
		System.out.println("[전위순회]");
		preorder(1);
		System.out.println("[즁위순회]");
		inorder(1);
		System.out.println("[후위순회]");
		postorder(1);
		
		
	}
	
	//전위순회
	static void preorder(int root) {
		if(root >= tree.length || tree[root] == 0)
			return;
		System.out.println(tree[root] + " -> "); //root
		preorder(root * 2); //왼쪽
		preorder(root * 2 + 1); //오른쪽
	}
	
	//중위순회
	static void inorder(int root) {		
		if(root >= tree.length || tree[root] == 0)
			return;
		preorder(root * 2); //왼쪽
		System.out.println(tree[root] + " -> "); //root
		preorder(root * 2 + 1); //오른쪽
	}
	
	//후위순회
	static void postorder(int root) {
		if(root >= tree.length || tree[root] == 0)
			return;
		preorder(root * 2); //왼쪽
		preorder(root * 2 + 1); //오른쪽		
		System.out.println(tree[root] + " -> "); //root
	}
}