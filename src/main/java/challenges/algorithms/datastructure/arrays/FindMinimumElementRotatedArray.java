package challenges.algorithms.datastructure.arrays;

public class FindMinimumElementRotatedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 2, 3, 4 };
        System.out.println(findMinimumElementRotatedArray(arr));
    }

    public static int findMinimumElementRotatedArray(int[] arr) {
        int pivot = findPivot(arr, 0, arr.length - 1);
        if(pivot == -1) {
            return arr[0];
        }
        return arr[pivot + 1];
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
