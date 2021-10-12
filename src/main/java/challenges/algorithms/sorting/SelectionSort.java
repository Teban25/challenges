package challenges.algorithms.sorting;

import challenges.algorithms.books.addison.libs.program.StdOut;
import challenges.algorithms.books.addison.libs.program.StdRandom;
import challenges.algorithms.books.addison.libs.program.Stopwatch;

public class SelectionSort {

	/* input - unsorted array of n size
	 * output - sorted array of n size
	 */
	public static void main(String[] args) {
		// Doubling test
		//int[] unsorted = new int[] {4,3,8,45,1,9,7,2};
		int[] nums = new int[0];
        StdOut.printf("%8s %8s %10s\n", "Size", "Time", "Count");
        for (int i = 1; i <= 64; i *= 2) {
            int size = i * 2000;
            nums = new int[size];
            for (int j = 0; j < size; j++) {
                nums[j] = StdRandom.uniform(0, size);
            }
            Stopwatch timer = new Stopwatch();
            sortBySelection(nums);
            StdOut.printf("%8d %8.3f\n", size, timer.elapsedTime());
        }
    }
	
	private static int[] sortBySelection(int[] elements) {
		for (int i = 0; i < elements.length; i++) {
			int min = i;
			for (int j = i + 1; j < elements.length; j++) {
				if (elements[j] < elements[min]) {
					min = j;
				}
			}
			int aux = elements[i];
			elements[i] = elements[min];
			elements[min] = aux;
		}
		
		return elements;
	}
}
