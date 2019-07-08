package han.ica.asd.app.recursion.calculators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOf1sCalculatorTest {

    private final int ZERO = 0;
    private final int NUMBER = 10;

    @Test
    void constructor() {
        NumberOf1sCalculator numberOf1sCalculator = new NumberOf1sCalculator();
        assertEquals(numberOf1sCalculator.getClass(), NumberOf1sCalculator.class);
    }

    @Test
    void calculateNumberOf1s() {
        assertEquals(0, NumberOf1sCalculator.calculateNumberOf1s(ZERO));
        assertEquals(2, NumberOf1sCalculator.calculateNumberOf1s(NUMBER));
    }
}