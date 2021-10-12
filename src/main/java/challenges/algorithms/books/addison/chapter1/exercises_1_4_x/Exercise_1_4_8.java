package challenges.algorithms.books.addison.chapter1.exercises_1_4_x;

import java.util.Arrays;

import challenges.algorithms.books.addison.libs.program.In;
import challenges.algorithms.books.addison.libs.program.StdOut;
import challenges.algorithms.books.addison.libs.program.StdRandom;
import challenges.algorithms.books.addison.libs.program.Stopwatch;

/*
 * 1.4.8 Write a program to determine the number pairs of values in an input file that
 * are equal. If your first try is quadratic, think again and use Arrays.sort() to develop
 * a linearithmic solution.
 */
public class Exercise_1_4_8 {

	// Get first index of key in nums between lo and hi
	@SuppressWarnings("unused")
	private static int findFirst(int[] nums, int key, int lo, int hi) {
		int first = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key == nums[mid]) {
				first = mid;
				hi = mid - 1;
			} else if (key < nums[mid]) {
				hi = mid - 1;
			} else if (key > nums[mid]) {
				lo = mid + 1;
			}
		}
		return first;
	}

	// Get last index of key in nums between lo and hi
	private static int findLast(int[] nums, int key, int lo, int hi) {
		int last = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key == nums[mid]) {
				last = mid;
				lo = mid + 1;
			} else if (key < nums[mid]) {
				hi = mid - 1;
			} else if (key > nums[mid]) {
				lo = mid + 1;
			}
		}
		return last;
	}

	// Get number of occurrences of key in nums between lo and hi
	private static int findCount(int[] nums, int key, int lo, int hi) {
		/*int first = findFirst(nums, key, lo, hi);
		if (first > -1)
			return findLast(nums, key, lo, hi) - first + 1;*/
		int last = findLast(nums, key, lo, hi);
		if (last > -1)
			return last - lo + 1;
		return 0;
	}

	public static int countEqualPairs(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) { // -> O(N)
			count += findCount(nums, nums[i], i + 1, nums.length - 1); //O(N)*internal[ (log(N))]
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = new In("1Kints.txt").readAllInts();
		//int[] nums = new int[] {1,1,1,3,4,4,9};
		//StdOut.print(countEqualPairs(nums));
		
		// Doubling test
        StdOut.printf("%8s %8s %10s\n", "Size", "Time", "Count");
        for (int i = 1; i <= 64; i *= 2) {
            int size = i * 200000;
            nums = new int[size];
            for (int j = 0; j < size; j++) {
                nums[j] = StdRandom.uniform(0, size);
            }
            Stopwatch timer = new Stopwatch();
            int count = countEqualPairs(nums);
            StdOut.printf("%8d %8.3f %10d\n", size, timer.elapsedTime(), count);
        }
	}
}
