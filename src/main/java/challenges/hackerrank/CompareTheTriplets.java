package challenges.hackerrank;

import java.util.Arrays;
import java.util.List;

public class CompareTheTriplets {

	/*
	 * The task is to find their comparison points by comparing a[0] with b[0], a[1] with b[1], and a[2] with b[2].
		If a[i] > b[i], then Alice is awarded 1 point.
		If a[i] < b[i], then Bob is awarded 1 point.
		If a[i] = b[i], then neither person receives a point.
		Comparison points is the total points a person earned.
		Given a and b, determine their respective comparison points.
		
		Return
		int[2]: Alice's score is in the first position, and Bob's score is in the second.
	 */
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(1,3,5,4,50,100);
		List<Integer> b = Arrays.asList(2,3,3,3,40,100);
		int size = a.size();
		List<Integer> results = Arrays.asList(0,0);
		
		if(a.size() != b.size()) {
			throw new IllegalArgumentException("Invalid data according to constraints");
		}
		
		for (int i = 0; i < size; i++) {
			int comparison = Integer.compare(a.get(i), b.get(i));
			if(comparison > 0) {
				results.set(0, results.get(0) + 1);
			} else if(comparison < 0) {
				results.set(1, results.get(1) + 1);
			}
		}
		System.out.println(results.toString());
	}
}
