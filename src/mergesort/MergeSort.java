package mergesort;

import util.ArrayUtil;

public class MergeSort {
	public static void main(String[] args) {
		int[] testArr = ArrayUtil.genRandomIntArr(20);
		ArrayUtil.print(testArr);
		
		MergeSort sort = new MergeSort();
		sort.sort(testArr);
		
		ArrayUtil.print(testArr);
	}
	
	public int[] sort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
		return arr;
	}
	
	public void mergeSort(int[] arr, int from, int to) {
		if (from == to) {
			return;
		} else {
			int mid = from + (to - from)/2;
			mergeSort(arr, from, mid);
			mergeSort(arr, mid+1, to);
			merge(arr, from, mid+1, to);
		}
	}
	
	private void merge(int[] arr, int from, int mid, int to) {
		int[] buffer = new int[to - from + 1];
		
		int index = 0;
		int firstPosition = from;
		int secondPosition = mid;
		
		while (firstPosition <= mid-1 && secondPosition <= to) {
			if (arr[firstPosition] < arr[secondPosition]) {
				buffer[index] = arr[firstPosition];
				firstPosition++;
			} else {
				buffer[index] = arr[secondPosition];
				secondPosition++;
			}
			index++;
		}
		
		if (firstPosition == mid) {
			//copy second to buffer
			while (index <= buffer.length-1) {
				buffer[index] = arr[secondPosition];
				secondPosition++;
				index++;
			}
		} else {
			//copy first to buffer
			while (index <= buffer.length-1) {
				buffer[index] = arr[firstPosition];
				firstPosition++;
				index++;
			}
		}
		for (int i = 0; i <= buffer.length-1; i++) {
			arr[i+from] = buffer[i];
		}
	}
}
