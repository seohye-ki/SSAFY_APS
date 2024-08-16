package Heap;

public class Solution {
	//완전이진 트리에 있는 노드 중에서 키 값이 가장 큰 노드나 키 값이 가장 작은 노드를 찾기 위해서 만든 자료구조
	//특징: 완전 이진 트리 이자 부모-자식 대소 관계가 항상 일정
	
	//최대 힙: 부모 노드의 키 값 >= 자식 노드의 키값
	//최소 힙: 부모 노드의 키 값 <= 자식 노드의 키 값
	
	static int[] heap = new int[100];
	static int heapSize = 0;
	
	public static void main(String[] args) {
		heapPush(20);
		heapPush(19);
		heapPush(28);
		heapPush(-5);
		heapPush(40);
		heapPush(-18);
		
		while (heapSize > 0) {
			int popItem = heapPop();
			System.out.println(popItem);
		}
	}
	
	//swap
	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	
	//삽입
	static void heapPush(int data) {
		//1. 완전 이진 트리 마지막에 데이터 추가
		heap[++heapSize] = data; //0번 인덱스를 비워두기 때문에
	
		int parent = heapSize / 2;
		int child = heapSize;
		
		while (child != 1 && heap[parent] > heap[child]) {
			//2.부모와 자식을 비교해서 자식이 더 작으면 swap
			swap(parent, child);
			
			//3. swap이후의 인덱스 갱신
			child = parent;
			parent = child / 2;
		}
	}
	
	//삭제
	static int heapPop() {
		//1. 루트에 있는 데이터 저장
		int popItem = heap[1];
		
		//2. 마지막 노드를 루트로 옯긴다.
		heap[1] = heap[heapSize--];
		
		//3. 자식과 부모를 비교하여 swap반복
		//자식이 부모보다 더 작으면 swap 둘 이상이면 더 작은 자식과 swap
		int parent = 1;
		int child = parent * 2;
		
		//오른쪽 자식이 있는지 확인, 비교해서 오른쪽 자식이 작으면
		if(child + 1 <= heapSize && heap[child] > heap[child + 1]) {
			child++;
		}
		
		while(child <= heapSize && heap[child] < heap[parent]) {
			swap(child, parent);
			
			//4. swap 이후 인덱스 갱신
			parent = child;
			child = parent * 2;
			
			if(child + 1 <= heapSize && heap[child] > heap[child + 1]) {
				child++;
			}
		}
		
		
		return popItem;
	}
}