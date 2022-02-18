package challenges.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * There will be two arrays of integers. Determine all integers that satisfy the following two conditions:
 *
 *  1. The elements of the first array are all factors of the integer being considered
 *  2. The integer being considered is a factor of all elements of the second array
 * These numbers are referred to as being between the two arrays. Determine how many such numbers exist.
 */
public class BetweenTwoSets {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static void main(String[] args) {
        System.out.println(getTotalX(List.of(2,4), List.of(16, 32, 96)));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        Integer numbersBetweenSetsSatisfied = 0;
        if (a != null && !a.isEmpty() && b != null && !b.isEmpty()) {
            List<Integer> numbersBetweenSets = numbersBetweenSets(a.get(a.size() - 1), b.get(0));
            List<Integer> numbersSatisfiedFirstCondition = numbersSatisfiedFirstCondition(a, numbersBetweenSets);
            numbersBetweenSetsSatisfied = numbersSatisfiedSecondCondition(b, numbersSatisfiedFirstCondition);
        }

        return numbersBetweenSetsSatisfied;
    }

    private static Integer numbersSatisfiedSecondCondition(List<Integer> secondArray,
                                                           List<Integer> numbersSatisfiedFirstCondition) {
        return Math.toIntExact(numbersSatisfiedFirstCondition.stream()
                .filter(numberBetweenSet -> evaluateAllAreDividedBy.test(secondArray, numberBetweenSet)).count());
    }

    private static List<Integer> numbersSatisfiedFirstCondition(List<Integer> firstArr, List<Integer> numbersBetweenSets) {
        return numbersBetweenSets.stream()
                .filter(numberBetweenSet -> evaluateAllAreFactors.test(numberBetweenSet, firstArr))
                .collect(Collectors.toList());
    }

    private static BiPredicate<Integer, List<Integer>> evaluateAllAreFactors = (numberBetweenSet, firstArray) -> {
        boolean areAllFactors = true;
        for (Integer elementOnFirstArray : firstArray) {
            if((numberBetweenSet % elementOnFirstArray) != 0) {
                areAllFactors = false;
                break;
            }
        }

        return  areAllFactors;
    };

    private static BiPredicate<List<Integer>, Integer> evaluateAllAreDividedBy = (secondArray, numberBetweenSet) -> {
        boolean areAllDivided = true;
        for (Integer elementOnSecondArray : secondArray) {
            if((elementOnSecondArray % numberBetweenSet) != 0) {
                areAllDivided = false;
                break;
            }
        }

        return  areAllDivided;
    };

    private static List<Integer> numbersBetweenSets(Integer firstNumber, Integer lastNumber) {
        List<Integer> numbersBetweenSets = new ArrayList<>();

        if(firstNumber <= lastNumber) {
            numbersBetweenSets = IntStream.rangeClosed(firstNumber, lastNumber).boxed().collect(Collectors.toList());
        }

        return numbersBetweenSets;
    }
}
