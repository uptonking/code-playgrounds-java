package yao.basic.linear.list;

/**
 * 双向链表
 */
public class DoubleList<T> {

    private DoubleNode<T> headNode;
    private DoubleNode<T> tailNode;
    private int length = 0;

    public DoubleList() {
        headNode = null;
        tailNode = null;
    }

    public DoubleList(DoubleNode<T> node) {
        headNode = node;
        tailNode = headNode;
    }

    public DoubleList(T data) {
        DoubleNode<T> node = new DoubleNode<T>(data);
        headNode = node;
        tailNode = headNode;
        length++;
    }

    public DoubleList(DoubleNode<T> node1, DoubleNode<T> node2) {
        headNode = node1;
        tailNode = node2;
        length = 2;
    }


    public boolean isEmpty() {

//        return headNode == null;
        return this.length == 0;
    }

    public int size() {
        int count = 0;
        DoubleNode<T> currentNode = headNode;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
//        return this.length;
    }

    public void traverse() {
        DoubleNode<T> currentNode = headNode;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public int search(T item) {
        int index = 1;
        DoubleNode<T> currentNode = headNode;
        while (currentNode != null) {
            if (item.equals(currentNode.data)) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    /**
     * 在指定位置插入
     *
     * @param node
     * @param position 从1开始
     * @return
     */
    public DoubleNode<T> addNode(DoubleNode<T> node, int position) {

        if (position < 0 || position > length) {
            throw new IndexOutOfBoundsException("不能在该位置插入元素,索引越界");
        }

        if (headNode == null) {
            headNode = node;
            tailNode = headNode;
            length++;
            return headNode;
        }

        //插入节点到头部
        if (position == 1) {
            node.pre = null;
            node.next = headNode;
            headNode.pre = node;
            headNode = node;
            length++;
            return headNode;
        }

        ///插入到链表中间
        int index = 1;
        DoubleNode<T> currentNode = headNode;
        while (index < position) {
            index++;
            currentNode = currentNode.next;
        }
        DoubleNode<T> tempNode = currentNode.next;
        node.next = tempNode;
        tempNode.pre = node;
        currentNode.next = node;
        node.pre = currentNode;
        length++;
        return headNode;
    }

    public DoubleNode<T> addToTail(T item) {
        DoubleNode<T> node = new DoubleNode<>(item);

        if (length == 0) {
            headNode = tailNode = node;
            length++;
            return headNode;
        }

        if (length == 1) {
            headNode.next = node;
            node.pre = headNode;
            length++;
            return headNode;
        }

        DoubleNode<T> currentNode = headNode;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = node;
        node.pre = currentNode;

        length++;
        return headNode;

    }

    public DoubleNode<T> addToHead(T item) {
        DoubleNode<T> node = new DoubleNode<>(item);

        if (length == 0) {
            headNode = tailNode = node;
            return headNode;
        }

        node.next = headNode;
        headNode.pre = node;

        headNode = node;

        return headNode;
    }


    public DoubleNode<T> removeNode(int position) {

        if (position < 1 || position > length) {
            System.out.println("插入的位置不合法，有效位置为：1 ～ " + length);
            return headNode;
        }

        if (position == 1) {
            ///移除头节点
            headNode = headNode.next;
            headNode.pre = null;
            length--;

        } else if (position == length) {
            ///移除尾节点
            int count = 1;
            DoubleNode<T> currentNode = headNode;
            while (count < position) {
                currentNode = currentNode.next;
                count++;
            }
            currentNode.next = null;
            tailNode = currentNode;
            length--;

        } else {
            ///移除指定位置的节点
            ///移除尾节点
            int count = 1;
            DoubleNode<T> currentNode = headNode;
            while (count < position) {
                currentNode = currentNode.next;
                count++;
            }
            DoubleNode<T> tempNode = currentNode.next;

            currentNode.next = tempNode.next;
            tempNode.next.pre = currentNode;
            length--;
        }
        return headNode;
    }

    public void clear() {
        headNode = null;
        tailNode = null;
        length = 0;

    }

    public DoubleNode<T> reverse() {

        if (length <= 0) {
            System.out.println("链表为空");
            return null;
        }

        if (length == 1) {
            return headNode;
        }


        DoubleNode<T> pre = null;
        DoubleNode<T> next = null;

        while (headNode != null) {
            next = headNode.next;

            headNode.next = pre;
            headNode.pre = next;

            pre = headNode;
            headNode = next;

        }

        headNode = pre;
        return headNode;
    }

    public void display() {

        DoubleNode<T> currentNode = headNode;
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

}
