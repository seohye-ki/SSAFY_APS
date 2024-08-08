package Queue2;

public class Solution {
	//원형 큐
	//초기 공백 상태 : front = rear = 0
	//front와 rear의 위치가 배열의 마지막 인덱스인 n - 1을 가리킨 후
	//그 다음에는 논리적 순환을 이루어 배열의 처음 인덱스인 0으로 이동한다. => 나머지 연산자 사용
	
	//front는 공백상태와 포화상태 구분을 쉽게 하기 위해 front자리는 사용하지 않음.
	//삽입 위치 : rear = (rear +  1) % n
	//삭제 위치 : front = (front + 1) % n
	//공백 상태 확인 : front == rear
	//포화 상태 확인 : front - rear == 1
	
	static String[] queue = new String[4];
	static int front, rear;
	static int N = queue.length; //배열의 길이
	static int size = 0; //사이즈
	
	public static void main(String[] args) {
	
		System.out.println();
	}
	
	//포화상태 확인
	static boolean isFull() {
		return(N + front - rear) % N == 1;
	}
	
	//공백 상태 확인
	static boolean isEmpty() {
		return front == rear;
	}
	
	//삽입
	static void enQueue(String data) {
		if(isFull()) {
			System.out.println("큐가 가득찼습니다.");
			return;
		}
		size++;
		rear = (rear + 1) % N;
		queue[rear] = data;
	}
	
	//삭제
	static String deQueue() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		size--;
		front = (front + 1) % N;
		return queue[front];
	}
	
	//조회
	static String Qpeek() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[(front + 1) % N];
	}
	
	//데이터 개수
	static int size() {
//		return (N + rear - front) % N;
		return size;
	}
}