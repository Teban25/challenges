package challenges.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularArrayRotation {

	public static void main(String[] args) {
		System.out.println(circularArrayRotation(Arrays.asList(1,2,3), 2, Arrays.asList(0,1,2)));
	}

	/**
	 * 
	 * @param a -> original array
	 * @param k ->  the rotation count
	 * @param queries-> the indices to report
	 * @return
	 */
	public static List<Integer> circularArrayRotation2(List<Integer> a, int k, List<Integer> queries) {
		int size = a.size();
		List<Integer> rotated = new ArrayList<>();
		for (int i = 0; i < k; i++) {	
			List<Integer> aux = new ArrayList<>();
			aux.add(a.get(size-1));
			aux.addAll(a.subList(0, size - 1));
			a = aux;
		}
		for(Integer query : queries) {
			rotated.add(a.get(query));
		}
		return rotated;
	}
	
	public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
		int size = a.size();
		List<Integer> rotated = new ArrayList<>();
		if (k > a.size()) {
			k = k%a.size();
		}
		for(Integer query : queries) {
			if (query - k >= 0) {
				rotated.add(a.get(query - k));
			} else {
				int difference = Math.abs(query - k);
				rotated.add(a.get(size - difference));
			}
		}
		return rotated;
	}
}
