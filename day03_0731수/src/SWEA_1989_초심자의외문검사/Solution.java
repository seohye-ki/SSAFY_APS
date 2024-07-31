package SWEA_1989_초심자의외문검사;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 0; t < tc; t++) {
			String str = sc.next();
			//회문인지 확인
			int flag = 0;
			for(int k = 0; k < str.length() / 2; k++) {
				if(str.charAt(k) != str.charAt(str.length() - 1 - k)) {
					flag = 1;
					break;
				}
			}
			if(flag == 1)
				System.out.println("#" + (t+1) + " 0");
			else
				System.out.println("#" + (t+1) + " 1");
		}
		sc.close();
	}
}