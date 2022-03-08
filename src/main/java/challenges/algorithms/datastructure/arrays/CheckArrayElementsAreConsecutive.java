package challenges.algorithms.datastructure.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an unsorted array of numbers, write a function that returns true if the array consists of consecutive numbers.
 * Examples:
 * a) If the array is {5, 2, 3, 1, 4}, then the function should return true
 * because the array has consecutive numbers from 1 to 5.
 * b) If the array is {83, 78, 80, 81, 79, 82}, then the function should return true
 * because the array has consecutive numbers from 78 to 83.
 * c) If the array is {34, 23, 52, 12, 3}, then the function should return false
 * because the elements are not consecutive.
 * d) If the array is {7, 6, 5, 5, 3, 4}, then the function should return false
 * because 5 and 5 are not consecutive.
 */
public class CheckArrayElementsAreConsecutive {

    public static void main(String[] args) {
        int[] elements = new int[]{7, 6, 5, 5, 3, 4};
        System.out.println(elementsAreConsecutive(elements));
    }

    private static boolean elementsAreConsecutive(int[] arr) {
        Set<Integer> uniqueValues = new HashSet<>();
        int min = arr[0], max = arr[0];
        uniqueValues.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (uniqueValues.contains(arr[i])) {
                return false;
            }

            if (arr[i] > max) {
                max = arr[i];
            } else if(arr[i] < min) {
                min = arr[i];
            }
            uniqueValues.add(arr[i]);
        }

        return (max - min + 1) == arr.length;
    }
}
