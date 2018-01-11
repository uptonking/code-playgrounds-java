package yao.algs.list;

import yao.algs.AbstractCollection;

import java.lang.reflect.Array;

/**
 * 循环链表
 * 所有节点的next都不为空
 * 场景：轮询算法
 * Created by yaoo on 1/11/18
 */
@SuppressWarnings("unused")
public class CircularList<E> extends AbstractCollection<E> {

    private int size;

    //private Node<E> head;
    //使用尾指针方便操作尾节点和头节点
    private Node<E> tail;

    public CircularList() {
    }

    public CircularList(E e) {
        this.tail = new Node<>(e);
        tail.next = tail;
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
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
            return true;
        }

        ///插入头部
        if (index == 0) {
            newNode.next = tail.next;
            tail.next = newNode;
            return true;
        }

        ///curNode移动到待插入位置的前一个
        Node<E> curNode = tail;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        newNode.next = curNode.next;
        curNode.next = newNode;
        return true;
    }


    public boolean addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = tail.next;
        tail.next = newNode;
        size++;
        return true;
    }

    public boolean addLast(E e) {
        Node<E> newNode = new Node<>(e);
        size++;
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
            return true;
        }

        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (tail == null) {
            return false;
        }
        if (tail.next == tail && tail.data.equals(o)) {
            tail = null;
            size--;
            return true;
        }

        Node<E> p = tail.next;
        Node<E> q = p.next;

        if (p.data.equals(o)) {
            tail.next = tail.next.next;
            size--;
        }
        while (q != tail.next) {

            if (q.data.equals(o)) {
                ///q是tail
                if (q == tail) {
                    p.next = tail.next;
                    tail = p;
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

        if (tail == null) {
            return null;
        }

        Node<E> newNode = tail;
        if (tail.next == tail) {
            tail = null;
            size--;
            return newNode.data;
        }

        if (index == 0) {
            return removeFirst();
        }

        //定位到待删除元素的前一个
        Node<E> curNode = tail;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }

        ///如果要删除的是最后一个元素
        if (curNode.next == tail) {
            newNode = curNode.next;
            curNode.next = tail.next;
            tail = curNode;
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
        if (tail == null) {
            return null;
        }

        Node<E> newNode = tail;
        if (tail.next == tail) {
            tail = null;
            size--;
            return newNode.data;
        }

        tail.next = tail.next.next;
        size--;
        return newNode.next.data;
    }

    public E removeLast() {

        if (tail == null) {
            return null;
        }

        Node<E> newNode = tail;
        if (tail.next == tail) {
            tail = null;
            size--;
            return newNode.data;
        }

        Node<E> p = tail.next;
        Node<E> q = p.next;

        if (q == tail) {
            tail.next = tail;
        }
        while (q != tail) {
            q = q.next;
            p = p.next;
        }
        p.next = q.next;
        newNode = q;
//        q = null;
        size--;
        return newNode.data;
    }


    @Override
    public void clear() {
        while (tail.next != tail) {
            tail = tail.next;
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
        if (tail == null) {
            return false;
        }

        Node<E> curNode = tail;
        if (tail.data.equals(o)) {
            return true;
        }
        while (curNode.next != tail) {
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

        if (tail == null) {
            return null;
        }

        if (t.length < size) {
            t = (T[]) Array.newInstance(t.getClass().getComponentType(), size);
        }

        Object[] result = t;

        Node<E> curNode = tail.next;
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

    private static class Node<E> {
        Node<E> next;
        E data;

        public Node(E data) {
            this.next = null;
            this.data = data;
        }
    }

}

