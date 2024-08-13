package SWEA_1230_암호문3;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1;  test_case <= 10; test_case++) {
			LinkedList<String> list = new LinkedList<>(); //암호문을 저장할 연결리스트
			int N = sc.nextInt(); //암호문의 길이
			//암호문 입력 받기(연결리스트로 뒤에 추가하기)
			for(int i = 0; i < N; i++)
				list.addLast(sc.next());
			int M  = sc.nextInt(); //명령어 개수
			//명령어 입력받기
			for(int i = 0; i < M; i++) {
				String cmd = sc.next();
				if(cmd.equals("I")) {
					int idx = sc.nextInt();
					int cnt = sc.nextInt();
					for(int k = 0; k < cnt; k++)
						list.add(idx + k, sc.next());
				}
				else if(cmd.equals("D")) {
					int idx = sc.nextInt();
					int cnt = sc.nextInt();
					for(int k = 0; k < cnt; k++)
						list.remove(idx);
				}
				else {
					int cnt = sc.nextInt();
					for(int k = 0; k < cnt; k++)
						list.addLast(sc.next());
				}
			}
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(list.poll() + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}