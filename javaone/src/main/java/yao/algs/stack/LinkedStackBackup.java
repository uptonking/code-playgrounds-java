package yao.algs.stack;

import java.lang.reflect.Array;

/**
 * 双向链表实现的栈
 * <p>
 * 无其他依赖
 */
@SuppressWarnings("unused")
public class LinkedStackBackup<E> {

    private Node<E> top;
    private int size;

    public LinkedStackBackup() {
    }

    public void push(E e) {
        Node<E> newNode = new Node<>(e);
        size++;

        if (top == null) {
            top = newNode;
            return;
        }

        top.next = newNode;
        newNode.prev = top;
        top = newNode;
    }

    public E pop() {
        if (top == null) {
            throw new RuntimeException("栈为空，不能删除元素");
//            return null;
        }

        Node<E> newNode = top;
        if (top.prev == null) {
            size--;
            top = null;
            return newNode.item;
        }

        top = top.prev;
        top.next = null;
        size--;
        return newNode.item;
    }

    public E peek() {
        return top == null ? null : top.item;
    }

    /**
     * 查找是否存在元素
     * todo 返回元素距栈顶的距离
     *
     * @param o 元素
     * @return 是否存在
     */
    public boolean search(Object o) {
        if (top == null) {
            return false;
        }

        Node<E> curNode = top;
        while (curNode != null) {
            if (curNode.item.equals(o)) {
                return true;
            }
            curNode = curNode.prev;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] t) {
        if (top == null) {
            return null;
        }

        if (t.length < size) {
            t = (T[]) Array.newInstance(t.getClass().getComponentType(), size);
        }

        Object[] result = t;

        //将指针定位到栈底
        Node<E> curNode = top;
        while (curNode.prev != null) {
            curNode = curNode.prev;
        }
        for (int i = 0; i < size; i++) {
            result[i] = curNode.item;
            curNode = curNode.next;
        }
        return t;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public Node(E item) {
            this.item = item;
        }
    }
}
