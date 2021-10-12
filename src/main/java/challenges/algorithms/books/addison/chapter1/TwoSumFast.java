package challenges.algorithms.books.addison.chapter1;

import java.util.Arrays;

import challenges.algorithms.books.addison.libs.program.In;
import challenges.algorithms.books.addison.libs.program.StdOut;

public class TwoSumFast {

	public static int count(int[] a) { // Count pairs that sum to 0.
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			if (BinarySearch.rank(-a[i], a) > i)
				cnt++;
		return cnt;
	}

	public static void main(String[] args) {
		int[] a = new In("1Kints.txt").readAllInts();
		StdOut.println(count(a));
	}
}
