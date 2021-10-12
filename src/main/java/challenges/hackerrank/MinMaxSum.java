package challenges.hackerrank;

import java.util.Arrays;
import java.util.List;

/*
 * Given five positive integers, find the minimum and maximum values 
 * that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 * [-3 -2 -1 4 5] -> input
 * 10 14 -> output
 * 396285104 573261094 759641832 819230764 364801279
 * 2093989309 2548418794
 */
public class MinMaxSum {

	public static void main(String[] args) {
		miniMaxSum(Arrays.asList(396285104, 573261094, 759641832, 819230764, 364801279));
	}

	/**
	 * n*log(n), n
	 * n, n
	 * @param arr
	 */
	public static void miniMaxSum(List<Integer> arr) {
		arr.sort(Integer::compareTo);
		long maxSum = arr.subList(1, arr.size()).stream().mapToLong(Integer::longValue).sum();
		long minSum = arr.subList(0, arr.size() - 1).stream().mapToLong(Integer::longValue).sum();
		System.out.println(minSum + " " + maxSum );
	}
}
