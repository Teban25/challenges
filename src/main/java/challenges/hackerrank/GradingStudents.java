package challenges.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * HackerLand University has the following grading policy:
 *
 * Every student receives a  grade in the inclusive range from 0 to 100 .
 * Any grade less than 40 is a failing grade.
 * Sam is a professor at the university and likes to round each student's grades according to these rules:
 *
 * If the difference between the grade and the next multiple of five(5) is less than 3, round grade up to the next multiple
 * of five(5).
 * If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
 * Examples
 *
 * grade = 84, round to 85 (85 - 84 is less than 3)
 * grade = 29 do not round (result is less than 40)
 * grade = 57 do not round (60 - 57 is 3 or higher)
 * Given the initial value of grade for each of Sam's n students, write code to automate the rounding process.
 *
 * Function Description
 *
 * Complete the function gradingStudents in the editor below.
 *
 * gradingStudents has the following parameter(s):
 *
 * int grades[n]: the grades before rounding
 * Returns.
 *
 * int[n]: the grades after rounding as appropriate
 * Input Format.
 *
 * The first line contains a single integer, n, the number of students.
 * Each line i of the n subsequent lines contains a single integer, grades[i].
 *
 * Constraints
 *  1 <= n <= 60
 *  0 <= grades[i] <= 100
 * Sample Input 0
 * 4
 * 73
 * 67
 * 38
 * 33
 *
 * Sample Output 0
 *
 * 75
 * 67
 * 40
 * 33
 */
public class GradingStudents {

    public static void main(String[] args) {
        System.out.println(gradingStudents(List.of(73,67,38,33)));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> finalGrades = new ArrayList<>();
        if (grades != null && !grades.isEmpty()) {
            for (Integer grade : grades) {
                if(grade >= 38) {
                    Integer nextMultipleOfFive = nextMultipleOfFive(grade);
                    Integer differenceFinalGrade = (nextMultipleOfFive - grade);
                    if(differenceFinalGrade < 3 && differenceFinalGrade <= 100) {
                        finalGrades.add(nextMultipleOfFive);
                    } else {
                        finalGrades.add(grade);
                    }

                } else {
                    finalGrades.add(grade);
                }
            }
        }
        return finalGrades;
    }

    private static Integer nextMultipleOfFive(final Integer base) {
        Integer nextMultipleOfFive = 0;
        if (base >= 0 && base <= 100) {
            nextMultipleOfFive = base + (5 - (base % 5));
        }
        return nextMultipleOfFive;
    }
}
