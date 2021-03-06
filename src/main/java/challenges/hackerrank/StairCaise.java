package challenges.hackerrank;

public class StairCaise {

	
	public static void main(String[] args) {
		int n = 6;
		staircase(n);
	}
	
    // Complete the staircase function below.
    static void staircase(int n) {
    	int m = 1;
    	for (int i = n; i > 0; i--) {
			String numberSimbol = new String(new char[m]).replace("\0", "#");
			String blankSimbol = new String(new char[i-1]).replace("\0"," ");
			System.out.println(blankSimbol+numberSimbol);
			m++;
		}
    }
}
