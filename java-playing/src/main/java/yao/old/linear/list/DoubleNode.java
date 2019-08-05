package yao.old.linear.list;

/**
 * 双向链表数据元素节点
 */
public class DoubleNode<T> {

    public T data;
    public DoubleNode<T> pre;
    public DoubleNode<T> next;


    public DoubleNode(T data, DoubleNode pre,DoubleNode next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    public DoubleNode(T data) {
        this(data, null,null);
    }
}
