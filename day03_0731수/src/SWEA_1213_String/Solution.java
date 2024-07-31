package SWEA_1213_String;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			int tc = sc.nextInt();
			String target = sc.next();
			String str = sc.next();
			
			//문자열 찾기
			int flag = 0;
			int cnt = 0;
			int i = 0;
			while(i < str.length()) {
				if(target.charAt(0) == str.charAt(i) && str.length() - i >= target.length()) {
					flag = 0;
					for(int k = 0; k < target.length(); k++) {
						if(target.charAt(k) != str.charAt(i + k)) {
							flag = 1;
							break;
						}
					}
					//flag 1 :일치하지 않음
					if(flag == 1) {
						flag = 0;
						i++;
					}
					//flag 0 :일치함
					else {
						cnt++;
						i = i + target.length();
					}
				}
				else
					i++;
			}
			System.out.println("#" + tc + " " + cnt);
		}
		sc.close();
	}
}