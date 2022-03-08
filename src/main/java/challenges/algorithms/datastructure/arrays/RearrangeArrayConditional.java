package challenges.algorithms.datastructure.arrays;

import java.util.Arrays;

/**
 * Rearrange an array such that arr[i] = i
 *
 *
 * Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
 * Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
 *
 *
 * Input : arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
 *               11, 10, 9, 5, 13, 16, 2, 14, 17, 4}
 * Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 *          11, 12, 13, 14, 15, 16, 17, 18, 19]
 */
public class RearrangeArrayConditional {

    public static void main(String[] args) {
        int[] initialArr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        int[] rearrangeArr = rearrangeTheArray(initialArr);
        System.out.println(Arrays.toString(rearrangeArr));

        // Another approach
        int[] rearrangeArr2 = swapApproach(initialArr);
        System.out.println(Arrays.toString(rearrangeArr2));
    }

    private static int[] rearrangeTheArray(int[] initialArr) {
        int n = initialArr.length;
        int[] rearrangeArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (containsElement(initialArr, i)) {
                rearrangeArr[i] = i;
            } else {
                rearrangeArr[i] = -1;
            }

        }

        return rearrangeArr;
    }

    private static boolean containsElement(int[] initialArr, int value){
        boolean isContained = false;
        for (int i = 0; i < initialArr.length; i++) {
            if (initialArr[i] == value) {
                isContained = true;
                break;
            }
        }

        return isContained;
    }

    /**
     * This is the one I understand better
     * @param arr
     * @return
     */
    private static int[] swapApproach(int[] arr) {
        for (int i = 0; i < arr.length;)
        {
            if (arr[i] >= 0 && arr[i] != i)
            {
                int ele = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = ele;
            } else {
                i++;
            }
        }

        return arr;
    }

    private static int[] myOwnRearrangeBetter(int[] initialArr) {

        for (int i = 0; i < initialArr.length; i++) {

            if (initialArr[i] != -1 && initialArr[i] != i) {

                int valueOnIndexI = initialArr[i];

                while(initialArr[valueOnIndexI] != -1 && initialArr[valueOnIndexI] != valueOnIndexI) {

                    int aux = initialArr[valueOnIndexI];

                    initialArr[valueOnIndexI] = valueOnIndexI;

                    valueOnIndexI = aux;
                }

                initialArr[valueOnIndexI] = valueOnIndexI;

                if (initialArr[i] != i) {
                    initialArr[i] = - 1;
                }
            }
        }

        return initialArr;
    }


    /**
     * Another solution
     *
     */
    private static class RearrangeArrayConditional1 {

        public static int[] fix(int[] A)
        {
            for (int i = 0; i < A.length; i++)
            {
                if (A[i] != -1 && A[i] != i)
                {
                    int x = A[i];

                    // check if desired place
                    // is not vacate
                    while (A[x] != -1 && A[x] != x)
                    {
                        // store the value from
                        // desired place
                        int y = A[x];

                        // place the x to its correct
                        // position
                        A[x] = x;

                        // now y will become x, now
                        // search the place for x
                        x = y;
                    }

                    // place the x to its correct
                    // position
                    A[x] = x;

                    // check if while loop hasn't
                    // set the correct value at A[i]
                    if (A[i] != i)
                    {
                        // if not then put -1 at
                        // the vacated place
                        A[i] = -1;
                    }
                }
            }
            return A;
        }
    }
}

