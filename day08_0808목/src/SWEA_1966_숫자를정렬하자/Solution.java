package SWEA_1966_숫자를정렬하자;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 수
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt(); //숫자 갯수
			int[] arr = new int[N]; //배열
			//배열 입력
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			//삽입 정렬 구현
			for(int i = 1; i < N; i++) {
				int key = arr[i];
				int j;
				//정렬된 인덱스 가장 끝에서 부터 비교
				for(j = i - 1; j >= 0; j--) {
					if(key >= arr[j]) //key가 arr[j]보다 크면 반복문 종료
						break;
					arr[j + 1] = arr[j];
				}
				arr[j + 1] = key;
			}
			
			//출력
			System.out.print("#" + (t+1) + " ");
			for(int i = 0;  i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
		sc.close();
	}
}