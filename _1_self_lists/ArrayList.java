package Homeworks._1_self_lists;

public class ArrayList implements List {
    private final int DEFAULT_CAPACITY = 8;
    private int capacity;
    private int[] arr;
    private int size;

    public ArrayList() {
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
        arr = new int[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int elem) {
        if(size == arr.length-1) {
            increase();
        }
        arr[size] = elem;
        size++;
    }

    @Override
    public void add(int index, int elem) {
        if(size == arr.length-1) {
            increase();
        }
        int[] temp = new int[capacity];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        temp[index] = elem;
        for (int i = index; i < size; i++) {
            temp[i + 1] = arr[i];
        }
        arr = temp;
        size++;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void set(int index, int elem) {
        arr[index] = elem;
    }

    @Override
    public int indexOf(int elem) throws Exception {
        for (int i = 0; i < size; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        throw new Exception("Element not in list");
    }

    @Override
    public void remove(int index) {
        int[] temp = new int[capacity];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        for (int i = index + 1; i < size; i++) {
            temp[i - 1] = arr[i];
        }
        arr = temp;
        size--;
    }

    @Override
    public void clear() {
        arr = new int[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    private void increase() {
        int[] temp = new int[capacity * 2];
        System.arraycopy(arr, 0, temp, 0, size);
        arr = temp;
    }
}