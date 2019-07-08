package han.ica.asd.app.recursion.calculators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {

    private final int NUMBER = 5;

    @Test
    void calculateSum() {
        assertEquals(15, SumCalculator.calculateSum(NUMBER));
    }

    @Test
    void calculateSumRecursive() {
        assertEquals(15, SumCalculator.calculateSumRecursive(NUMBER));
    }
}