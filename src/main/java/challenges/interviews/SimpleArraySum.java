package challenges.interviews;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleArraySum {
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,10,11};
		
		List<Integer> arrg = Arrays.stream(array).boxed().collect(Collectors.toList());
		int suma = IntStream.of(array).sum();
		int sumaReduce = arrg.stream().reduce(1, (a, b) -> a*b);
		System.out.println(suma);
		System.out.println(sumaReduce);
	}
}
