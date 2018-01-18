package yao.old.linear.queue;

import yao.old.linear.list.SingleNode;

/**
 * 链表实现的队列
 */
public class LinkedListQueue<T> {

    private SingleNode<T> frontNode;
    private SingleNode<T> rearNode;

    public LinkedListQueue() {
        frontNode = rearNode = null;
    }

    public boolean isEmpty() {
        return frontNode == null && rearNode == null;
    }


    public int size() {
        int count = 0;
        SingleNode<T> currentNode = frontNode;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }


    public void traverse() {

    }

    public void search() {

    }

    public void enQueue(T item) {
        SingleNode<T> newNode = new SingleNode<>(item);

        if (isEmpty()) {
            frontNode = rearNode = newNode;
            return;
        }

        if (rearNode != null) {
            rearNode.next = newNode;
        }
        rearNode = newNode;


    }

    public T deQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，出队失败");
            return null;
        }

        T item = frontNode.data;
        frontNode = frontNode.next;

        return item;
    }

    public T[] reverse() {

        return null;
    }

    public void clear() {
        frontNode = rearNode = null;
    }

}
