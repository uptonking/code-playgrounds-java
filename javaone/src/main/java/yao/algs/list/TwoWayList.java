package yao.algs.list;

import yao.algs.AbstractCollection;

import java.lang.reflect.Array;

/**
 * 双向链表
 * <p>
 * 类似于LinkedList
 * <p>
 * 优点：删除操作方便
 * 缺点：插入删除操作复杂度增大，空间开销增大
 * Created by yaoo on 1/11/18
 */
@SuppressWarnings("unused")
public class TwoWayList<E> extends AbstractCollection<E> {

    private int size;

    private Node<E> head;
    private Node<E> tail;

    public TwoWayList() {
    }

    public TwoWayList(E e) {
        Node<E> newNode = new Node<>(e);
        this.head = newNode;
        this.tail = newNode;
        size++;
    }

    public TwoWayList(E[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("数组不能为空");
        Node<E> newNode = new Node<>(arr[0]);
        this.head = newNode;
        this.tail = newNode;
        for (int i = 1; i < arr.length; i++) {
            this.addLast(arr[i]);
        }

    }

    /**
     * 获取指定位置的元素
     *
     * @param index 位置，从0开始
     * @return 元素
     */
    public E get(int index) {
        checkRange(index);

        Node<E> curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.data;
    }

    public E set(int index, E ele) {
        checkRange(index);

        Node<E> newNode = new Node<>(ele);
        Node<E> curNode = head;

        if (index == 0) {
            newNode.next = head.next;
            newNode.prev = null;
            head = newNode;
            return curNode.data;
        }

        if (index == size - 1) {
            curNode = tail;
            tail.prev.next = null;
            tail = tail.prev;
            return curNode.data;
        }

        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        newNode.next = curNode.next;
        newNode.prev = curNode.prev;
        curNode.next.prev = newNode;
        curNode.prev.next = newNode;
        return curNode.data;
    }

    /**
     * 添加到末尾
     *
     * @param e 元素
     * @return 插入成功或失败
     */
    @Override
    public boolean add(E e) {
        return addLast(e);
    }

    /**
     * 插入指定位置
     *
     * @param index 位置，第1个为0
     * @param e     元素
     * @return 插入成功/失败
     */
    public boolean add(int index, E e) {
        checkRange(index);

        Node<E> newNode = new Node<>(e);
        size++;

        ///原链表为空
        if (head == null) {
            head = newNode;
            return true;
        }

        ///插入头部
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return true;
        }

        ///插入其他位置
        Node<E> curNode = head;
        for (int i = 0; i < index - 1; i++) {
            curNode = curNode.next;
        }
        newNode.next = curNode.next;
        newNode.prev = curNode.next.prev;
        curNode.next.prev = newNode;
        curNode.next = newNode;
        return true;
    }


    public boolean addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
        return true;
    }

    public boolean addLast(E e) {
        Node<E> node = new Node<>(e);
        return addLast(node);
    }

    public boolean addLast(Node<E> newNode) {
        if (newNode == null) throw new IllegalArgumentException("添加的节点不能为空");

        size++;

        if (head == null) {
            head = newNode;
            tail = head;
            return true;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

        return true;
    }

    /**
     * 删除与指定元素相等的第一个元素
     * <p>
     * 注意删除后要相应地改变头尾指针
     *
     * @param o 指定元素
     * @return 删除成功/失败
     */
    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }

        size--;

        if (head.next == null && head.data.equals(o)) {
            head = null;
            tail = null;
            return true;
        }

        Node<E> p = head;
        Node<E> q = head.next;
        ///单独处理头节点
        if (p.data.equals(o)) {
            head = head.next;
            head.prev = null;
        }

        ///继续处理剩下节点
        while (q != null) {
            if (q.data.equals(o)) {
                ///q是尾节点
                if (q.next == null) {
                    p.next = null;
                    tail = p;

                } else {
                    ///q不是尾节点
                    p.next = q.next;
                    q.next.prev = p;
                }
                return true;
            }
            p = q;
            q = q.next;
        }

        return false;
    }

    /**
     * 移除指定位置的元素
     * <p>
     * 注意：当链表元素是整数时，要删除元素不要用此方法，要用remove(Object o) !!!
     *
     * @param index 位置索引，第一个为0
     * @return 位置元素
     */
    public E remove(int index) {

        checkRange(index);

        if (head == null) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        //定位到待删除元素的前一个
        Node<E> curNode = head;
        Node<E> newNode;
        for (int i = 0; i < index - 1; i++) {
            curNode = curNode.next;
        }

        ///如果要删除的是最后一个元素
        if (curNode.next.next == null) {
            newNode = curNode.next;
            curNode.next = null;
            size--;
            return newNode.data;
        }

        ///如果要删除的不是最后一个元素
        newNode = curNode.next;
        curNode.next = newNode.next;
        newNode.next.prev = curNode;
        size--;
        return newNode.data;
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }

        Node<E> newNode = head;
        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return newNode.data;
        }

        head = head.next;
        head.prev = null;
        size--;
        return newNode.data;
    }

    public E removeLast() {

        if (head == null) {
            return null;
        }

        Node<E> newNode = head;
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return newNode.data;
        }

        Node<E> p = head;
        Node<E> q = head.next;

        ///只有2个节点的场景
        if (q.next == null) {
            tail = q.prev;
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        tail = q.prev;
        tail.next = null;
        newNode = q;
        size--;
        return newNode.data;
    }


    @Override
    public void clear() {
        while (head != null) {
            head = head.next;
        }
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (head == null) {
            return false;
        }

        Node<E> curNode = head;
        while (curNode != null) {
            if (curNode.data.equals(o)) {
                return true;
            }
            curNode = curNode.next;
        }

        return false;
    }

    @Override
    public Object clone() {
        TwoWayList<E> clone = new TwoWayList<>();
//        try {
//            clone = (TwoWayList<E>) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }

        clone.head = null;
        clone.tail = null;
        clone.size = 0;

        Node<E> curNode = head;
        while (curNode != null) {

            //不要直接用addLast(Node<E> newNode)，这样还会使用原链表的prev和next！！！
            clone.addLast(curNode.data);

            curNode = curNode.next;

        }
        return clone;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] t) {
        if (head == null) {
            return null;
        }

        if (t.length < size) {
            t = (T[]) Array.newInstance(t.getClass().getComponentType(), size);
        }

        Object[] result = t;

        Node<E> curNode = head;
        for (int i = 0; i < size; i++) {
            result[i] = curNode.data;
            curNode = curNode.next;
        }
        return t;

    }

    private void checkRange(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException(index + " 插入的位置越界或不合法");
    }

    @Override
    public String toString() {
        return "TwoWList{" +
                "size=" + size +
                ", head=" + (head == null ? "NULL" : head.data) +
                ", tail=" + (tail == null ? "NULL" : tail.data) +
                '}';
    }

    private static class Node<E> {
        Node<E> prev;
        Node<E> next;
        E data;

        public Node(E data) {
            this.prev = null;
            this.next = null;
            this.data = data;
        }

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + (data == null ? "NULL" : data) +
                    ", next=" + (next == null ? "NULL" : next.data) +
                    ", prev=" + (prev == null ? "NULL" : prev.data) +
                    '}';
        }
    }

}

