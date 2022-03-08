package challenges.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. She tabulates
 * the number of times she breaks her season record for most points and least points in a game. Points scored in
 * the first game establish her record for the season, and she begins counting from there.
 *
 * Example
 * scores = [12, 24, 10, 24]
 * Scores are in the same order as the games played. She tabulates her results as follows:
 *
 *                                      Count
 *     Game  Score  Minimum  Maximum   Min Max
 *      0      12     12       12       0   0
 *      1      24     12       24       0   1
 *      2      10     10       24       1   1
 *      3      24     10       24       1   1
 * Given the scores for a season, determine the number of times Maria breaks her records for most and least points
 * scored during the season.
 *
 * Function Description
 *
 * Complete the breakingRecords function in the editor below.
 *
 * breakingRecords has the following parameter(s):
 *
 * int scores[n]: points scored per game
 * Returns
 *
 * int[2]: An array with the numbers of times she broke her records. Index  is for breaking most points records,
 * and index  is for breaking least points records.
 */
public class BreakingWorstAndBestRecords {


    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        List<Integer> breakingScores = Arrays.asList(0,0);
        //Get the number of times she breaks the highest score
        // get the number of the times she breaks the least point
        if (scores == null || scores.isEmpty())
            return breakingScores;

        int highestScore = scores.get(0);
        int worstScore = scores.get(0);

        for (int i = 1; i < scores.size(); i++) {
            int currentScore = scores.get(i);
            if (currentScore > highestScore) {
                breakingScores.set(0, breakingScores.get(0) + 1);
                highestScore = currentScore;
            }

            if (currentScore < worstScore) {
                breakingScores.set(1, breakingScores.get(1) + 1);
                worstScore = currentScore;
            }
        }
        return breakingScores;
    }

    public static void main(String[] args) {
        System.out.println(breakingRecords(List.of(3,4,21,36,10,28,35,5,24,42)));
    }
}
