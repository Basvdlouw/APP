package han.ica.asd.app.data_structures.array_list;

import java.util.Arrays;
import java.util.Objects;


public class ArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int amountOfElementsInArrayList;

    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        amountOfElementsInArrayList = 0;
    }

    /**
     * adds an element to the end of the list
     */
    public void add(E e) {
        ensureCapacity();
        elementData[amountOfElementsInArrayList++] = e;
    }

    /**
     * get the value by index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndexOutOfBounds(index);
        return (E) elementData[index];
    }

    /**
     * returns the size of the list
     */
    public int size() {
        return amountOfElementsInArrayList;
    }

    /**
     * removes element from the list and shrinks the list back
     */
    public void remove(int index) {
        checkIndexOutOfBounds(index);
        Object[] arr = new Object[amountOfElementsInArrayList-index+1];
        if (amountOfElementsInArrayList - index + 1 >= 0)
            System.arraycopy(elementData, index + 1, arr, 0, amountOfElementsInArrayList - index + 1);
        if (arr.length >= 0) System.arraycopy(arr, 0, elementData, index, arr.length);
        amountOfElementsInArrayList--;
    }

    /**
     * Sets a value at a certain index
     * @param index to set the value at
     * @param value value that has to be added
     */
    public void set(int index, E value) {
        checkIndexOutOfBounds(index);
        elementData[index] = value;
    }

    /**
     * return true if list is empty
     */
    public boolean isEmpty() {
        return amountOfElementsInArrayList == 0;
    }

    /**
     * Method checks for an IndexOutOfBoundsException
     * @param index decides whether to throw the exception or not
     */
    private void checkIndexOutOfBounds(int index) {
        if (index < 0 || index >= amountOfElementsInArrayList)
            throw new IndexOutOfBoundsException();
    }

    /**
     * Method increases capacity of list by making it double whenever the list is full.
     */
    private void ensureCapacity() {
        if (elementData.length == amountOfElementsInArrayList)
          elementData = Arrays.copyOf(elementData, elementData.length * 2);
    }

    /**
     * Method displays all the elements in list. For example: [10, 3, 6]
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        Arrays.stream(elementData).filter(Objects::nonNull).forEach(obj -> {
            sb.append(obj);
            sb.append(", ");
        });
        if (!isEmpty())
            sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
