package challenges.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import challenges.algorithms.books.addison.libs.program.StdOut;
import challenges.algorithms.books.addison.libs.program.Stopwatch;

public class MergeSort {

	public static void main(String[] args) {
		List<Integer> unsortedList = Arrays.asList(2, 5, 3, 7, 1, 9, 6,15,11,25,18);
		StdOut.printf("%8s %8s %8s\n", "Size", "Time", "Algorithm used");
		Stopwatch timer = new Stopwatch();
		MergeSort.MergeSortImp.sort(unsortedList);
		// StdOut.printf("%8d %8.3f %10d\n", timer.elapsedTime());
		StdOut.printf("%8d %8.3f %8s\n", unsortedList.size(), timer.elapsedTime(), "Own merge sort");
		System.out.println(unsortedList.toString());
	}

	private static class MergeSortImp {

		public static void sort(List<Integer> unsortedList) {
			sort(unsortedList, 0, unsortedList.size() - 1);
		}

		private static void sort(List<Integer> original, int start, int end) {
			if (start < end) {
				int middle = (start + end) / 2;
				sort(original, start, middle);
				sort(original, middle + 1, end);
				mergeList(original, start, middle, end);
			}
		}

		private static void mergeList(List<Integer> original, int start, int middle, int end) {
			List<Integer> aux = new ArrayList<>();
			int left = start, right = middle + 1;
			while ((left <= middle) && (right <= end)) {
				// is it necessary the aux indice?
				if (original.get(left) < original.get(right)) {
					aux.add(original.get(left));
					left++;
				} else {
					aux.add(original.get(right));
					right++;
				}
			}
			// add the missing elements into aux collection
			for (int k = left; k <= middle; k++) {
				aux.add(original.get(k));
			}
			for (int k = right; k <= end; k++) {
				aux.add(original.get(k));
			}
			// "synchronize" aux list with original list
			for (int k = 0; k < aux.size(); k++) {
				original.set(start + k, aux.get(k));
			}
		}
	}
}
