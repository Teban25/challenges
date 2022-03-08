package challenges.hackerrank;

/**
 * There is a string, , of lowercase English letters that is repeated infinitely many times. Given an integer, , find
 * and print the number of letter a's in the first  letters of the infinite string.
 *
 * Example
 * s = "abcac"
 * n = 10
 * The substring we consider is "abcacabcac", the first 10 characters of the infinite string. There are 4 occurrences
 * of 'a' in the substring.
 *
 * Function Description
 *
 * Complete the repeatedString function in the editor below.
 *
 * repeatedString has the following parameter(s):
 *
 * s: a string to repeat
 * n: the number of characters to consider
 *
 * Returns
 *
 * int: the frequency of a in the substring
 *
 * Sample Input 1
 *
 * a
 * 1000000000000
 * Sample Output 1
 *
 * 1000000000000
 */
public class RepeatedString {

    private static final char A = 'a';

    public static void main(String[] args) {
        String test1 = "abcac";
        System.out.println(repeatedString(test1, 10L));
    }

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Find the number of occurrences of 'a' in s
        long occurrencesOfAInString = 0L;
        int m = s.length();
        long timesStringInN = n / m;
        if (timesStringInN > 0) {
            occurrencesOfAInString = findOccurrencesInString(s, s.length());
            occurrencesOfAInString = (timesStringInN*occurrencesOfAInString);
        }

        int residual = (int) (n % m);
        if(residual != 0) {
            long residualStringOccurrences = findOccurrencesInString(s, residual);
            occurrencesOfAInString += residualStringOccurrences;
        }

        return occurrencesOfAInString;
    }

    private static long findOccurrencesInString(String s, int high) {
        long occurrences = 0L;

        for (int i = 0; i < high; i++) {
            if (s.charAt(i) == A) {
                occurrences++;
            }
        }

        return occurrences;
    }
}
