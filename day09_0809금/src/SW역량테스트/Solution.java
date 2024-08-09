package SW역량테스트;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			String[] str = new String[5];
			
			int length = 0; //최대길이
			for(int i = 0; i < 5; i++) {
				str[i] = sc.next();			
				if(length < str[i].length())
					length = str[i].length();
			}
			
			String result = "";
			int n = 0;
			while(n < length) {
				for(int i = 0; i < 5; i++) {
					if(n < str[i].length())
						result += str[i].charAt(n);
				}
				n++;
			}
			
			//출력
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}
}
