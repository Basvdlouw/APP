package han.ica.asd.app.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertionSortTest {

    private  Integer[] intArray;
    private final Integer[] sortedList = new Integer[]{1, 1, 3, 4, 4, 7, 7};

    @BeforeEach
    void setUp() {
        intArray = new Integer[]{4, 7, 1, 4, 7, 1, 3};
    }

    @Test
    void insertionSortRecursive() {
        InsertionSort.insertionSortRecursive(intArray);
        assertArrayEquals(intArray, sortedList);
    }

    @Test
    void insertionSort() {
        InsertionSort.insertionSort(intArray);
        assertArrayEquals(intArray, sortedList);
    }
}