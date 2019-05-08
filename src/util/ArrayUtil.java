package util;

import java.util.Random;

public class ArrayUtil {
	
	private static int DEFAULT_ARR_LENGTH = 10;
	private static int DEFAULT_RANDOM_FROM = 0;
	private static int DEFAULT_RANDOM_TO = 100;
	
	
	private ArrayUtil() {}
	
	public static int[] genRandomIntArr(int length) {
		return doIntArrGeneration(length, null, null);
	}
	
	public static int[] genRandomIntArr(int length, int from, int to) {
		return doIntArrGeneration(length, from, to);
	}
	
	public static void print(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			String text = null;
			if (i == arr.length - 1) {
				text = Integer.toString(arr[i]);
			} else {
				text = arr[i] + ",";
			}
			System.out.print(text);
		}
		System.out.println("]");
	}
	
	private static int[] doIntArrGeneration(Integer length, Integer from, Integer to) {
		if (length == null) { length = DEFAULT_ARR_LENGTH;}
		if (from == null) { from = DEFAULT_RANDOM_FROM;}
		if (to == null) { to = DEFAULT_RANDOM_TO;}
		
		if (length < 0) { throw new IllegalArgumentException("length must not be smaller than zero"); }
		if (to < from) { throw new IllegalArgumentException("to must not be smaller than from"); }
		
		int diff = to - from + 1;
		
		int[] arr = new int[length];
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			arr[i] = r.nextInt(diff) + from;
		}
		
		return arr;
	}

}
