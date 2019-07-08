package han.ica.asd.app.data_structures.Quack;

import han.ica.asd.app.data_structures.singly_linked_list.HANLinkedList;

/**
 * This is a custom data structure called "Quack" which implements all regular functions of both a stack and a queue.
 */
public class Quack<E> {

    private HANLinkedList<E> linkedList;

    public Quack() {
        linkedList = new HANLinkedList<>();
    }

    /**
     * shows the first element in the list without removing it
     * @return first element in the list
     */
    public E top() {
        return linkedList.get(0);
    }

    /**
     * returns the first element in the list/quack, also removes it.
     * @return first element in the list
     */
    public E pop() {
        E element = linkedList.get(0);
        linkedList.removeFirst();
        return element;
    }

    /**
     * adds an element to the start of the list/quack
     * @param value
     */
    public void push(E value) {
        linkedList.addFirst(value);
    }

    /**
     * returns the size of the list/quack
     * @return
     */
    public int size() {
        return linkedList.size();
    }

    /**
     * Adds an element to the end of the list
     * @param value to add
     */
    public void enqueue(E value) {
        linkedList.add(value);
    }

    /**
     * Does the same as pop()
     * @return element at the start of the list, also removes it
     */
    public E dequeue() {
        return pop();
    }

    /**
     * Does the same as top()
     * @return first element in the queue/quack without removing it
     */
    public E peek() {
        return top();
    }
}
