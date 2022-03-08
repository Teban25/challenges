package challenges.algorithms.datastructure.arrays;

import java.util.Arrays;

/**
 * Given an array of n elements. Our task is to write a program to rearrange the array such that elements at even
 * positions are greater than all elements before it and elements at odd positions are less than all elements before it.
 *
 * Input : arr[] = {1, 2, 3, 4, 5, 6, 7}
 * Output : 4 5 3 6 2 7 1
 *
 * Input : arr[] = {1, 2, 1, 4, 5, 6, 8, 8}
 * Output : 4 5 2 6 1 8 1 8
 */
public class RearrangeArrayConditionalEvenOrOdd {

    public static void main(String[] args) {
        int[] arr = new int []{ 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(Arrays.toString(rearrangeArrOddsAndPairs(arr, arr.length)));
    }

    private static int[] rearrangeArrOddsAndPairs(int[] arr, int n) {
        // total even position
        int evenPosition = n / 2;

        // total odd positions
        int oddPosition = n - evenPosition;

        int[] temporalArray = arr.clone();

        Arrays.sort(temporalArray);

        int j = oddPosition - 1;
        
        // Fill up odd position in original array
        for (int i = 0; i < n; i += 2) {
            arr[i] = temporalArray[j];
            j--;
        }

        j = oddPosition;

        // Fill up even positions in original array
        for (int i = 1; i < n; i += 2) {
            arr[i] = temporalArray[j];
            j++;
        }

        return arr;
    }
}
