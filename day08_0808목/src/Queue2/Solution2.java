package Queue2;

public class Solution2 {
	//우선순위 큐
	//우선순위를 가진 항목들을 저장하는 큐
	//큐에 우선순위에 따라 넣으면 됨
	
	//배열을 이용한 우선순위 큐 만들기
	//삽입할때는 문제없는데 삭제할때는 우선순위에 따라 삭제하는 로직이 추가되어야 함
	
	//하지만 배열로 구현할 경우 원소의 재배치가 매번 발생하여 소요시간과 메모리 낭비가 큼
	//다음주 연결리스트 배운 후에 해보기

	
	//우선순위 큐
	static int[] queue = new int[100];
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		//삽입정렬
		//이미 정렬된 데이터가 많고, 새로들어온 데이터가 적을때
		int[] arr = new int[] {69, 10, 30, 2, 16, 8, 31, 22};
		
		//i : 정렬되지 않은 집합의 첫번째 원소
		for(int i = 1; i < arr.length; i++) {
			int data = arr[i];
			//정렬된 집합의 뒤에서부터 비교하여 위치 찾아주기
			int j;
			for(j = i - 1; j >= 0 && arr[j] > data; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = data;
		}		
	}
	
	static void enQueue(int data) {
		int i = ++rear;
		//정렬된 집합의 뒤에서부터 비교하여 위치 찾아주기
		int j;
		for(j = i - 1; j >= 0 && queue[j] > data; j--) {
			queue[j + 1] = queue[j];
		}
		queue[j + 1] = data;
	}
	
	static int deQueue() {
		return queue[++front];
	}
}
