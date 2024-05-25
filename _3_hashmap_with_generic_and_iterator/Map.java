package Homeworks._3_hashmap_with_generic_and_iterator;

import java.util.Collection;
import java.util.Set;

public interface Map<A, B> {
    static interface Entry<A, B> {
        A getKey();
        B getValue();
        void setValue(B value);

        int hashCode();
    }
    int size();
    void put(A key, B value);
    B get(A key);
    boolean containsKey(A k);
    boolean containsValue(B v);
    Set<? extends Entry<A, B>> entrySet();
    boolean equals(Object obj);
    Set<A> keySet();
    Collection<B> values();
    void remote (A key);
    boolean isEmpty();
    void clear();
}
