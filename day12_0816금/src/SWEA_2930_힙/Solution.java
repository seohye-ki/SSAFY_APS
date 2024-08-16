package SWEA_2930_힙;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				int cmd = sc.nextInt();
				if(cmd == 1) {
					int value = sc.nextInt();
					pq.add(value);
				}
				else {
					Integer data = pq.poll();
					if(data == null)
						sb.append("-1 ");
					else
						sb.append(data + " ");
						
				}
			}
			
			//출력
			System.out.println("#" + test_case + " " + sb);			
		}
		sc.close();
	}
}