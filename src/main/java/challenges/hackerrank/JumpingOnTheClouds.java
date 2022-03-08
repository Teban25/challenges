package challenges.hackerrank;

import java.util.List;

public class JumpingOnTheClouds {

    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(List.of(0,0,0,0,1,0)));
    }

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int numberOfJumps = 0;
        for (int i = 0; i < c.size() - 1;) {
            if (c.get(i + 1) == 1) {
                i = i + 2;
                numberOfJumps++;
            } else if ((i + 2 < c.size()) && c.get(i + 1) == 0 && c.get(i + 2) == 0) {
                i = i + 2;
                numberOfJumps++;
            } else {
                i = i + 1;
                numberOfJumps++;
            }

        }
        return numberOfJumps;
    }
}
