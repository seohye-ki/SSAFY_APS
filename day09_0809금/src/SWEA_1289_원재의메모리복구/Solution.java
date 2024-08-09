package SWEA_1289_원재의메모리복구;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 수
		for(int test_case = 1; test_case <= T; test_case++) {
			String origin = sc.next(); //원래 값
			char[] curr = new char[origin.length()]; //초기화된 메모리
			Arrays.fill(curr, '0');
			
			int cnt = 0; //수정 횟수
			for(int i = 0; i < origin.length(); i++) {
				//앞에서부터 비교하면서 숫자가 다르면 바꾸기
				if(origin.charAt(i) != curr[i]) {
					for(int j = i; j < origin.length(); j++)
						curr[j] = origin.charAt(i);
					cnt++;
				}
			}
			
			//출력
			System.out.println("#" + test_case + " " + cnt);
		}
		sc.close();
	}
}