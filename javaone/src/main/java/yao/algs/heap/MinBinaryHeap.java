package yao.algs.heap;


import java.util.Arrays;

/**
 * 最小堆二叉堆
 * Created by yaoo on 1/13/18
 */
@SuppressWarnings("unused")
public class MinBinaryHeap<E extends Comparable<? super E>> implements Heap<E> {

    private int size;
    private static final int DEFAULT_SIZE = 16;
    private E[] array;

    public MinBinaryHeap() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public MinBinaryHeap(int capacity) {
        size = 0;
        array = (E[]) new Comparable[capacity + 1];
    }

    @SuppressWarnings("unchecked")
    public MinBinaryHeap(E[] items) {
        if (items == null || items.length == 0) {
            throw new RuntimeException("建堆的元素不能为空");
        }
//        size = items.length;
        array = (E[]) new Comparable[items.length + 4];

//        System.arraycopy(items, 0, array, 0, size);
        buildHeap(items);
    }

    private void buildHeap(E[] items) {
        for (int i = 0, len = items.length; i < len; i++) {
            add(items[i]);
        }

    }

    /**
     * 像堆中插入元素
     * 向上渗透
     *
     * @param e 元素
     */
    @Override
    public void add(E e) {

        if (size == array.length) {
            grow();
        }

        array[size++] = e;
        percolateUp(size - 1);
    }

    /**
     * 移除堆的根元素
     * <p>
     * 向下渗透
     */
    @Override
    public E remove() {
        if (size == 0) {
            throw new RuntimeException("堆为空，不能移除元素");
        }

        array[0] = array[--size];
        percolateDown(0);

        return null;
    }

    /**
     * 向上渗透
     *
     * @param cur 被上调节点的起始位置，一般为数组末尾元素索引，边界条件index>0
     */
    private void percolateUp(int cur) {

        E ele = array[cur];

        while (cur > 0 && ele.compareTo(array[getParent(cur)]) < 0) {
            array[cur] = array[getParent(cur)];
            cur = getParent(cur);
        }
        array[cur] = ele;
    }

    /**
     * 向下渗透
     *
     * @param cur 被下调节点的起始位置，一般为0，边界条件右孩子<size
     */
    private void percolateDown(int cur) {

        E ele = array[cur];

        int child = getRight(cur);

        while (child < size) {

            ///两孩子中取小者
            if (array[child - 1].compareTo(array[child]) < 0) {
                child--;
            }
            if (ele.compareTo(array[child]) > 0) {
                array[cur] = array[child];
                cur = child;
                child = getRight(child);
            }

            array[cur] = ele;

        }

    }


    private int getParent(int i) {
//        return (i-1)>>>2;
        return (i - 1) / 2;
    }

    private int getLeft(int i) {
//        return (i<<2)+1;
        return 2 * i + 1;
    }

    private int getRight(int i) {
//        return (i+1)<<2;
        return 2 * i + 2;
    }

    private void grow() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
