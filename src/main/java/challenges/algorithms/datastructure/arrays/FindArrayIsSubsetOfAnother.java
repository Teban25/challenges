package challenges.algorithms.datastructure.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not.
 * Both the arrays are not in sorted order. It may be assumed that elements in both array are distinct.
 *
 * Examples:
 *
 * Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
 * Output: arr2[] is a subset of arr1[]
 *
 * Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4}
 * Output: arr2[] is a subset of arr1[]
 *
 * Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
 * Output: arr2[] is not a subset of arr1[]
 */
public class FindArrayIsSubsetOfAnother {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 2, 23, 19};
        int[] subArray = new int[]{19, 5, 3};
        System.out.println(isSubsetOfArray(arr, subArray));
    }

    public static boolean isSubsetOfArray(int[] arr, int[] subArray) {
        Map<Integer, Long> frequencies = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        HashMap::new,
                        Collectors.counting()));

        for (int i = 0; i < subArray.length; i++) {
            if (frequencies.getOrDefault(subArray[i], 0L) > 0) {
                frequencies.put(subArray[i], frequencies.get(subArray[i]) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
