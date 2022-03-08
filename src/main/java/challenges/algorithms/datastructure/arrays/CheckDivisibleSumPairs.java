package challenges.algorithms.datastructure.arrays;

import java.util.*;

/**
 * Given an array of integers and a positive integer k, determine the number of (i, j)  pairs where i < j
 * and ar[i] + ar[j] is divisible by k.
 *
 * Example
 *  ar = [1,2,3,4,5,6]
 *  k = 5
 *
 * Three pairs meet the criteria: [1,4], [2,3] and [4,6].
 *
 * Function Description
 *
 * Complete the divisibleSumPairs function in the editor below.
 *
 * divisibleSumPairs has the following parameter(s):
 *
 * int n: the length of array ar
 * int ar[n]: an array of integers
 * int k: the integer divisor
 */
public class CheckDivisibleSumPairs {

    static class Pair {
        int value1;
        int value2;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1,2,3,4,5,6};
        System.out.println("-------------------------FB-----------------------");
        //System.out.println(divisibleSumPairsForceBrute(6, 3, List.of(1, 3, 2, 6, 1, 2)));
        System.out.println(divisibleSumPairs(6, 5, List.of(1, 3, 2, 6, 1, 2)));
        System.out.println("-------------------------FB END-----------------------");
    }

    public static int divisibleSumPairsForceBrute(int n, int k, List<Integer> ar) {

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < ar.size() - 1; i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if((ar.get(i) + ar.get(j)) % k == 0) {
                    Pair pair = new Pair();
                    pair.value1 = ar.get(i);
                    pair.value2 = ar.get(j);
                    pairs.add(pair);
                }
            }
        }

        for (Pair pair: pairs) {
            System.out.println(String.format("[%d,%d]", pair.value1, pair.value2));
        }

        return pairs.size();
    }

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int[] frequency = new int[k];

        for (int i = 0; i < n; i++) {
            ++frequency[ar.get(i) % k];
        }

        int sum = frequency[0] * (frequency[0] - 1) / 2;
        // count for all i and (k-i)
        // freq pairs
        for (int i = 1; i <= k / 2 && i != (k - i); i++) {
            sum += frequency[i] * frequency[k - i];
        }

        // If K is even
        if (k % 2 == 0) {
            sum += (frequency[k / 2] * (frequency[k / 2] - 1) / 2);
        }

        return sum;
    }

    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairsPrimitive(int n, int k, int[] ar) {
        // Write your code here
        int[] frequency = new int[k];

        for (int i = 0; i < n; i++) {
            ++frequency[ar[i] % k];
        }

        int sum = frequency[0] * (frequency[0] - 1) / 2;
        // count for all i and (k-i)
        // freq pairs
        for (int i = 1; i <= k / 2 && i != (k - i); i++) {
            sum += frequency[i] * frequency[k - i];
        }

        // If K is even
        if (k % 2 == 0) {
            sum += (frequency[k / 2] * (frequency[k / 2] - 1) / 2);
        }

        return sum;
    }
}
