package challenges.interviews;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusMinus {

	/**
	 * Plus minus hacker rank
	 * 
	 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. 
	 * Print the decimal value of each fraction on a new line with  places after the decimal.
	 * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
	 * Example
	 * There are 5 elements in the array (1,1,0,-1,-1), two positive, two negative and one zero. Their ratios are 2/5,  2/5 and 1/5. Results are printed as:
	 * 
	 * 0.400000
	 * 0.400000
	 * 0.200000
	 * @param args
	 */
    public static void main(String[] args) {
    	int[] arr = {-4,3,-9,0,4,1};
    	List<Integer> arrg = Arrays.stream(arr).boxed().collect(Collectors.toList());
    	double positiveRadio = Double.valueOf(arrg.stream().filter(i -> i > 0).count())/Double.valueOf(arrg.size());
    	double negativeRadio = Double.valueOf(arrg.stream().filter(i -> i < 0).count())/Double.valueOf(arrg.size());
    	double zeroRadio = Double.valueOf(arrg.stream().filter(i -> i == 0).count())/Double.valueOf(arrg.size());
    	
    	System.out.println(String.format("%.6f", positiveRadio));
    	System.out.println(String.format("%.6f", negativeRadio));
    	System.out.println(String.format("%.6f", zeroRadio));
    	/*
    	BigDecimal positivePrecision = new BigDecimal(positiveRadio).setScale(6, RoundingMode.DOWN);
    	BigDecimal negativePresicion = new BigDecimal(negativeRadio).setScale(6, RoundingMode.DOWN);
    	BigDecimal zeroPresicion = new BigDecimal(zeroRadio).setScale(6, RoundingMode.DOWN);
    	
    	System.out.println(positivePrecision);
    	System.out.println(negativePresicion);
    	System.out.println(zeroPresicion);
    	*/
    }
}
