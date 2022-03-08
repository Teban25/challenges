package challenges.algorithms.datastructure.arrays;

public class FindMinimumElement {


    public static void main(String[] args) {
        int[] initArr = new int[]{ 12, 1234, 45, 67, 1};
        System.out.println(findMinimumElement(initArr));
    }

    /* Complexity n/2 -> O(n)*/
    public static int findMinimumElement(int[] initArr) {
        int minimum = initArr[0];
        int start = 1;
        int high = initArr.length - 1;

        while (start < high) {

            if (initArr[start] < minimum) {
                minimum = initArr[start];
            }

            if (initArr[high] < minimum) {
                minimum = initArr[high];
            }

            start++;
            high--;
        }

        return minimum;
    }
}
