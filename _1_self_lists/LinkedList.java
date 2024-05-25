package Homeworks._1_self_lists;

public class LinkedList implements List {
    private static class Elem {
        private int value;
        private Elem next;
         public Elem(int value, Elem next) {
             this.value = value;
             this.next = next;
         }
        public int getValue() { return value; }
        public void setValue(int value) { this.value = value; }
        public Elem getNext() { return next; }
        public void setNext(Elem next) { this.next = next; }
    }
    private Elem head;
    private int size = 0;

    public LinkedList() {}

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int value) {
        head = new Elem(value, head);
        size++;
    }

    @Override
    public void add(int index, int value) {
        Elem prev = getElem(index);
        Elem next = getElem(index - 1);
        Elem elem = new Elem(value, next);
        prev.setNext(elem);
        size++;
    }

    @Override
    public int get(int index) {
        if (size - index - 1 < 0) {
            throw new IndexOutOfBoundsException("List index out of range");
        }
        Elem temp = head;
        for (int i = 0; i < size - index - 1; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    private Elem getElem(int index) {
        if (size - index - 1 < 0) {
            return null;
        }
        Elem temp = head;
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
    public void set(int index, int value) {
        getElem(index).setValue(value);
    }

    @Override
    public int indexOf(int value) throws Exception {
        Elem temp = head;
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
        Elem temp = getElem(index + 1);
        temp.setNext(getElem(index - 1));
        size--;
    }

    @Override
    public void clear() {head = null;}
}