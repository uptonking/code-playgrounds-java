package yao.old.linear.list;

/**
 * 单向链表数据元素节点
 */
public class SingleNode<T> {

    public T data;
    public SingleNode<T> next;


    public SingleNode(T data, SingleNode next) {
        this.data = data;
        this.next = next;
    }

    public SingleNode(T data) {
        this(data, null);
    }
}
