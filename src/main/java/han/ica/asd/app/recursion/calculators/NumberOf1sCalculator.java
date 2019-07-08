package han.ica.asd.app.recursion.calculators;

public class NumberOf1sCalculator {

    /**
     * Problem: Write a recursive method that returns the number of 1s in the binary
     * representation of N. Use the fact that this number equals the number
     * of 1s in the representation of N/ 2, plus 1, if N is odd.
     */
    public static int calculateNumberOf1s(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n % 2 == 1)
            return calculateNumberOf1s(n / 2) + 1;
        else
            return calculateNumberOf1s(n / 2);
    }
}
