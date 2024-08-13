package 연결큐구현;

public class Main {
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println("front에 있는 요소 : " + queue.peek());
		System.out.println("queue의 size : " + queue.size());
		
		System.out.println("poll! " + queue.poll());
		System.out.println("poll! " + queue.poll());
		
		System.out.println("front에 있는 요소 : " + queue.peek());
		System.out.println("queue의 size : " + queue.size());
		
		
		System.out.println("=====================================");
		
		MyQueue<String> queue2 = new MyQueue<>();
		
		queue2.add("cat");
		queue2.add("dog");
		queue2.add("rabbit");
		queue2.add("monkey");
		queue2.add("mouse");
		System.out.println("front에 있는 요소 : " + queue2.peek());
		System.out.println("queue의 size : " + queue2.size());
		
		System.out.println("poll! " + queue2.poll());
		System.out.println("poll! " + queue2.poll());
		
		System.out.println("front에 있는 요소 : " + queue2.peek());
		System.out.println("queue의 size : " + queue2.size());	
	}
}
