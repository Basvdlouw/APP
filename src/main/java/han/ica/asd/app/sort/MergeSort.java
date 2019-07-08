package han.ica.asd.app.sort;

import java.util.Arrays;

public class MergeSort {

     /**
     * Wrapper method which calls mergeSort.
     *
     * @param a   array to be sorted, elements inside the array are required to implement the comparable interface.
     * @param <T> generic type which will be instantiated at runtime
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * Recursive mergeSort method.
     *
     * @param a   array to be sorted
     * @param i
     * @param j
     * @param <T>
     */
    private static <T extends Comparable<T>> void mergeSort(T[] a, int i, int j) {
        if (j - i < 1) return;
        int mid = (i + j) / 2;
        mergeSort(a, i, mid);
        mergeSort(a, mid + 1, j);
        merge(a, i, mid, j);
    }

    /**
     * Merge method
     * Need to allocate a new array, but Java does not allow allocating arrays of a generic type
     * As a work-around we allocate an array of type Object[] to do the type casting. This will generate the warning which is suppressed.
     *
     * @param a
     * @param p
     * @param mid
     * @param q
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] a, int p, int mid, int q) {
        Object[] tmp = new Object[q - p + 1];
        int i = p;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= q) {
            if (a[i].compareTo(a[j]) <= 0)
                tmp[k] = a[i++];
            else
                tmp[k] = a[j++];
            k++;
        }
        if (i <= mid) {
            while (i <= mid)
                tmp[k++] = a[i++];
        } else {
            while (j <= q)
                tmp[k++] = a[j++];
        }
        for (k = 0; k < tmp.length; k++) {
            a[k + p] = (T) (tmp[k]);
        }
    }
}


