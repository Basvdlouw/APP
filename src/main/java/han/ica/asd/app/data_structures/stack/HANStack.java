package han.ica.asd.app.data_structures.stack;

import han.ica.asd.app.data_structures.singly_linked_list.HANLinkedList;

/**
 * Custom stack implementation which uses the HANLinkedList to implement all methods.
 */
public class HANStack<E> {

    private HANLinkedList<E> linkedList;

    public HANStack() {
        linkedList = new HANLinkedList<>();
    }

    public E top() {
        return linkedList.get(0);
    }

    public E pop() {
        E element = linkedList.get(0);
        linkedList.removeFirst();
        return element;
    }

    public void push(E element) {
        linkedList.addFirst(element);
    }

    public int getSize() {
        return linkedList.getSize();
    }

    public String toString() {
        return linkedList.toString();
    }
}
