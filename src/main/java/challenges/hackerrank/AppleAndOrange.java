package challenges.hackerrank;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Function Description
 *
 * Complete the countApplesAndOranges function in the editor below.
 * It should print the number of apples and oranges that land on Sam's house, each on a separate line.
 *
 * countApplesAndOranges has the following parameter(s):
 *
 * s: integer, starting point of Sam's house location.
 * t: integer, ending location of Sam's house location.
 * a: integer, location of the Apple tree.
 * b: integer, location of the Orange tree.
 * apples: integer array, distances at which each apple falls from the tree.
 * oranges: integer array, distances at which each orange falls from the tree.
 */
public class AppleAndOrange {

    public static void main(String[] args) {
        countApplesAndOranges(7, 10, 4, 12, List.of(2,3,-4), List.of(3,-2,-4));
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int totalApplesOnSamHouse = totalApplesOnSamHouse(s, t, a, apples);
        int totalOrangesOnSamHouse = totalOrangesOnSamHouse(s, t, b, oranges);

        System.out.println(totalApplesOnSamHouse);
        System.out.println(totalOrangesOnSamHouse);
    }

    private static int totalApplesOnSamHouse(int leftSamHouse, int rightSamHouse, int appleTree, List<Integer> apples) {
        AtomicInteger numberOfApplesOnSamHouse = new AtomicInteger();
        if (apples != null && !apples.isEmpty()) {
            apples.forEach(apple -> {
                int distanceFromSamHouse = apple +  appleTree;
                if(distanceFromSamHouse >= leftSamHouse && distanceFromSamHouse <= rightSamHouse) {
                    numberOfApplesOnSamHouse.getAndIncrement();
                }
            });
        }
        return numberOfApplesOnSamHouse.get();
    }

    private static int totalOrangesOnSamHouse(int leftSamHouse, int rightSamHouse, int orangeTree, List<Integer> oranges) {
        AtomicInteger numberOfOrangeOnSamHouse = new AtomicInteger();
        if (oranges != null && !oranges.isEmpty()) {
            oranges.forEach(orange -> {
                int distanceFromSamHouse = orange +  orangeTree;
                if(distanceFromSamHouse >= leftSamHouse && distanceFromSamHouse <= rightSamHouse) {
                    numberOfOrangeOnSamHouse.getAndIncrement();
                }
            });
        }
        return numberOfOrangeOnSamHouse.get();
    }
}
