package challenges.interviews;

public class ComunMultiplo {
    public static void main(String[] args) {
        System.out.println(mcm(3,6));
    }

    public static int mcm(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int result = (a / mcd(num1, num2)) * b;

        return result;
    }

    public static int mcd(int num1, int num2) {
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int result = 0;
        do {
            result = b;
            b = a % b;
            a = result;
        } while (b != 0);

        return result;
    }
}
