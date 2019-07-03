package han.ica.asd.app.data_structures.singly_linked_list;

//TODO: Implement methods as described in document

public class HANLinkedList<T> {

    private LinkedListNode<T> header = null;

    public void addFirst(T value) {
        if (header == null)
            header = new LinkedListNode<>(value);
        else {
            LinkedListNode<T> second = header;
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

    public void insert(int index, T value) throws IndexOutOfBoundsException {
        if (index == 0) {
            addFirst(value);
            return;
        }
        LinkedListNode<T> previousNode = getNode(index - 1);
        if (previousNode.getNext() == null) {
            previousNode.setNext(new LinkedListNode<>(value));
        } else {
            LinkedListNode<T> currentIndexNode = previousNode.getNext();
            previousNode.setNext(new LinkedListNode<>(value));
            previousNode.getNext().setNext(currentIndexNode);
        }
    }

    public void delete(int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            removeFirst();
            return;
        }

        LinkedListNode<T> previousNode = getNode(index - 1);
        if (previousNode.getNext() == null)
            throw new IndexOutOfBoundsException();
        else {
            LinkedListNode<T> newNodeAfterRemoval = previousNode.getNext().getNext();
            previousNode.setNext(newNodeAfterRemoval);
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        return getNode(index).getValue();
    }

    private LinkedListNode<T> getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0)
            throw new IndexOutOfBoundsException();
        LinkedListNode<T> node = header;
        if (index == 0)
            return node;
        int i = 0;
        while (i < index) {
            if (node.getNext() == null)
                throw new IndexOutOfBoundsException();
            node = node.getNext();
            i++;
        }
        return node;
    }

    public int getSize() {
        if(header == null)
            return 0;
        int size = 1;
        LinkedListNode<T> currentNode = header;
        while(currentNode.getNext() != null) {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    private void printList(LinkedListNode<T> node) {
        System.out.println("Node is " + node.getValue());
        if (node.getNext() != null)
            printList(node.getNext());
    }

    public void print() {
        printList(header);
    }
}
