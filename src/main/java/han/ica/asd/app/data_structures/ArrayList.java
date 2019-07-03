package han.ica.asd.app.data_structures;

import java.util.Iterator;

public class ArrayList<E> implements Iterable<E> {

   private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private E[] items;

    public ArrayList() {
        clear();
    }

    public void clear() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size) return;
        E[] old = items;
        items = (E[]) new Object[newCapacity];
        if (size() >= 0) System.arraycopy(old, 0, items, 0, size());
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public E get(int index) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        return items[index];
    }

    public E set(int index, E newVal) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        E old = items[index];
        items[index] = newVal;
        return old;
    }

    /**
     * add the element to the end of list
     *
     * @param element is the element you want to add
     * @return true if add successfully, otherwise return false
     */
    public boolean add(E element) {
        add(size(), element);
        return true;
    }

    /**
     * add the element to the specific position
     *
     * @param index   is the position you want to insert the element
     * @param element is the element you want to insert
     */
    public void add(int index, E element) {
        if (items.length == size()) ensureCapacity(size() * 2 + 1);
        if (size - index >= 0) System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = element;
        size++;
    }

    public E remove(int index) {
        E removeItem = items[index];
        for (int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return removeItem;
    }

    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    // inner class
    private class ArrayListIterator implements java.util.Iterator<E> {

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public E next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return items[current++];
        }

        public void remove() {
            ArrayList.this.remove(--current); // reference the outer class
        }
    }
}
