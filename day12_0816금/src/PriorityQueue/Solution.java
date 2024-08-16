package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(-10);
		pq.add(-20);
		pq.add(-30);
		pq.add(10);
		pq.add(-40);
		
		while(!pq.isEmpty()) {
			int data = pq.poll();
			System.out.println(-data);
		}
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		
		pq2.add(10);
		pq2.add(20);
		pq2.add(30);
		pq2.add(-10);
		pq2.add(40);
		
		while(!pq2.isEmpty()) {
			int data = pq2.poll();
			System.out.println(data);
		}
		
	}
}
