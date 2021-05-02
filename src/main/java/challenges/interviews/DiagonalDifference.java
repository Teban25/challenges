package challenges.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {

	public static void main(String[] args) {
		List<List<Integer>> mat = new ArrayList<List<Integer>>();
		List<Integer> row1 = new ArrayList<Integer>(Arrays.asList(1,2,4));
		List<Integer> row2 = new ArrayList<Integer>(Arrays.asList(4,8,6));
		List<Integer> row3 = new ArrayList<Integer>(Arrays.asList(9,8,10));
		mat.add(row1);
		mat.add(row2);
		mat.add(row3);
		int result = diagonalDifference(mat);
		
		System.out.println(result);
	}
	
	private static int diagonalDifference(List<List<Integer>> arr) {
		int size = arr.size();
		int sumRightDiag = 0;
		int sumLeftDiag = 0;
		int j = size - 1;

		for (int i = 0; i < size; i++) {
			sumRightDiag = sumRightDiag + arr.get(i).get(i);
			sumLeftDiag = sumLeftDiag + arr.get(i).get(j);
			j--;
		}
		return Math.abs(sumRightDiag - sumLeftDiag);
	}
}
