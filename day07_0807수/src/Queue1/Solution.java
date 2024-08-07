package Queue1;

import java.util.Scanner;

public class Solution {
	//Queue는 삽입과 삭제위치가 제한되어있다.
	//FIFO 선입선출방식이다.
	//앞과 뒤를 fornt-rear, head-tail이라고 명명함
	//삽입음 'enQueue' 삭제를 'deQueue'라고 한다.
	//공백상태 확인은 'isEmpty'라고 한다. 앞쪽에서 원소를 삭제없이 반환하는 연산 'Qpeek'이라고 한다.

	//생성직후 front, rear 전부다 -1로 초기화
	//초기상태 : front = rear = -1
	//공백상태 : front = rear
	//포화상태 : rear = n-1(n은 배열의 크기, n-1은 배열의 마지막 인덱스)
	
	//큐 구현
	static String[] queue = new String[10];
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			String item = sc.next();
			enQueue(item);
		}
		
		while(!isEmpty()) {
			String item = deQueue();
			System.out.println(item);
		}
		
	}
	 
	//공백상태 확인
	static boolean isEmpty() {
//		if(front == rear)
//			return true;
//		return false;
		return front == rear;
	}
	
	//포화상태 확인
	static boolean isFull() {
		//rear가 배열의 마지막 인덱스를 가리키면 포화상태
		return rear == queue.length - 1;
	}
	
	//삽입
	//삽입 성공 여부를 반환하려면 boolean타입도 반환가능
	static void enQueue(String item) {
		if(isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		queue[++rear] = item; 
	}
	
	//삭제
	static String deQueue() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[++front];
	}
	
	//원소 조회
	static String Qpeek() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[front + 1];
	}
	
	//사이즈
	static int size() {
		return rear - front;
	}
}