package han.ica.asd.app.data_structures.linear_data_structures.quack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuackTest {

    private Quack<Integer> quack;

    @BeforeEach
    private void setUp() {
        quack = new Quack<>();
    }

    @Test
    void top() {
        assertThrows(IndexOutOfBoundsException.class, ()-> quack.top());
        quack.enqueue(1);
        quack.enqueue(2);
        assertEquals(1, quack.top());
    }

    @Test
    void pop() {
        assertThrows(IndexOutOfBoundsException.class, ()-> quack.pop());
        quack.enqueue(1);
        quack.enqueue(2);
        assertEquals(1, quack.pop());
        assertEquals(1, quack.size());
    }

    @Test
    void push() {
        quack.push(1);
        quack.push(2);
        quack.push(3);
        assertEquals(3, quack.peek());
        quack.dequeue();
        assertEquals(2, quack.peek());
    }

    @Test
    void size() {
        assertEquals(0, quack.size());
        quack.push(1);
        assertEquals(1, quack.size());
    }

    @Test
    void enqueue() {
        quack.enqueue(1);
        quack.enqueue(2);
        quack.enqueue(3);
        assertEquals(1, quack.peek());
    }

    @Test
    void dequeue() {
        quack.enqueue(1);
        quack.enqueue(2);
        quack.enqueue(3);
        quack.dequeue();
        assertEquals(2, quack.size());
        assertEquals(2, quack.peek());
    }

    @Test
    void peek() {
        assertThrows(IndexOutOfBoundsException.class, ()-> quack.peek());
        quack.enqueue(1);
        quack.enqueue(2);
        assertEquals(1, quack.peek());
    }
}