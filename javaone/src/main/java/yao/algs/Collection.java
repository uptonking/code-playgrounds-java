package yao.algs;

/**
 * 集合通用接口
 */
public interface Collection<E> {

    boolean add(E e);

    boolean addAll(Collection<? extends E> c);

    boolean remove(Object o);

    boolean removeAll(Collection<?> c);

    void clear();

    boolean update(E e);

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean containsAll(Collection<?> c);

    <T> T[] toArray(T[] t);
}
