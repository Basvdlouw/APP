package han.ica.asd.app.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSortTest {

    private Integer[] intArray;
    private final Integer[] sortedList = new Integer[]{1, 1, 3, 4, 4, 7, 7};

    @BeforeEach
    void setUp() {
        intArray = new Integer[]{4, 7, 1, 4, 7, 1, 3};
    }

    @Test
    void constructor() {
        QuickSort quickSort = new QuickSort();
        assertEquals(quickSort.getClass(), QuickSort.class);
    }

    @Test
    void sort() {
        QuickSort.sort(intArray);
        assertArrayEquals(intArray, sortedList);
    }
}