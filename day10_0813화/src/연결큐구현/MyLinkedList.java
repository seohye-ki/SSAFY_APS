package 연결큐구현;

class Node<T> {
	T value;
	Node<T> next;
}

class MyLinkedList<T>{
	Node<T> head;
	int size;
	
	MyLinkedList(){
		head = new Node<T>();
		size = 0;
	}
	
	//삽입
	void add(int idx, T value) {
		//0: 제일 앞에 추가
		//size: 제일 뒤에 추가
		
		//범위 벗어나는지 확인
		if(!(0 <= idx && idx <= size)) {
			System.out.println("삽입할 위치가 잘못되었습니다.");
			return;
		}
		
		size++;
		
		//새노드 만들기
		Node<T> newNode = new Node<>();
		newNode.value = value;
		
		//삽입할 위치 앞에 있는 노드 찾기
		Node<T> curr = head;
		for(int k = 0; k < idx; k++) {
			curr = curr.next;
		}
		
		//새노드와 뒷노드 연결
		newNode.next = curr.next;
		
		//앞노드와 새노드 연결
		curr.next = newNode;
		
	}
	
	//삭제
	void remove(int idx) {
		//0: 맨 앞 데이터 삭제
		//(size - 1): 마지막 데이터 삭제
		
		if(!(0 <= idx && idx < size)) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		
		size--;
		
		//삭제할 노드의 앞 노드로 이동
		Node<T> curr = head;
		for(int k = 0; k < idx; k++) {
			curr = curr.next;
		}
		
		//삭제할 노드의 앞노드와 삭제할 노드의 뒷노드 연결
		curr.next = curr.next.next;
	}
	
	//조회
	T get(int idx) {		
		Node<T> curr = head;

		if(!(0 <= idx && idx <= size)) {
			System.out.println("범위를 벗어나 조회할 수 없습니다.");
			return null;
		}
		
		//처음부터 끝까지
		for(int k = 0; k <= idx; k++)
			curr = curr.next;
		
		return curr.value;
	}
	
	//출력
	void printAll() {
		Node<T> curr = head;
		
		while(curr != null) {
			System.out.print(curr.value + " -> ");
			curr = curr.next;
		}
	}
}
