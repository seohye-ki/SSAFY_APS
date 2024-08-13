package LinkedList;

class Node {
	String data;
	Node next;
}

class SinglyLinkedList{
	Node head;
	int size;
	
	SinglyLinkedList(){
		head = new Node();
		size = 0;
	}
	
	//삽입
	void addData(int i, String data) {
		//i인덱스에 데이터 삽입
		//0이면 제일 앞에 추가
		//size와 같으면 제일 뒤에 추가
		
		if(!(0 <= i && i <= size)) {
			System.out.println("삽입할 위치가 잘못되었습니다.");
			return;
		}
		
		size++;
		
		//새노드 만들기
		Node newNode = new Node();
		newNode.data = data;
		
		//삽입할 위치 앞에 있는 노드 찾기
		Node curr = head;
		for(int k = 0; k < i; k++) {
			curr = curr.next;
		}
		
		//새노드부터 연결
		newNode.next = curr.next;
		
		//앞노드에 next에 새노드 연결
		curr.next = newNode;
		
	}
	
	//삭제
	void removeData(int i) {
		//0이면 맨 앞 데이터 삭제
		//(size - 1)이면 마지막 데이터 삭제
		
		if(!(0 <= i && i < size)) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		
		size--;
		
		//삭제할 노드의 앞 노드로 이동
		Node curr = head;
		for(int k = 0; k < i; k++) {
			curr = curr.next;
		}
		
		curr.next = curr.next.next;
	}
	
	//조회
	void printAll() {
		Node curr = head;
		
		while(curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
	}
}

public class Solution {
	//연결리스트 - 선형자료구조
	//자료의 논리적인 순서와 메모리상의 물리적인 순서가 일치하지 않고, 개별적으로 위치하고 있는 원소의 주소를 연결하여 하나의 전체적인 자료구조를 이룬다
	//(논리적: 사람이 이해하는 구조, 물리적: 실제 컴퓨터 메모리상에 저장되는 구조)
	
	//배열대비 장점
	//삽입/삭제 연산 이후 원소의 재배치가 필요없음
	//메모리의 효율적인 사용이 가능함
	
	//배열 VS 연결리스트
	//삽입,삭제 : 배열은 O(N) 연결리스트 O(1)
	//조회 : 배열O(1) 연결리스트 O(N)
	
	//단순연결리스트(singly linked list) = 단방향 연결 리스트(single linked list)
	//노드가 하나의 링크필드에 의해 다음 노드와 연결되는 구조를 가진다.
	
	//더미노드를 만들면 head가 변경되지 않음.
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addData(0, "1");
		list.addData(0, "2");
		list.addData(0, "3");
		list.addData(0, "4");
		list.addData(0, "5");
		list.printAll();
	}
}