package 연결큐구현;

class MyQueue<T> {
	private int front;
	private int rear;
	private MyLinkedList<T> queue;
	
	//생성자
	public MyQueue() {
		this.front = -1;
		this.rear = -1;
		this.queue = new MyLinkedList<T>();
	}
	
	//비었는지 확인
	public boolean isEmpty() {
		return front == rear;
	}
	
	//삽입
	public void add(T value) {
		this.rear++;
		this.queue.add(rear, value);
	}
	
	//삭제
	public T poll() {
		if(isEmpty())
			return null;
		this.front++;
		return this.queue.get(this.front);
	}
	
	//조회
	public T peek() {
		if(isEmpty())
			return null;
		return this.queue.get(front + 1);
	}
	
	//원소 갯수
	public int size() {
		return rear - front;
	}
}