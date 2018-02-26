package yao.algs.queue;

/**
 * Created by yaoo on 1/12/18
 */
public interface Queue<E> {

    boolean enQueue(E e);

    E deQueue();

    boolean offer(E e);

    E poll();

    //返回队首
    E peek();
}
