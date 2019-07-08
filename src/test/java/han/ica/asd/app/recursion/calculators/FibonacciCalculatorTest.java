package han.ica.asd.app.recursion.calculators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciCalculatorTest {

    private final int ZERO = 0;
    private final int ONE = 1;
    private final int NUMBER = 10;

    @Test
    void constructor() {
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        assertEquals(fibonacciCalculator.getClass(), FibonacciCalculator.class);
    }

    @Test
    void calculateFibonacci() {
        assertEquals(0, FibonacciCalculator.calculateFibonacci(ZERO));
        assertEquals(1, FibonacciCalculator.calculateFibonacci(ONE));
        assertEquals(55, FibonacciCalculator.calculateFibonacci(NUMBER));
    }

    @Test
    void calculateFibonacciRecursive() {
        assertEquals(0, FibonacciCalculator.calculateFibonacciRecursive(ZERO));
        assertEquals(1, FibonacciCalculator.calculateFibonacciRecursive(ONE));
        assertEquals(55, FibonacciCalculator.calculateFibonacciRecursive(NUMBER));
    }
}