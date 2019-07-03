package han.ica.asd.app.data_structures.singly_linked_list;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HANLinkedListTest {

    private HANLinkedList<Integer> singlyLinkedList;

    @BeforeEach
    void setup() {
        singlyLinkedList = new HANLinkedList<>();
    }

    @Test
    void addFirst() {
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(5);

        assertEquals(5, singlyLinkedList.get(0));
        assertEquals(3, singlyLinkedList.get(1));
    }

    @Test
    void removeFirst() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.removeFirst());

        singlyLinkedList.insert(0,3);
        singlyLinkedList.insert(1,5);

        singlyLinkedList.removeFirst();

        assertEquals(5, singlyLinkedList.get(0));
    }

    @Test
    void insert() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.insert(-1, 10));

        singlyLinkedList.insert(0, 10);
        singlyLinkedList.insert(1, 30);
        singlyLinkedList.insert(2, 20);
        singlyLinkedList.insert(1, 40);

        assertEquals(10, singlyLinkedList.get(0));
        assertEquals(40, singlyLinkedList.get(1));
        assertEquals(30, singlyLinkedList.get(2));
        assertEquals(20, singlyLinkedList.get(3));
    }

    @Test
    void delete() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.delete(0));

        singlyLinkedList.insert(0, 10);
        singlyLinkedList.insert(1, 20);

        singlyLinkedList.delete(0);

        assertEquals(20, singlyLinkedList.get(0));
    }

    @Test
    void get() {
        singlyLinkedList.insert(0, 10);
        singlyLinkedList.insert(1, 20);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singlyLinkedList.get(2));
        assertEquals(20, singlyLinkedList.get(1));
    }

    @Test
    void getSize() {
        assertEquals(0, singlyLinkedList.getSize());
        singlyLinkedList.insert(0, 10);
        singlyLinkedList.insert(1, 20);
        singlyLinkedList.insert(2, 30);
        assertEquals(3, singlyLinkedList.getSize());
    }

    @Test
    void print() {
    }
}