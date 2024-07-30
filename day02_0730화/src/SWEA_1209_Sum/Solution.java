package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			int tc = sc.nextInt(); //테스트케이스 번호
			int[][] arr = new int[100][100];
			//배열 입력
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++)
					arr[i][j] = sc.nextInt();
			}
			
			//최댓값구하기
			int max = -2147483648;
			int sum;
			//행의 합
			for(int i = 0;  i < 100; i++) {
				sum = 0;
				for(int j = 0; j < 100; j++)
					sum += arr[i][j];
				if(max < sum)
					max = sum;
			}
			//열의 합
			for(int j = 0;  j < 100; j++) {
				sum = 0;
				for(int i = 0; i < 100; i++)
					sum += arr[i][j];
				if(max < sum)
					max = sum;
			}
			//오른쪽 대각선의 합
			sum = 0;
			int i = 0;
			int j = 0;
			while(i < 100) {
				sum += arr[i][j];
				i++;
				j++;
			}
			if(max < sum)
				max = sum;
			//왼쪽 대각선의 합
			sum = 0;
			i = 0;
			j = 99;
			while(i < 100) {
				sum += arr[i][j];
				i++;
				j--;
			}
			if(max < sum)
				max = sum;
			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}
}