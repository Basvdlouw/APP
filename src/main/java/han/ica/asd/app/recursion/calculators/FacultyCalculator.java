package han.ica.asd.app.recursion.calculators;

class FacultyCalculator {

    /**
     * This method calculates the factorial of the given number and returns it
     *
     * @param number of the factorial to be returned
     * @return factorial of number
     */
    public static int calculateFactorial(int number) {
        final int numberLength = number;
        int result = 1;
        for (int i = 0; i < numberLength; i++) {
            result *= number;
            number--;
        }
        return result;
    }

    /**
     * This method calculates the factorial of the given number and returns it using recursive behaviour
     *
     * @param number of the factorial to be returned
     * @return factorial of number
     */
    public static int calculateFactorialRecursive(int number) {
        return number - 1 <= 0 ? number : number * calculateFactorialRecursive(number - 1);
    }
}
