package challenges.algorithms.books.addison.chapter1;

public class InterestingAlgorithms {

	/*
	 * reverse the elements within an array
	 */
	public static void reverseElement(double[] a) {
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			double temp = a[i];
			a[i] = a[n - 1 - i];
			a[n - i - 1] = temp;
		}
	}

	/*
	 * primality test
	 */
	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static double inFactorial(int n) {
		return Math.log(factorial(n));
	}
	
	public static double logNaturalFactorial(int n) {
		if(n == 1) {
			return 0;
		}
		return Math.log(n) + logNaturalFactorial(n - 1);
	}
	
	public static double factorial(double n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public static void ascendingThreeNumbers(int a, int b, int c) {
		int t = 0;
		if (a > b) {
			t = a;
			a = b;
			b = t;
		}
		if (a > c) {
			t = a;
			a = c;
			c = t;
		}
		if (b > c) {
			t = b;
			b = c;
			c = t;
		}

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	
	public static boolean isPalindrome(String s) {
		int size = s.length();
		for (int i = 0; i < size/2; i++) {
			if (s.charAt(i) != s.charAt(size-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isSorted(String[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i-1].compareTo(a[i]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(logNaturalFactorial(5));
		System.out.println(factorial(5));
		System.out.println(inFactorial(10));
		/*------------------------------------------------*/
		System.out.println("/*------------------------------------------------*/");
		ascendingThreeNumbers(9,5,8);
		System.out.println("/*------------------------------------------------*/");
		/*------------------------------------------------*/
	}
}
