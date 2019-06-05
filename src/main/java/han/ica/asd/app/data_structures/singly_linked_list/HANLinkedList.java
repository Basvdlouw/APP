package han.ica.asd.app.data_structures.singly_linked_list;

//TODO: Implement methods as described in document

public class HANLinkedList<T> {


    public static void main(String[] args) {
        HANLinkedList<String> list = new HANLinkedList<>();
        list.insert(new LinkedListNode<>("Manish"));
        list.insert(new LinkedListNode<>("Pandit"));
        list.insert(new LinkedListNode<>("Tanvi"));
        list.insert(new LinkedListNode<>("Monika"));
        list.print();
        list.remove();
        System.out.println("After removing the head..");
        list.print();
    }

    private LinkedListNode<T> header = null;

    /**
     * Insert at the front of the list
     *
     * @param node
     */
    public void insert(LinkedListNode<T> node) {
        node.setNext(header);
        header = node;
    }

    /**
     * Remove from the front of the list
     *
     * @param node
     */
    public void remove() {
        if (header.getNext() != null)
            header = header.getNext();
        else header = null;
    }

    /**
     * Recursively traverse this list and print the node value
     *
     * @param node
     */
    private void printList(LinkedListNode<T> node) {
        System.out.println("Node is " + node.getValue());
        if (node.getNext() != null) printList(node.getNext());
    }

    public void print() {
        printList(header);
    }
}
