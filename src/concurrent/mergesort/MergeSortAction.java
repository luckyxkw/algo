package concurrent.mergesort;

import java.util.concurrent.RecursiveAction;

import mergesort.MergeSort;

public class MergeSortAction extends RecursiveAction {
	
	private final int[] arr;
	private final int from;
	private final int to;
	
	public MergeSortAction(int[] arr, int from, int to) {
		this.arr = arr;
		this.from = from;
		this.to = to;
	}

	@Override
	protected void compute() {
		if (to - from < 500000) {
			MergeSort mergeSort = new MergeSort();
			mergeSort.mergeSort(arr, from, to);
		} else {
			int mid = from + (to - from)/2;
			invokeAll(new MergeSortAction(arr, from, mid),
					new MergeSortAction(arr, mid+1, to));
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
