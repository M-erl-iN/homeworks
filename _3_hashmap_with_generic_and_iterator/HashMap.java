package Homeworks._3_hashmap_with_generic_and_iterator;

import java.util.HashSet;
import java.util.Set;

public class HashMap<A, B> implements Map<A, B>{
    public static class Entry<A, B> implements Map.Entry<A, B> {
        private A key;
        private B value;
        public Entry(A key, B value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public A getKey() {return key;}
        @Override
        public B getValue() {return value;}
        @Override
        public void setValue(B value) {this.value = value;}
        @Override
        public int hashCode() {return key.hashCode();}
    }

    private int size = 0;
    private final int DEFAULT_CAPACITY = 16;
    private int capacity = DEFAULT_CAPACITY;
    private Entry<A, B>[] entries;

    public HashMap() {entries = new Entry[capacity];}
    static int indexFor(int h, int length) {return h & (length-1);}
    @Override
    public int size() {return size;}
    @Override
    public void put(A key, B value) {
        if (capacity <= size) {
            capacity *= 2;
            Entry<A, B>[] new_entries = new Entry[capacity];
            System.arraycopy(entries, 0, new_entries, 0, size);
            entries = new_entries;
        }
        int index = indexFor(key.hashCode(), capacity);
        entries[index] = new Entry<A, B>(key, value);
        size++;
    }
    @Override
    public B get(A key) {
        int index = indexFor(key.hashCode(), capacity);
        return entries[index].getValue();
    }
    @Override
    public boolean containsKey(A key) {
        return (//0 <= indexFor(key.hashCode(), capacity) && indexFor(key.hashCode(), capacity) < size &&
                entries[indexFor(key.hashCode(), capacity)] != null);
    }
    @Override
    public boolean containsValue(B value) {
        for (Entry<A, B> obj: entries) {
            if (obj != null) { if (obj.value == value) {return true;} }
        } return false;
    }
    @Override
    public Set<Entry<A, B>> entrySet() {
        Set<Entry<A, B>> temp = new HashSet<>(size());
        for (Entry<A, B> elem: entries) {
            if (elem != null) {temp.add(elem);}
        } return temp;
    }
    @Override
    public Set<A> keySet() {
        Set<A> temp = new HashSet<>(size());
        for (Entry<A, B> elem: entries) {
            if (elem != null) {temp.add(elem.key);}
        } return temp;
    }
    @Override
    public Set<B> values() {
        Set<B> temp = new HashSet<>(size());
        for (Entry<A, B> elem: entries) {
            if (elem != null) {temp.add(elem.value);}
        } return temp;
    }
    @Override
    public void remote(A key) {
        entries[indexFor(key.hashCode(), capacity)] = null;
    }
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    @Override
    public void clear() {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        entries = new Entry[DEFAULT_CAPACITY];
    }
}
