package han.ica.asd.app.data_structures.array_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

class ArrayListTest {

    private ArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void add() {
        list.add(10);
        assertEquals(10, list.get(0));
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(12);
        assertEquals(12, list.get(10));
    }

    @Test
    void get() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add(10);
        list.add(20);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void size() {
        assertEquals(0, list.size());
        list.add(10);
        list.add(20);
        assertEquals(2, list.size());
    }

    @Test
    void remove() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(1);
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));

    }

    @Test
    void set() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 10));
        list.add(10);
        list.add(20);
        list.add(30);
        list.set(1, 50);
        assertEquals(50, list.get(1));
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void toStringTest() {
        assertEquals("[]", list.toString());
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals("[10, 20, 30]", list.toString());
    }
}