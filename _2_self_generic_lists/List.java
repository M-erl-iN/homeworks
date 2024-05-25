package Homeworks._2_self_generic_lists;

public interface List<T> {
    int size();
    void add(T elem);
    void add(int index, T elem);

    T get(int index);
    boolean isEmpty();
    void set(int index, T elem);
    int indexOf(T elem) throws Exception;
    void remove(int index);
    void clear();
}