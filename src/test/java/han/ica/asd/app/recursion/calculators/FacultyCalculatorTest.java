package han.ica.asd.app.recursion.calculators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacultyCalculatorTest {

    private final int NUMBER = 5;

    @Test 
    void constructor() {
        FacultyCalculator facultyCalculator = new FacultyCalculator();
        assertEquals(facultyCalculator.getClass(), FacultyCalculator.class);
    }

    @Test
    void calculateFactorial() {
        assertEquals(120, FacultyCalculator.calculateFactorial(NUMBER));
    }

    @Test
    void calculateFactorialRecursive() {
        assertEquals(120, FacultyCalculator.calculateFactorialRecursive(NUMBER));
    }
}