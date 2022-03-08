package challenges.algorithms.datastructure.arrays;

/**
 * Given an array that is sorted and then rotated around an unknown point.
 * Find if the array has a pair with a given sum ‘x’. It may be assumed that all elements in the array are distinct.
 *
 * Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
 * Output: true
 * There is a pair (6, 10) with sum 16
 *
 * Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35
 * Output: true
 * There is a pair (26, 9) with sum 35
 *
 * Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45
 * Output: false
 * There is no pair with sum 45.
 */
public class SearchPairInRotatedArray {

    public static void main(String[] args) {
        int[] initialArray = new int[] {11, 15, 26, 38, 9, 10};
        System.out.println(searchPairInRotatedArray(initialArray, initialArray.length, 45));
    }

    private static boolean searchPairInRotatedArray(int initialArr[], int size, int valueSum) {
        int pivot = findPivot(initialArr, 0, size - 1);
        
        int indexSmallestElem = (pivot + 1) % size;
        int indexLargestElem = pivot;
        
        while (indexSmallestElem != indexLargestElem) {
            
            if(initialArr[indexSmallestElem] + initialArr[indexLargestElem] == valueSum) {
                return true;
            }
            
            // move to the higher sum
            if(initialArr[indexSmallestElem] + initialArr[indexLargestElem] < valueSum) {
                indexSmallestElem = (indexSmallestElem + 1) % size;
            } else { // move to the lower sum side
                indexLargestElem = (size + indexLargestElem - 1) % size;
            }
        }
        return false;
    }
    
    private static int findPivot(int[] rotatedArr, int low, int high) {
        if (high < low) {
            return rotatedArr[0];
        }
        
        if (high == low) {
            return low;
        }
        
        int middle = (low + high) / 2;
        if (middle < high && rotatedArr[middle] > rotatedArr[middle + 1]) {
            return middle;
        }
        if (middle > low && rotatedArr[middle] < rotatedArr[middle - 1]) {
            return middle - 1;
        }
        
        if (rotatedArr[low] > rotatedArr[middle]) {
            return findPivot(rotatedArr, low, middle - 1);
        }
        
        return findPivot(rotatedArr, middle + 1, high);
    }
}
