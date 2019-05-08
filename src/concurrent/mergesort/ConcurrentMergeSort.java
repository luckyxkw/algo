package concurrent.mergesort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

import util.ArrayUtil;
import util.TimeWatch;

public class ConcurrentMergeSort {
	
	public int[] sort(int[] arr) {
		ForkJoinTask<?> task = new MergeSortAction(arr, 0, arr.length-1);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		
		return arr;
	}
	
	
}
