package LinkedList;

class DNode{
	String data;
	DNode prev;
	DNode next;
}

class DoublyLinkedList {
	DNode head;
	DNode tail;
	int size;
	
	public DoublyLinkedList() {
		head = new DNode();
		tail = new DNode();
		head.next = tail;
		tail.prev = head;
	}
	
	//삽입
	void addData(int i, String data) {
		//0이면 제일 앞에 삽입
		//size면 제일 뒤에 삽입
		if(i < 0 || i > size) {
			System.out.println("삽입할 수 없는 범위입니다.");
			return;
		}
		size++;
		
		//삽입위치 앞의 노드를 찾는다
		DNode curr = head;
		for(int k = 0; k < i; k++)
			curr = curr.next;
		
		//새노드 만들기
		DNode newNode = new DNode();
		newNode.data = data;
		newNode.next = curr.next;
		newNode.prev = curr;
		
		//기존노드 연결 재구성
		curr.next.prev = newNode;
		curr.next = newNode;
	}
	
	//삭제
	void removeData(int i) {
		//0이면 제일 앞의 데이터 삭제
		//size - 1 제일 뒤의 데이터 삭제
		
		if(i < 0 || i >= size) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		size--;
		
		//삭제할 위치를 찾기
		DNode rmNode = head;
		
		for(int k = 0; k < i; k++) {
			rmNode = rmNode.next;
		}
		
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev; 
	}
	
	void printReverse() {
		DNode curr = tail.prev;
		String str = "";
		
		while(curr != head) {
			str = " <- " + curr.data + str;
			curr = curr.prev;
		}
		System.out.println(str);
	}
}


public class Solution2 {
	//양쪽 방향으로 순회할 수 있도록 노드를 연결한 리스트
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addData(0, "1");
		list.addData(0, "2");
		list.addData(0, "3");
		list.addData(0, "4");
		list.removeData(2);
		list.printReverse();
	}
}
