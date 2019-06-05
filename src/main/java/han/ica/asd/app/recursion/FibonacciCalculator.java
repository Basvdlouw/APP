package han.ica.asd.app.recursion;

public class FibonacciCalculator {

    /**
     * Main method to test the fibonacci methods.
     *
     * @param args
     */
    public static void main(String[] args) {
        final int number = 5;
        System.out.println("Recursive fibonacci of " + number + " is " + calculateFibonacciRecursive(number));
        System.out.println("Non recursive fibonacci of " + number + " is " + calculateFibonacci(number));
    }

    /**
     * This method calculates the fibonacci of n recursively, very inefficient operation.
     *
     * @param n
     * @return the n'th number in the fibonacci sequence
     */
    public static int calculateFibonacciRecursive(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return calculateFibonacciRecursive(n - 1) + calculateFibonacciRecursive(n - 2);
    }

    /**
     * This method calculates the fibonacci of n non-recursively.
     *
     * @param n
     * @return the n'th number in the fibonacci sequence.
     */
    public static int calculateFibonacci(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        int prev = 0, next = 1, fib = 0;
        for (int i = 1; i < n; i++) {
            fib = prev + next;
            prev = next;
            next = fib;
        }
        return fib;
    }
}
