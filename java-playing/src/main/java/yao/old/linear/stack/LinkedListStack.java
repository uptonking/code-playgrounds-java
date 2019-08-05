package yao.old.linear.stack;

import yao.old.linear.list.SingleNode;

/**
 * 链表实现的栈
 */
public class LinkedListStack<T> {

    //栈顶指针
    private SingleNode<T> headNode;

    public LinkedListStack() {
        headNode = null;
    }

    public LinkedListStack(T data) {
        headNode = new SingleNode<T>(data);
    }

    public boolean isEmpty() {
        return headNode == null;
    }


    public int size() {
        int count = 0;
        SingleNode currentNode = headNode;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public void traverse() {
        SingleNode currentNode = headNode;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println();

    }

    public int search(T item) {
        int index = 1;
        SingleNode<T> currentNode = headNode;
        while (currentNode != null) {
            if (item.equals(currentNode.data)) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public void push(T item) {
        SingleNode node = new SingleNode(item);

        if (isEmpty()) {
            headNode = node;
        } else if (headNode.data == null) {
            headNode.data = item;
        } else {
            node.next = headNode;
            headNode = node;
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        } else {
            SingleNode<T> topNode = headNode;
            headNode = headNode.next;
            return topNode.data;
        }


    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        } else {
            return headNode.data;
        }
    }

    public void clear() {
        headNode = null;
    }


    public void display() {
        SingleNode<T> currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.next == null) {
                System.out.print(currentNode.data);
            } else {
                System.out.print(currentNode.data + ", ");
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }


    public void insertAtBottom(LinkedListStack<T> stack, T data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        T temp = stack.pop();
        insertAtBottom(stack, data);
        stack.push(temp);
    }

    public void reverseStack(LinkedListStack<T> stack){
        if (stack.isEmpty()){
            return;
        }
        T temp = stack.pop();

        reverseStack(stack);

        insertAtBottom(stack,temp);

    }




}
