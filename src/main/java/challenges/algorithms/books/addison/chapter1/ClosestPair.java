package challenges.algorithms.books.addison.chapter1;

import java.util.Arrays;

import challenges.algorithms.books.addison.libs.program.In;
import challenges.algorithms.books.addison.libs.program.StdOut;

public class ClosestPair {

	/**
	 * 1,3,5
	 * |1-3| =  2
	 * |1-5| = 4
	 * Closest pair (in one dimension). Write a program that, given an array a[] of N
	 * double values, finds a closest pair : two values whose difference (|a - b|) is no greater than the
	 * the difference of any other pair (in absolute value). The running time of your program
	 * should be linearithmic in the worst case.
	 * O(n*log(n))
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new In("1Kints.txt").readAllInts();
		Arrays.sort(a);
		int[] closestPair = findClosestPairBruteForce(a);
		StdOut.println(String.format("%d %d", closestPair[0], closestPair[1]));
		StdOut.println(String.format("%d %d", a[closestPair[0]], a[closestPair[1]]));
	}
	
	private static int[] findClosestPairBruteForce(int[] a) {
		int N = a.length;
		int[] closestPair = new int[] {0,1};
		int currentClosest = Math.abs(a[closestPair[0]] - a[closestPair[1]]);
		for (int i = 0; i < N - 1; i++) {
			int nextDifference = Math.abs(a[i] - (a[i+1]));
			if (nextDifference < currentClosest) {
				closestPair[0] = i;
				closestPair[1] = i + 1;
				currentClosest = nextDifference;
			}
		}
		return closestPair;
	}
}
