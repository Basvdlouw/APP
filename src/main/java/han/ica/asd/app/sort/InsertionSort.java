package han.ica.asd.app.sort;

public class InsertionSort {

    /**
     * Wrapper method which calls insertionSortRecursive.
     *
     * @param arr   array to be sorted, elements inside the array are required to implement the comparable interface.
     */
    public static <T extends Comparable<T>> void insertionSortRecursive(T[] arr) {
        insertionSortRecursive(arr, arr.length);
    }

    /**
     * Insertion sort with recursion
     *
     * @param arr
     * @param n
     */
    private static <T extends Comparable<T>> void insertionSortRecursive(T[] arr, int n) {
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
     *
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
