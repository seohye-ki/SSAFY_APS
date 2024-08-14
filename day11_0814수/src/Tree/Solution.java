package Tree;

public class Solution {
	//비선형 자료구조 : 계층관계를 표현, 상하관계를 표현
	//부모는 여러명의 부모를 가질 수 있지만 자식은 부모를 여러명 가질 수 없음(ex_파일탐색기)
	//배열과 연결리스트로 구현가능
	//노드 하나만 있어도, 연결리스트도 트리구조임(비선형자료형은 선형자료형이 될 수있지만 선형자료형이 비선형 자료형이 될수는 없음)
	
	//차수
	//노드의 차수 = 노드에 연결된 자식 수
	//트리의 차수 = 트리에 있는 노드의 차수 중에서 가장 큰값
	//단말 노드(리프노드) = 차수가 0인, 자식이 없는 노드
	
	//높이(레벨)
	//루트는 레벨 0
	
	//이진트리
	//모든 노드들이 2개의 서브트리를 갖는 형태의 트리(최대 2개)
	//최소 개수는 h + 1, 최대개수는 2^(h+1) - 1
	//완전이진트리 : n번까지 빈자리가 없는 트리
	//포화이진트리 : 번호 붙일때 레벨 낮은것 부터 노드는 왼쪽에서 오른쪽
	//편향이진트리 : 한쪽 방향으로만 이어져있는 트리(연결리스트)
	
	//장점
	//1. 배열 삽입 삭제가 자주 일어나지 않고
	//2. 완전이진트리일때(포화이진트리일때)
	
	static char[] tree = {0, 'A', 'B', 'C', 'D', 'E', 'F', 'G', ' ', ' ', 'H', 'I'};
	public static void main(String[] args) {
	}
	
	
	//매개변수로 트리의 루트 index받기
	//전위순회 : V - L - R
	public static void preorder(int root) {
		//인덱스 
		if (root >= tree.length || tree[root] == 0){
			return ;
		}
		System.out.println(tree[root] + " -> ");
		preorder(root * 2);
		preorder(root * 2 + 1);
		
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