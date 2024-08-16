package swea21886;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //스위치 개수
		int[] switches = new int[N]; //스위치 배열
		for(int i = 0; i < N; i++)
			switches[i] = sc.nextInt();
		
		int M = sc.nextInt(); //학생 수
		for(int i = 0; i < M; i++) {
			int cmd = sc.nextInt(); //여학생, 남학생 여부
			int idx = sc.nextInt(); //받은 버튼
			//남학생 이라면
			if(cmd == 1) {
				for(int j = 0; j < N; j++) {
					if((j + 1) % idx == 0) {
						if(switches[j] == 0)
							switches[j] = 1;
						else
							switches[j] = 0;
					}
				}
			}
			//여학생 이라면
			else {
				int cnt = 0;
				for(int k = 0; k < N; k++) {
					if(idx - 1 - k < 0 || N <= idx - 1 + k || switches[idx - 1 + k] != switches[idx - 1 - k])
						break;
					cnt++;
				}
				
				//가운데 바꾸기
				if(switches[idx - 1] == 0)
					switches[idx - 1] = 1;
				else
					switches[idx - 1] = 0;
				
				//양옆 바꾸기
				for(int k = 1; k < cnt; k++) {
					if(switches[idx - 1 + k] == 0)
						switches[idx - 1 + k] = 1;
					else
						switches[idx - 1 + k] = 0;
					
					if(switches[idx - 1 - k] == 0)
						switches[idx - 1 - k] = 1;
					else
						switches[idx - 1 - k] = 0;
					
				}
			}
		}
		for(int i = 0; i < N; i++)
			System.out.print(switches[i] + " ");
		sc.close();
	}
}
