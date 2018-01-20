package yao.algs.list;

import yao.algs.AbstractCollection;

import java.lang.reflect.Array;

/**
 * 单向链表
 *
 * Created by yaoo on 1/10/18
 */
@SuppressWarnings("unused")
public class OneWayList<E> extends AbstractCollection<E> {

    private int size;


    private Node<E> head;

    public OneWayList() {
    }

    public OneWayList(E e) {
        this.head = new Node<>(e);
        size++;
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
            head = newNode;
            return true;
        }

        Node<E> curNode = head;
        for (int i = 0; i < index - 1; i++) {
            curNode = curNode.next;
        }
        newNode.next = curNode.next;
        curNode.next = newNode;
        return true;
    }


    public boolean addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    public boolean addLast(E e) {
        Node<E> newNode = new Node<>(e);
        size++;
        if (head == null) {
            head = newNode;
            return true;
        }
        Node<E> curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (head.next == null && head.data.equals(o)) {
            head = null;
            size--;
            return true;
        }

        Node<E> p = head;
        Node<E> q = head.next;
        while (q != null) {
            if (q.data.equals(o)) {
                if (q.next == null) {
                    p.next = null;
                } else {
                    p.next = q.next;
                }
                size--;
                return true;
            }
            p = q;
            q = q.next;
        }

        return false;
    }

    /**
     * 移除指定位置的元素
     *
     * @param index 位置索引，第一个为0
     * @return 位置元素
     */
    public E remove(int index) {

        checkRange(index);

        if (head == null) {
            return null;
        }

        Node<E> newNode = head;
        if (head.next == null) {
            head = null;
            size--;
            return newNode.data;
        }

        if (index == 0) {
            return removeFirst();
        }

        //定位到待删除元素的前一个
        Node<E> curNode = head;
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
        curNode.next = curNode.next.next;
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
            size--;
            return newNode.data;
        }

        head = head.next;
        size--;
        return newNode.data;
    }

    public E removeLast() {

        if (head == null) {
            return null;
        }

        Node<E> newNode = head;
        if (head.next == null) {
            head = null;
            size--;
            return newNode.data;
        }

        Node<E> p = head;
        Node<E> q = head.next;

        if (q.next == null) {
            head.next = null;
        }
        while (q.next != null) {
            q = q.next;
            p.next = q;
        }
        p.next = null;
        size--;
        return q.data;
    }


    /**
     * 反转链表 迭代法
     */
    public void reverseList(Node<E> head) {
        if (head == null || head.next == null) {
            return;
        }

        Node<E> p = head;
        Node<E> q = p.next;
        Node<E> temp;
        while (q != null) {
            temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }

        this.head.next = null;
        this.head = p;
    }

    /**
     * 反转链表 递归法 不推荐使用
     * <p>
     * 注意：使用此法反转后需要手动设置链表的head为返回值 ！！！
     */
    @Deprecated
    public Node<E> reverseListRecursive(Node<E> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<E> prev = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return prev;
    }

    @Override
    public void clear() {
        while (head != null) {
            head = head.next;
        }
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
        if (index > size - 1 || index < 0)
            throw new RuntimeException(index + " 插入的位置越界或不合法");
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    private static class Node<E> {
        Node<E> next;
        E data;

        public Node(E data) {
            this.next = null;
            this.data = data;
        }
    }

}

