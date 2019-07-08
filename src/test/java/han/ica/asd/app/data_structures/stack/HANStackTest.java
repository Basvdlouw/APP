package han.ica.asd.app.data_structures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HANStackTest {
    private HANStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new HANStack<>();
    }

    @Test
    void top() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()-> stack.top());

        stack.push(1);
        stack.push(3);
        stack.push(5);

        assertEquals(5, stack.top());
        assertEquals(3, stack.getSize());
    }

    @Test
    void pop() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()-> stack.pop());

        stack.push(1);
        stack.push(3);
        stack.push(5);

        assertEquals(5, stack.pop());
        assertEquals(2, stack.getSize());
    }

    @Test
    void push() {
        stack.push(1);
        assertEquals(1, stack.top());
        stack.push(3);
        assertEquals(3, stack.top());
        assertEquals(2, stack.getSize());
    }

    @Test
    void getSize() {
        assertEquals(0, stack.getSize());
        stack.push(1);
        stack.push(3);
        stack.push(5);
        assertEquals(3, stack.getSize());
    }

    @Test
    void toStringTest() {
        assertEquals("[]", stack.toString());
        stack.push( 10);
        stack.push(20);
        assertEquals("[20, 10]", stack.toString());
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}