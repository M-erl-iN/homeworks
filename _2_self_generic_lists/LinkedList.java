package Homeworks._2_self_generic_lists;

public class LinkedList<T> implements List<T> {
    private static class Elem<T> {
        private T value;
        private Elem<T> next;
        public Elem(T value, Elem<T> next) {
             this.value = value;
             this.next = next;
        }
        public T getValue() { return value; }
        public void setValue(T value) { this.value = value; }
        public Elem<T> getNext() { return next; }
        public void setNext(Elem<T> next) { this.next = next; }
    }
    private Elem<T> head;
    private int size = 0;

    public LinkedList() {}

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value) {
        head = new Elem<T>(value, head);
        size++;
    }

    @Override
    public void add(int index, T value) {
        Elem<T> prev = getElem(index);
        Elem<T> next = getElem(index - 1);
        Elem<T> elem = new Elem<T>(value, next);
        prev.setNext(elem);
        size++;
    }

    @Override
    public T get(int index) {
        if (size - index - 1 < 0) {
            throw new IndexOutOfBoundsException("List index out of range");
        }
        Elem<T> temp = head;
        for (int i = 0; i < size - index - 1; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    private Elem<T> getElem(int index) {
        if (size - index - 1 < 0) {
            return null;
        }
        Elem<T> temp = head;
        for (int i = 0; i < size - index - 1; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void set(int index, T value) {
        getElem(index).setValue(value);
    }

    @Override
    public int indexOf(T value) throws Exception {
        Elem<T> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.getValue() == value) {
                return i;
            }
            temp = temp.getNext();
        }
        throw new Exception("Element not in list");
    }

    @Override
    public void remove(int index) {
        if (index == size - 1) {
            head = head.getNext();
            size--;
            return;
        }
        Elem<T> temp = getElem(index + 1);
        temp.setNext(getElem(index - 1));
        size--;
    }

    @Override
    public void clear() {head = null;}
}