package han.ica.asd.app.recursion;

public class NumberOf1sCalculator {

    /**
     * Main method to test the calculateNumberOf1s method
     * @param args
     */
    public static void main(String[] args) {
        final int number = 2;
        System.out.println("Number of 1s in the binary representation of " + number + " is: " + calculateNumberOf1s(number));
    }

    /**
     * Problem: Write a recursive method that returns the number of 1s in the binary
     * representation of N. Use the fact that this number equals the number
     * of 1s in the representation of N/ 2, plus 1, if N is odd.
     */
    public static int calculateNumberOf1s(int n) {
        if(n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else if(n % 2 == 1)
            return calculateNumberOf1s(n/2) +1;
        else
            return calculateNumberOf1s(n/2);
    }
}
