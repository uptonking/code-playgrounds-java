package yao.algs.queue;

import yao.algs.array.ResizableArray;

/**
 * 动态数组实现的队列
 * Created by yaoo on 1/12/18
 */
public class ArrayQueue<E> extends ResizableArray<E> implements Queue<E> {

    public ArrayQueue() {
    }

    @Override
    public boolean enQueue(E e) {
        return add(e);
    }

    @Override
    public E deQueue() {
        return remove(0);
    }

    @Override
    public boolean offer(E e) {
        return enQueue(e);
    }

    @Override
    public E poll() {
        return deQueue();
    }

    @Override
    public E peek() {
        return get(0);
    }

}
