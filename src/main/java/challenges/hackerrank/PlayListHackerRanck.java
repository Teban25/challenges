package challenges.hackerrank;

import java.util.Arrays;
import java.util.List;

public class PlayListHackerRanck {

	public static void main(String[] args) {
		List<Integer> pairs = Arrays.asList(30, 20, 150, 100, 40,50,60,70,80,90,100,160);
		System.out.println(playList(pairs));
	}
	
	public static long playList(List<Integer> songs) {
		int numberOfPairs = 0;
		
		for (int i = 0; i < songs.size(); i++) {
			int element = songs.get(i);
			List<Integer> possiblePairs = songs.subList(i+1, songs.size());
			int pairsPerNumber = (int) possiblePairs.stream().filter(number -> ((number+element)%60)==0).count();
			numberOfPairs += pairsPerNumber;
		}
		
		return numberOfPairs;
	}
	
	/*
	 * private static boolean multipleOfAwholeMinute(int pair1, int pair2) { return
	 * ((pair1+pair2)%60) == 0; }
	 */
}
