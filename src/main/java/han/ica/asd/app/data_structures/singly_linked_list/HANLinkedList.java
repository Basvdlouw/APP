package han.ica.asd.app.data_structures.singly_linked_list;

/**
 * Custom singly linked list implementation named "HANLinkedList"
 *
 * @param <E> generic type that will define the type of values that will go into the linked list
 */
public class HANLinkedList<E> {

    private LinkedListNode<E> header = null;

    public void addFirst(E value) {
        if (header == null)
            header = new LinkedListNode<>(value);
        else {
            final LinkedListNode<E> second = header;
            header = new LinkedListNode<>(value);
            header.setNext(second);
        }
    }

    public void removeFirst() throws IndexOutOfBoundsException {
        if (header == null)
            throw new IndexOutOfBoundsException();
        else
            header = header.getNext();
    }

    public void insert(int index, E value) throws IndexOutOfBoundsException {
        if (index == 0) {
            addFirst(value);
            return;
        }
        final LinkedListNode<E> previousNode = getNode(index - 1);
        if (previousNode.getNext() == null) {
            previousNode.setNext(new LinkedListNode<>(value));
        } else {
            final LinkedListNode<E> currentIndexNode = previousNode.getNext();
            previousNode.setNext(new LinkedListNode<>(value));
            previousNode.getNext().setNext(currentIndexNode);
        }
    }

    public void delete(int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            removeFirst();
            return;
        }
        final LinkedListNode<E> previousNode = getNode(index - 1);
        final LinkedListNode<E> newNodeAfterRemoval = previousNode.getNext().getNext();
        previousNode.setNext(newNodeAfterRemoval);
    }

    public E get(int index) throws IndexOutOfBoundsException {
        return getNode(index).getValue();
    }

    private LinkedListNode<E> getNode(int index) throws IndexOutOfBoundsException {
        LinkedListNode<E> node = header;
        if (index < 0 || node == null)
            throw new IndexOutOfBoundsException();
        int i = 0;
        while (i < index) {
            if (node.getNext() == null)
                throw new IndexOutOfBoundsException();
            node = node.getNext();
            i++;
        }
        return node;
    }

    @SuppressWarnings("Duplicates")
    public int getSize() {
        if (header == null)
            return 0;
        int size = 1;
        LinkedListNode<E> currentNode = header;
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
        LinkedListNode<E> currentNode = header;
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

    private class LinkedListNode<T> {
        private T value;
        private LinkedListNode<T> next;

        LinkedListNode(T value) {
            this.value = value;
        }

        void setNext(LinkedListNode<T> next) {
            this.next = next;
        }

        LinkedListNode<T> getNext() {
            return next;
        }

        T getValue() {
            return value;
        }
    }
}
