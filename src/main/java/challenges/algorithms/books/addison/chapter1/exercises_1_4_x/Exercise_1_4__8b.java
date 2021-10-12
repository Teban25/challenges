package challenges.algorithms.books.addison.chapter1.exercises_1_4_x;

import java.util.Arrays;

import challenges.algorithms.books.addison.libs.program.In;
import challenges.algorithms.books.addison.libs.program.StdOut;
import challenges.algorithms.books.addison.libs.program.StdRandom;
import challenges.algorithms.books.addison.libs.program.Stopwatch;

public class Exercise_1_4__8b {

	public static void main(String[] args) {
		int[] nums = new In("1Kints.txt").readAllInts();
		//int[] nums = new int[] {1,1,1,3,4,4,9};
		//StdOut.print(countEqualPairsBruceForce(nums));
		
		// Doubling test
        StdOut.printf("%8s %8s %10s\n", "Size", "Time", "Count");
        for (int i = 1; i <= 64; i *= 2) {
            int size = i * 200000;
            nums = new int[size];
            for (int j = 0; j < size; j++) {
                nums[j] = StdRandom.uniform(0, size);
            }
            Stopwatch timer = new Stopwatch();
            int count = countEqualPairsBruceForce(nums);
            StdOut.printf("%8d %8.3f %10d\n", size, timer.elapsedTime(), count);
        }
	}

	private static int countEqualPairsBruceForce(int[] nums) {
		int equalPairs = 0; // 1
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] != nums[i]) {
					break;
				}
				equalPairs++;
			}
		}
		return equalPairs;
	}
}
