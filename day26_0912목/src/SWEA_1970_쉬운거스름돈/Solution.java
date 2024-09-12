package SWEA_1970_쉬운거스름돈;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10}; //거스름돈으로 줄 수 있는 단위
			int N = sc.nextInt(); //거슬러 줘야하는 돈
            int[] cnt = new int[money.length]; //단위별로 거슬러 줘야하는 갯수를 저장한 배열
            
            for(int i = 0; i < money.length; i++) {
                while(N >= money[i]) {
                    N -= money[i];
                    cnt[i]++;
                }
            }
            
            //output
            System.out.println("#" + tc);
            for(int i = 0; i < money.length; i++)
            	System.out.print(cnt[i] + " ");
            System.out.println();
		}
	}
}
