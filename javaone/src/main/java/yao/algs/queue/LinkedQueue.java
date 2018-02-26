package yao.algs.queue;

import yao.algs.list.TwoWayList;

/**
 * 双向链表实现的队列
 * Created by yaoo on 1/12/18
 */
@SuppressWarnings("unused")
public class LinkedQueue<E> extends TwoWayList<E> implements Queue<E> {

    public LinkedQueue() {
    }

    @Override
    public boolean enQueue(E e) {
        return addLast(e);
    }

    @Override
    public E deQueue() {
        return removeFirst();
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
