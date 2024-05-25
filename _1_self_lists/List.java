package Homeworks._1_self_lists;

public interface List {
    int size();
    void add(int elem);
    void add(int index, int elem);
    int get(int index);
    boolean isEmpty();
    void set(int index, int elem);
    int indexOf(int elem) throws Exception;
    void remove(int index);
    void clear();
}