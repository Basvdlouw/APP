package han.ica.asd.app.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{5, 4, 3, 6, 8, 1, 6};
        System.out.println("Unsorted integer array " + Arrays.toString(intArray));
        sort(intArray);
        System.out.println("Array sorted using quick sort " + Arrays.toString(intArray));
    }

    /**
     * Wrapper method which calls quickSort
     * @param array array to be sorted
     * @param <T> type of array, should implement the comparable interface
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length-1);
    }

    /**
     * Generic quicksort implementation
     * @param arr array to be sorted
     * @param a
     * @param b
     * @param <T> type which should implement the comparable interface
     */
    private static <T extends Comparable<T>> void quickSort(T[] arr, int a, int b) {
        if (a < b) {
            int i = a, j = b;
            T x = arr[(i + j) / 2];
            do {
                while (arr[i].compareTo(x) < 0) i++;
                while (x.compareTo(arr[j]) < 0) j--;

                if ( i <= j) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            quickSort(arr, a, j);
            quickSort(arr, i, b);
        }
    }
}
