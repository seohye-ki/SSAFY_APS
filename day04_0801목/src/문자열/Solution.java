package 문자열;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		//문자열 초기화 방법 1. 리터럴
		String lStr1 = "Hello";
		String lStr2 = "Hello";
		
		//문자열 초기화 방법 2. new 키워드
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		
		//주소 비교
		System.out.println(lStr1 == lStr2); //true 문자열 상수 풀을 가리키고 있음
		System.out.println(str1 == str2); //flase 힙에 각각 올라감
		
		//값 비교
		System.out.println(str1.equals(str2)); //true
		
		
		
		
		
		
		//문자열 뒤집기
		//java에서는 문자열 읽기는 가능, 특정위치 문자쓰기 X
		String str = new String("algorithm");
		char[] charArr = new char[str.length()];
		for(int i = 0; i < str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
		System.out.println(Arrays.toString(charArr));

		for(int i = 0; i < str.length() / 2; i++) {
			char tmp = charArr[i];
			charArr[i] = charArr[str.length() - 1 - i];
			charArr[str.length() - i] = tmp;
		}
		
		String newStr = "";
		for(int i = 0; i < charArr.length; i++) {
			newStr += charArr[i];
		}
		System.out.println(newStr);
		
		
		
		
		

		//atoi, itoa
		String strNum = "1234";
		System.out.println(0 + strNum); //01234
		
		//문자열 -> 정수
		int num = Integer.parseInt(strNum);
		System.out.println(0 + num); //1234
		num = atoi(strNum);
		System.out.println(num); //1234
		
	
		//정수 -> 문자열
		int intVar = 324;
		String intStr = String.valueOf(intVar);
		System.out.println(0 + intStr);
	}
	
	static int atoi(String str) {
		int N = str.length();
		int num = 0;
		for(int i = 0; i < N; i++) {
			if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
				num = (num * 10) + (str.charAt(i) - '0');
			}
		}
		return num;
	}
}