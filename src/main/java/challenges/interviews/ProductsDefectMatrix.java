package challenges.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsDefectMatrix {

	public static void main(String[] args) {
		List<List<Integer>> matrixOriginal = new ArrayList<>();
		List<Integer> row1 = Arrays.asList(1,0,0,0,1);
		List<Integer> row2 = Arrays.asList(1,0,0,1,1);
		List<Integer> row3 = Arrays.asList(0,0,0,1,0);
		List<Integer> row4 = Arrays.asList(0,1,1,1,1);
		List<Integer> row5 = Arrays.asList(0,1,0,1,0);
		matrixOriginal.add(row1);
		matrixOriginal.add(row2);
		matrixOriginal.add(row3);
		matrixOriginal.add(row4);
		matrixOriginal.add(row5);
		
				
		if (matrixOriginal.stream().filter(row -> row.size() != matrixOriginal.size()).count() > 0) {
			throw new IllegalArgumentException("The matrix is not square");
		}
		
		if (!containZeros(matrixOriginal)) {
			System.out.println(matrixOriginal.size());
		} else {
			int dimensionN = matrixOriginal.size() - 1;
			int highSubSquare = getValueHighSquareMatrix(matrixOriginal, dimensionN);
			if (highSubSquare > 1) {
				System.out.println(highSubSquare);
			} else {
				System.out.println("There is not a square sub matrix of just 1");
			}
		}
	}
	
	public static int getValueHighSquareMatrix(List<List<Integer>> matrixOriginal, int dimensionN) {
		while (dimensionN > 1) {
			List<Integer> range = range(matrixOriginal.size(), dimensionN);
			for (int initialRow = 0; initialRow < range.size(); initialRow++) {
				for (int initialCol = 0; initialCol < range.size(); initialCol++) {
					List<List<Integer>> subMatrix = extractSquareSubMatrix(matrixOriginal, initialRow, initialRow + dimensionN, initialCol, initialCol + dimensionN);
					boolean subMatrixContainZeros = containZeros(subMatrix);
					if (!subMatrixContainZeros) {
						System.out.println(subMatrix.toString());
						return subMatrix.size();
					}
				}
			}
			dimensionN--;
		}
		
		return 0;
	}
	
	public static List<Integer> range(int sizeMatrixOrignal, int dimension){
		int sizeRange = sizeMatrixOrignal - dimension +  1;
		List<Integer> ranges = new ArrayList<>();
		for (int value = 0; value < sizeRange; value++) {
			ranges.add(value);
		}
		
		return ranges;
	}
	
	public static List<List<Integer>> extractSquareSubMatrix(List<List<Integer>> matrixOriginal, int initialRow, int finalRow, int initialCol, int finalColum){
		List<List<Integer>> subMatrix = new ArrayList<>();
		for (int i = initialRow; i < finalRow; i++) {
			subMatrix.add(matrixOriginal.get(i).subList(initialCol, finalColum));
		}
		return subMatrix;
	}
	
	public static boolean containZeros(List<List<Integer>> subMatrix) {
		boolean existZero = subMatrix.stream().filter(row -> row.contains(0)).count() > 0;
		return existZero;
	}
}
