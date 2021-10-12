package challenges.hackerrank;

import java.util.Arrays;
import java.util.List;

/*
 * You are in charge of the cake for a child's birthday. 
 * You have decided the cake will have one candle for each year of their total age.
 * They will only be able to blow out the tallest of the candles. Count how many candles are tallest.
 * 
 * input -> 3 2 1 3 -> size 4
 * output -> 2, return how many times there are the highest element.
 */
public class BirthDayCakeCandles {

	public static void main(String[] args) {
		System.out.println(birthdayCakeCandles(Arrays.asList(3,2,1,3)));
	}

	/**
	 * sort array -> n*log(n), search maximum -> n, final -> n^2*log(n)
	 * @param candles
	 * @return
	 */
	public static int birthdayCakeCandles(List<Integer> candles) {
		int tallest = candles.size() > 0 ? candles.get(0) : 0;
		int times = 1;
		for (int i = 1; i < candles.size(); i++) {
			if (tallest == candles.get(i)) {
				times++;
			} else if (tallest < candles.get(i)) {
				tallest = candles.get(i);
				times = 1;
			}
		}
		return times;
	}
}
