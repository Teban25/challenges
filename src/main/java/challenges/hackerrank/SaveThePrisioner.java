package challenges.hackerrank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
/*
 * A jail has a number of prisoners and a number of treats to pass out to them. 
 * Their jailer decides the fairest way to divide the treats is to seat the prisoners 
 * around a circular table in sequentially numbered chairs. A chair number will be drawn from a hat. 
 * Beginning with the prisoner in that chair, one candy will be handed to each prisoner sequentially 
 * around the table until all have been distributed.
 * 
 * The jailer is playing a little joke, though. The last piece of candy looks like all the others, but it tastes awful.
 * Determine the chair number occupied by the prisoner who will receive that candy.
 * 
 * Function Description
 * 
 * Complete the saveThePrisoner function in the editor below. 
 * It should return an integer representing the chair number of the prisoner to warn.
 * saveThePrisoner has the following parameter(s):
 * int n: the number of prisoners
 * int m: the number of sweets
 * int s: the chair number to begin passing out sweets from
 * Returns
 * int: the chair number of the prisoner to warn
 * 
 * 7 19 2 -> 6
 */
public class SaveThePrisioner {

	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("input1.txt"));
		for (String linea : input) {
			String[] parametros = linea.split(" ");
			System.out.println(saveThePrisoner2(
					Integer.valueOf(parametros[0]),
					Integer.valueOf(parametros[1]), 
					Integer.valueOf(parametros[2])));
		}
		
		//System.out.println(saveThePrisoner2(5,838370030,1));
	}
	
	public static int saveThePrisoner2(int n, int m, int s) {
		s = (s - 1) == 0 ? n : (s - 1);
		if (m > n) {
			int avanzar = (m % n);
			if (avanzar == 0) {
				return s;
			} else if ((s + avanzar) > n) {
				s = ((s + avanzar)) - n;
			} else {
				s = s + (avanzar);
			}
		} else {
			if ((s + m) > n) {
				s = ((s + m)) - n;
			} else {
				s = s + m;
			}
		}
		return s;
	}
}
