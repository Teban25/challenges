package challenges.hackerrank;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of bird sightings where every element represents a bird type id, determine the id of
 * the most frequently sighted type. If more than 1 type has been spotted that maximum amount,
 * return the smallest of their ids.
 *
 * Sample Input 0
 * 6
 * 1 4 4 4 5 3
 * Sample Output 0
 * 4
 *
 * Sample Input 1
 * 11
 * 1 2 3 4 5 4 3 2 1 3 4
 * Sample Output 1
 * 3
 */
public class MigratoryBirds {
	
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1,2,3,4,5,4,3,2,1,3,4);
		//List<Integer> values = Arrays.asList(1,4,4,4,5,3);
		System.out.println(migratoryBirds(values));
	}
	
	/*
	 * Complete the 'migratoryBirds' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */
	
	public static int migratoryBirds(List<Integer> arr) {
		// Write your code here
		Map<Integer, Long> typesByFrequency = arr.stream()
				.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
		
		Map.Entry<Integer,Long> maxValue = Collections.max(typesByFrequency.entrySet(), (o1, o2) -> {
			if(o1.getValue() == o2.getValue()) {
				if(o1.getKey() < o2.getKey()) {
					return 1;
				}
			} else if(o1.getValue() > o2.getValue()) {
				return 1;
			}
			return - 1;
		});
		
		
		return maxValue.getKey();
	}
}
