package runner;

import java.util.concurrent.TimeUnit;

import concurrent.mergesort.ConcurrentMergeSort;
import mergesort.MergeSort;
import util.ArrayUtil;
import util.TimeWatch;

public class Runner {
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		ConcurrentMergeSort concurrentMergeSort = new ConcurrentMergeSort();
		
		int[] testArr1 = ArrayUtil.genRandomIntArr(100000000);
		int[] testArr2 = ArrayUtil.genRandomIntArr(100000000);
		
		System.out.println("-------------Test Synchronized Merge Sort--------------------");
		TimeWatch watch = TimeWatch.start();
		mergeSort.sort(testArr1);
		long timeTaken = watch.time(TimeUnit.MILLISECONDS);
//		ArrayUtil.print(testArr1);
		System.out.println("Total time taken: " + timeTaken);
		
		System.out.println("-------------Test Concurrent Merge Sort--------------------");
		watch = TimeWatch.start();
		concurrentMergeSort.sort(testArr2);
		timeTaken = watch.time(TimeUnit.MILLISECONDS);
//		ArrayUtil.print(testArr2);
		System.out.println("Total time taken: " + timeTaken);
	}
}
