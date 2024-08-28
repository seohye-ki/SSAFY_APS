package 퀵정렬;

import java.util.Arrays;

public class Solution {
	static int[] arr;
	public static void main(String[] args) {
		arr = new int[] {4, 6, 7, 3, 2, 8, 1, 9};
		
		quickSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int left, int right) {
	    if(left < right){
	        int pivot = partition(left, right); //피봇 위치 찾기 선택하는 pivot은 맨 앞에 있는 걸로
	        quickSort(left, pivot - 1); //피봇 기준 앞
	        quickSort(pivot + 1, right); //피봇 기준 뒤
	    }
	}
	
	static int partition(int left, int right){
	    int pivot = arr[left];
	    int L = left + 1;
	    int R = right;

	    while(L <= R){
	        //pivot보다 범위를 넘지 않으면서 큰 값을 찾을때까지 이동
	        while(L <= R && arr[L] <= pivot)
	            L++;
	        //pivot보다 작거나 같은 값을 찾을때까지 이동
	        while(arr[R] > pivot)
	            R--;

	        if(L < R){
	            int tmp = arr[L];
	            arr[L] = arr[R];
	            arr[R] = tmp;
	        }
	    }

	    //피봇 위치 바꾸기
	    int tmp = arr[left];
	    arr[left] = arr[R];
	    arr[R] = tmp;
	    
	    return R;
	}
}