package challenges.algorithms.datastructure.arrays;

import java.util.*;

/**
 * Write a program that, given an array A[] of n numbers and another number x, determines whether or not there exist
 * two elements in A[] whose sum is exactly x.
 *
 * Examples:
 *
 * Input: arr[] = {0, -1, 2, -3, 1}
 *         sum = -2
 * Output: -3, 1
 *          Valid pair exists.
 *
 * If we calculate the sum of the output,
 * 1 + (-3) = -2
 *
 * Input: arr[] = {1, -2, 1, 0, 5}
 *        sum = 0
 * Output:
 *         No valid pair exists.
 */
public class CheckSumPairsInArray {

    public static void main(String[] args) {
        int[] initialArray = { 1, 4, 45, 6, 10, 8 };
        Map<Integer, Integer> pairsFB = getPairsForceBrute(initialArray, 16);
        pairsFB.forEach((key, value) -> System.out.println(key + "-" + value));
        System.out.println("----------------------------------------------------");
        Map<Integer, Integer> pairsSetHash = getPairsUsingHash(initialArray, 16);
        pairsSetHash.forEach((key, value) -> System.out.println(key + "-" + value));
    }

    private static Map<Integer, Integer> getPairsForceBrute(int[] initialArray, int value) {
        Map<Integer, Integer> pairsFB = new HashMap<>();
        for (int i = 0; i < initialArray.length - 1; i++) {
            for (int j = i + 1; j < initialArray.length; j++) {
                if ((initialArray[i] + initialArray[j]) == value) {
                    pairsFB.put(initialArray[i], initialArray[j]);
                }
            }
        }
        return pairsFB;
    }

    private static Map<Integer, Integer> getPairsUsingHash(int[] initialArray, int value) {
        Map<Integer, Integer> pairsSetHash = new HashMap<>();
        Set<Integer> alreadyAdded = new HashSet<>();

        for (int i = 0; i < initialArray.length; i++) {

            int result = value - initialArray[i];

            if (alreadyAdded.contains(result)) {
                pairsSetHash.put(initialArray[i], result);
            }
            alreadyAdded.add(initialArray[i]);
        }
        return pairsSetHash;
    }
}
