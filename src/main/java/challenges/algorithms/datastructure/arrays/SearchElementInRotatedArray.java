package challenges.algorithms.datastructure.arrays;

/**
* You have an array of ints that is ordered
* [2,4,5,7,9,10,13,16,18,20,23,25]
* [10,15,16,20,25,31,39,42,45,46,50,61,70]
* It has been pivoted, so there are 2 ordered parts to it
* [18,20,23,25,2,4,5,7,9,10,13,16]
* [31, 39, 42, 45, 46, 50, 61, 70, 10, 15, 16, 20, 25]
* Write a method that finds a value in Olog(n) efficiency or better
* Here is your stub:
*/
public class SearchElementInRotatedArray {

    public static void main(String[] args) {
        int[] initialArray = {18,20,23,25,2,4,5,7,9,10,13,16};
        int valueFound = findElementRotatedArray(5, initialArray);
        System.out.println(valueFound);
    }

    public static int findElementRotatedArray(int val, int[] arr){
        int n = arr.length;
        int pivotIndex = findPivot(arr, 0, n - 1);

        //There is not a rotated array
        if (pivotIndex == -1 )
            return binarySearch(arr, 0, n- 1, val);

        if (arr[pivotIndex] == val) {
            return pivotIndex;
        }

        if (arr[0] <= val) {
            return binarySearch(arr, 0, pivotIndex, val);
        }
        return binarySearch(arr, pivotIndex + 1, n - 1, val);
    }


    private static int binarySearch(int[] arr, int low, int high, int value) {

        if (high < low) {
            return -1;
        }

        int middle = (low + high) / 2;

        if (arr[middle] == value) {
            return middle;
        }

        if (value > arr[middle]) {
            return binarySearch(arr, middle + 1, high, value);
        }

        return  binarySearch(arr, low, middle - 1, value);
    }


    private static int findPivot(int[] pivot, int low, int high) {
        if (high < low) {
            return -1;
        }

        if (high == low) {
            return low;
        }

        int middle = (low + high) / 2;
        if (middle < high && pivot[middle] > pivot[middle + 1]) {
            return middle;
        }
        if (middle > low && pivot[middle] < pivot[middle - 1]) {
            return middle - 1;
        }

        if (pivot[low] > pivot[middle]) {
            return findPivot(pivot, low, middle - 1);
        }

        return findPivot(pivot, middle + 1, high);
    }
}
