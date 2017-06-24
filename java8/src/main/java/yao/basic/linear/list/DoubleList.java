package yao.basic.linear.list;

/**
 * 双向链表
 */
public class DoubleList<T> {

    private DoubleNode<T> first;
    private DoubleNode<T> last;
    private int length;

    public DoubleList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int count = 0;

        return count;
    }

    public void traverse() {

    }

    public int search(T item) {

        return -1;
    }

    public DoubleNode<T> addNode(DoubleNode<T> item, int position) {

        return first;
    }

    public DoubleNode<T> removeNode(DoubleNode<T> item, int position) {

        return first;
    }

    public void clear() {

    }

}
