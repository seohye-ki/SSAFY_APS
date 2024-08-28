package 병합정렬;

import java.util.Arrays;

public class Solution {
	static int[] arr;
	static int[] tmp;
	
	public static void main(String[] args) {
		arr = new int[] {4, 6, 7, 3, 2, 8, 1, 9};
		tmp = new int[arr.length]; //정렬하기 위해 사용할 공간
		
		mergeSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSort(int left, int right) {
	    if(left < right){
	        int mid = (left + right) / 2; //반으로 나누기 위해 기준이 되는 인덱스
	        mergeSort(left, mid); //왼쪽 분할
	        mergeSort(mid + 1, right); //오른쪽 분할
	        merge(left, mid, right); //합치기
	    }
	}
	
	static void merge(int left, int mid, int right) {
		int L = left; //왼쪽 시작점
		int R = mid + 1; //오른쪽 시작점
		int idx = left; //tmp배열에 담기 시작할 곳
		
		//합치기
		while(L <= mid && R <= right) {
			if(arr[L] <= arr[R]) {
				tmp[idx] = arr[L];
				idx++;
				L++;
			}
			else {
				tmp[idx] = arr[R];
				idx++;
				R++;
			}
		}
		
		//합치고 남은 것들 넣어주기
		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				tmp[idx] = arr[i];
				idx++;
			}
		}
		else {
			for(int i = R; i <= right; i++) {
				tmp[idx] = arr[i];
				idx++;
			}
		}
		
		//원본배열에 적용
		for(int i = left; i <= right; i++)
			arr[i] = tmp[i];
	}
}