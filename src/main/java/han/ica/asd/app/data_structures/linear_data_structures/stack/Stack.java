package han.ica.asd.app.data_structures.linear_data_structures.stack;

import java.util.EmptyStackException;

/**
 * Custom Stack implementation
 *
 * @param <E> Generic type which will define the type of items that will go into the stack
 */
public class Stack<E> {

    private StackNode<E> header = null;

    public E top() throws EmptyStackException {
        if (header == null) throw new EmptyStackException();
        return header.getValue();
    }

    public E pop() throws EmptyStackException {
        if (header == null) throw new EmptyStackException();
        final StackNode<E> prevHeader = header;
        header = prevHeader.getNext();
        return prevHeader.getValue();
    }

    public void push(E element) {
        if (header == null) {
            header = new StackNode<>(element);
            return;
        }
        final StackNode<E> prevHeader = header;
        header = new StackNode<>(element);
        header.setNext(prevHeader);
    }

    @SuppressWarnings("Duplicates")
    public int getSize() {
        if (header == null)
            return 0;
        int size = 1;
        StackNode<E> currentNode = header;
        while (currentNode.getNext() != null) {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    @SuppressWarnings("Duplicates")
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        StackNode<E> currentNode = header;
        boolean listEmpty = true;
        while (currentNode != null) {
            listEmpty = false;
            sb.append(currentNode.getValue());
            sb.append(", ");
            currentNode = currentNode.getNext();
        }
        if (!listEmpty)
            sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    private class StackNode<T> {
        private T value;
        private StackNode<T> next;

        StackNode(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        StackNode<T> getNext() {
            return next;
        }

        void setNext(StackNode<T> next) {
            this.next = next;
        }
    }
}
