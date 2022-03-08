package challenges.algorithms.datastructure.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array (or string), the task is to reverse the array/string.
 * Examples :
 *
 *
 * Input  : arr[] = {1, 2, 3}
 * Output : arr[] = {3, 2, 1}
 *
 * Input :  arr[] = {4, 5, 1, 2}
 * Output : arr[] = {2, 1, 5, 4}
 */
public class ReverseString {

    public static void main(String[] args) {
        int[] initialArray = {4, 5, 1, 2};
        int[] array1 = reverseArrayComplexityN(initialArray);
        int[] array2 = reverseArrayComplexityNDivided2(initialArray);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Complexity O(n)
     * @param initialArray
     * @return
     */
    private static int[] reverseArrayComplexityN(int[] initialArray) {
        int n = initialArray.length;
        int[] finArr = new int[n];
        int positionF = finArr.length - 1;
        for (int i = 0; i < n; i++) {
            finArr[positionF - i] = initialArray[i];
        }
        return finArr;
    }

    /**
     * Complexity N/2 - Swap method
     * @param initialArray
     * @return
     */
    private static int[] reverseArrayComplexityNDivided2(int[] initialArray) {
        int start = 0, end = initialArray.length - 1;
        while (start < end) {
            int temp = initialArray[end];
            initialArray[end] = initialArray[start];
            initialArray[start] = temp;

            start++;
            end--;
        }

        return initialArray;
    }

    private static List<Integer> reverseArrayComplexityNDivided2WithList(List<Integer> initialArray) {
        int start = 0, end = initialArray.size() - 1;
        while (start < end) {
            int temp = initialArray.get(end);
            initialArray.set(end, initialArray.get(start));
            initialArray.set(start, temp);

            start++;
            end--;
        }

        return initialArray;
    }
}
