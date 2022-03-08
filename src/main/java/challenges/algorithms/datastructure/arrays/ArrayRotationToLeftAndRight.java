package challenges.algorithms.datastructure.arrays;

import java.util.Arrays;

/**
 * Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12} for n = 12 and d = 3
 *  arr[] after --> {4 5 6 7 8 9 10 11 12 1 2 3}
 *
 * Instead of moving one by one, divide the array in different sets
 * where number of sets is equal to GCD of n and d and move the elements within sets.
 * If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only, we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.
 * Here is an example for n =12 and d = 3. GCD is 3 and
 */
public class ArrayRotationToLeftAndRight {


    public static void main(String[] args) {
        int elements[] = {10,15,16,20,25,31,39,42,45,46,50,61,70};
        int elementsToRotateLeft[] = elements.clone();
        int elementsToRotateRight[] = elements.clone();
        System.out.println(Arrays.toString(elements));
        rotateToLeft(elementsToRotateLeft, 8, elementsToRotateLeft.length);
        System.out.println(Arrays.toString(elementsToRotateLeft));

        rotateToRight(elementsToRotateRight, 8, elementsToRotateRight.length);
        System.out.println(Arrays.toString(elementsToRotateRight));
    }

    private static void rotateToLeft(int elements[], int distanceToRotate, int sizeOfElements) {

        /* To Handle if d >= n */
        distanceToRotate = distanceToRotate % sizeOfElements;
        int gcd = gcd(distanceToRotate, sizeOfElements);

        for (int i = 0; i < gcd; i++) {
            /* Move i-th values of blocks */
            int temporal = elements[i];
            int j = i;
            while (true) {
                int k = j + distanceToRotate;
                if (k >= sizeOfElements) {
                    k = k - sizeOfElements;
                }
                if (k == i) {
                    break;
                }
                elements[j] = elements[k];
                j = k;
            }
            elements[j]  = temporal;
        }
    }

    private static void rotateToRight(int elements[], int distanceToRotate, int sizeOfElements) {

        /* To Handle if d >= n */
        distanceToRotate = distanceToRotate % sizeOfElements;
        int gcd = gcd(distanceToRotate, sizeOfElements);

        for (int i = 0; i < gcd; i++) {
            /* Move i-th values of blocks */
            int initialIndex = sizeOfElements - 1 - i;
            int j = initialIndex;
            int temporal = elements[j];
            while (true) {
                int k = j - distanceToRotate;
                if (k < 0) {
                    k = (sizeOfElements) + k;
                }
                if (k == initialIndex) {
                    break;
                }
                elements[j] = elements[k];
                j = k;
            }
            elements[j]  = temporal;
        }
    }

    /**
     * Function to get gcd of a and b
     * @param distanceToRotate
     * @param sizeOfElements
     * @return
     */
    private static int gcd(int distanceToRotate, int sizeOfElements) {

        if (sizeOfElements == 0) {
            return distanceToRotate;
        } else {
            return gcd(sizeOfElements, distanceToRotate % sizeOfElements);
        }
    }
}
