package yao.algs.stack;

import yao.algs.AbstractCollection;
import yao.algs.Collection;

public abstract class AbstractStack<E> extends AbstractCollection<E> {

    abstract void push(E e);
    abstract E pop();
    abstract E peek();


}
