package han.ica.asd.app.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{5, 4, 3, 6, 8, 1, 6};
        System.out.println("Unsorted integer array + " + Arrays.toString(intArray));
        mergeSort(intArray, 0, intArray.length);
        System.out.println("Array sorted using merge sort " + Arrays.toString(intArray));
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array, int start, int end)
    {
        // base case
        if (start < end)
        {
            // find the middle point
            int middle = (start + end) / 2;

            mergeSort(array, start, middle); // sort first half
            mergeSort(array, middle + 1, end);  // sort second half

            // merge the sorted halves
            merge(array, start, middle, end);
        }
    }

    // merges two subarrays of array[].
    private static <T extends Comparable<T>> void merge(T[] array, int start, int middle, int end)
    {
        T[] leftArray  = (T[]) new Comparable[middle - start + 1];
        T[] rightArray = (T[]) new Comparable[end - middle];
        if (leftArray.length >= 0)
            System.arraycopy(array, start, leftArray, 0, leftArray.length);
        for (int i = 0; i < rightArray.length; ++i)
            rightArray[i] = array[middle + 1 + i];
        int leftIndex = 0, rightIndex = 0;
        int currentIndex = start;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length)
        {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0)
            {
                array[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            }
            else
            {
                array[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }
        while (leftIndex < leftArray.length)
            array[currentIndex++] = leftArray[leftIndex++];
        while (rightIndex < rightArray.length)
            array[currentIndex++] = rightArray[rightIndex++];
    }
}

