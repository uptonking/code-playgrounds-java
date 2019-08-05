package yao.algs.heap;

/**
 * 二叉堆接口
 * Created by yaoo on 1/13/18
 */
public interface Heap<E> {

    /**
     * 添加新元素到堆
     *
     * @param e 元素
     */
    void add(E e);

    /**
     * 删除堆顶
     */
    E remove();

    /**
     * 堆序化
     */
//    void heapify();

}
