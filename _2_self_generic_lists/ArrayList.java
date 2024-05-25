package Homeworks._2_self_generic_lists;

public class ArrayList<T> implements List<T> {
    private final int DEFAULT_CAPACITY = 8;
    private int capacity = DEFAULT_CAPACITY;
    private T[] arr = (T[]) new Object[DEFAULT_CAPACITY];
    private int size = 0;

    public ArrayList() {}

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T elem) {
        if(size == arr.length-1) {
            increase();
        }
        arr[size] = elem;
        size++;
    }

    @Override
    public void add(int index, T elem) {
        if(size == arr.length-1) increase();
        T[] temp = (T[]) new Object[capacity];
        if (index >= 0) System.arraycopy(arr, 0, temp, 0, index);
        temp[index] = elem;
        if (size - index >= 0) System.arraycopy(arr, index, temp, index + 1, size - index);
        arr = temp;
        size++;
    }

    @Override
    public T get(int index) {
        return arr[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void set(int index, T elem) {
        arr[index] = elem;
    }

    @Override
    public int indexOf(T elem) throws Exception {
        for (int i = 0; i < size; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        throw new Exception("element not found");
    }

    @Override
    public void remove(int index) {
        T[] temp = (T[]) new Object[capacity];
        if (index >= 0) System.arraycopy(arr, 0, temp, 0, index);
        if (size - (index + 1) >= 0) System.arraycopy(arr, index + 1, temp, index + 1 - 1, size - (index + 1));
        arr = temp;
        size--;
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    private void increase() {
        T[] temp = (T[]) new Object[capacity * 2];
        System.arraycopy(arr, 0, temp, 0, size);
        arr = temp;
    }
}