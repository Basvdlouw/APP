package han.ica.asd.app.sort;

import java.util.Arrays;

public class InsertionSort {

    /**
     * Main method to test the insertion sort implementations
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{5, 4, 3, 6, 8, 1, 6};
        System.out.println("Unsorted integer array + " + Arrays.toString(intArray));
        insertionSort(intArray);
        System.out.println("Array sorted using insertion sort " + Arrays.toString(intArray));

        Integer[] intArray2 = new Integer[]{5, 4, 3, 6, 8, 1, 6};
        System.out.println("Unsorted integer array + " + Arrays.toString(intArray2));
        insertionSortRecursive(intArray2, intArray2.length);
        System.out.println("Array sorted using recursive insertion sort " + Arrays.toString(intArray2));
    }

    /**
     * Insertion sort with recursion
     * @param arr
     * @param n
     */
    public static <T extends Comparable<T>> void insertionSortRecursive(T arr[], int n) {
        if (n <= 1)
            return;
        insertionSortRecursive(arr, n - 1);
        T last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j].compareTo(last) > 0) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    /**
     * Insertion sort without recursion
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentIndex = i;
            while (currentIndex > 0 && array[currentIndex - 1].compareTo(array[currentIndex]) > 0) {
                T temp = array[currentIndex];
                array[currentIndex] = array[currentIndex - 1];
                array[currentIndex - 1] = temp;
                currentIndex--;
            }
        }
    }
}
