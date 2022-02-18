package challenges.hackerrank;

/**
 * You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).
 *
 * The first kangaroo starts at location  and moves at a rate of  meters per jump.
 * The second kangaroo starts at location  and moves at a rate of  meters per jump.
 * You have to figure out a way to get both kangaroos at the same location at the same time as part of the show. If it is possible, return YES, otherwise return NO.
 *
 * Example
 * x1 = 2
 * v1 = 1
 * x2 = 1
 * v2 = 2
 *
 * After one jump, they are both at x = 3,(x1 + v1 = 2 + 1, x2 + v2 = 1 + 2), so the answer is YES.
 *
 * test cases
 * kangaroo(6644,5868,8349,3477) -> NO
 * kangaroo(24,6,47,3)
 * 43 2 70 2
 *
 */
public class NumberLineJumps {

    public static void main(String[] args) {
        System.out.println(kangaroo(43,2,70,2));
    }

    /**
     * Based on the distance equation on physics.
     * @param x1
     * @param v1
     * @param x2
     * @param v2
     * @return
     */
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        int time;
        int rest;
        String sameLocation;
        try {
            time = (x2 - x1) / (v1 - v2);
            rest = (x2 - x1) % (v1 - v2);
            sameLocation = time > 0 && rest == 0 ? "YES" : "NO";
        } catch (ArithmeticException ex) {
            sameLocation = "NO";
        }

        return sameLocation;
    }

    public static String kangaroo2(int x1, int v1, int x2, int v2) {
        int specificPointX1 = x1 + v1;
        int specificPointX2 = x2 + v2;
        String sameLocation = "";
        if ( v1 <= v2 ) {
            sameLocation = "NO";
        } else {
            while (specificPointX1 < specificPointX2) {
                specificPointX1 += v1;
                specificPointX2 += v2;
            }
            sameLocation = specificPointX1 == specificPointX2 ? "YES" : "NO";
        }

        return sameLocation;
    }
}
