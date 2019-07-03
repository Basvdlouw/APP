package han.ica.asd.app.data_structures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class HANStackTest {
    private Stack<Integer> stack;

    @BeforeEach
    void setup() {
        stack = new Stack<>();
    }

    @Test
    void top() {
        Assertions.assertThrows(EmptyStackException.class, ()-> stack.top());

        stack.push(1);
        stack.push(3);
        stack.push(5);

        assertEquals(5, stack.top());
        assertEquals(3, stack.getSize());
    }

    @Test
    void pop() {
        Assertions.assertThrows(EmptyStackException.class, ()-> stack.pop());

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
}