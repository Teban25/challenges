package challenges.hackerrank;

import java.util.Arrays;
import java.util.List;

public class SubArrayDivisionBirthdayChocolate {

    public static void main(String[] args) {
        List<Integer> chocolateValues = Arrays.asList(4,1);
        int d = 4;
        int m = 1;
        System.out.println(birthday(chocolateValues,d, m));
    }

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */
    public static int birthday(List<Integer> s, int d, int m) {
        int limit = s.size();
        int numberWays = 0;
        for (int i = 0; i <= (limit - m); i++) {
            int result = sumInternalValues(s, i, i + m);
            if (result == d) {
                numberWays++;
            }
        }
        return numberWays;
    }

    private static int sumInternalValues(List<Integer> s, int low, int high) {
        int sum = 0;
        while (low < high) {
            sum += s.get(low);
            low++;
        }
        return sum;
    }
}
