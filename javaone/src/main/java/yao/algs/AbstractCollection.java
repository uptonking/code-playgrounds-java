package yao.algs;

/**
 * Created by yaoo on 1/10/18
 */
public abstract class AbstractCollection<E> implements Collection<E> {
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean update(E e) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
}
