package han.ica.asd.app.recursion.calculators;

public class SumCalculator {

    /**
     * Calculates the "sum" of a given number using recursion, for example input 3 would result in 3 + 2 + 1 = 6.
     *
     * @param number
     * @return sum of number
     */
    public static int calculateSumRecursive(int number) {
        return number - 1 <= 0 ? number : number + calculateSumRecursive(number - 1);
    }

    /**
     * Calculates the "sum" of a given number, for exmaple input 3 would result in 3 + 2 + 1 = 6.
     *
     * @param number
     * @return
     */
    public static int calculateSum(int number) {
        final int numberLength = number;
        int result = 0;
        for (int i = 0; i < numberLength; i++) {
            result += number;
            number--;
        }
        return result;
    }
}
