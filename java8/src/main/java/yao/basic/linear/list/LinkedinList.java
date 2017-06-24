package yao.basic.linear.list;

/**
 * 单链表
 */
public class LinkedinList<T> {

    private SingleNode<T> headNode, tailNode;

    public LinkedinList() {
        headNode = null;
        tailNode = null;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public int size() {
        int length = 0;
        SingleNode<T> currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }


    public void traverse() {
        SingleNode<T> currentNode = headNode;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }

    }

    public int search(T item) {
        int index = 0;
        SingleNode<T> currentNode = headNode;
        while (currentNode != null) {
            if (item.equals(currentNode.data)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * 在指定位置插入新节点
     *
     * @param node     要插入的节点
     * @param position 节点插入后的位置，从1开始
     * @return
     */
    public SingleNode<T> addNode(SingleNode<T> node, int position) {

        if (headNode == null) {
            headNode = node;
            return headNode;
        }

        int length = size();
        if (position < 1 || position > length + 1) {
            System.out.println("插入的位置不合法，有效位置为：1 ～ " + (length + 1));
            return headNode;
        }

        if (position == 1) {
            ///在头部插入节点
            node.next = headNode;
            return node;
        } else {
            ///在中间或末尾插入节点
            int count = 1;
            SingleNode<T> currentNode = headNode;
            //让指针停在待插入位置position的前一个节点
            while (count < position - 1) {
                currentNode = currentNode.next;
                count++;
            }
            currentNode.next = node;
            node.next = currentNode.next.next;
            return headNode;
        }

    }

    /**
     * 删除指定位置的节点
     *
     * @param position
     * @return
     */
    public SingleNode<T> removeNode(int position) {

        int length = size();
        if (position < 1 || position > length + 1) {
            System.out.println("插入的位置不合法，有效位置为：1 ～ " + (length + 1));
            return headNode;
        }

        if (position == 1) {
            ///移除头节点
            headNode = headNode.next;
            return headNode;
        } else if (position == length) {
            ///移除尾节点
            int count = 1;
            SingleNode<T> currentNode = headNode;
            while (count < position - 1) {
                currentNode = currentNode.next;
                count++;
            }
            currentNode.next = null;
            return headNode;
        } else {
            ///移除中间节点
            int count = 1;
            SingleNode<T> currentNode = headNode;
            while (count < position - 1) {
                currentNode = currentNode.next;
                count++;
            }
            currentNode.next = currentNode.next.next;
            return headNode;
        }

    }


    public void clear() {
        if (headNode == null) {
            return;
        }

        SingleNode<T> currentNode = headNode;
        while (headNode != null) {
            currentNode = headNode.next;
            headNode.next = null;
            headNode = currentNode;
        }

    }

    public SingleNode<T> reverse() {
        if (headNode == null) {
            System.out.println("链表未创建或初始化失败");
            return null;
        }

        int length = size();

        if (length <= 0) {
            System.out.println("链表为空");
            return null;
        }

        if (length == 1) {
            return headNode;
        }

        SingleNode<T> pre = headNode;
        SingleNode<T> cur = headNode.next;
        SingleNode<T> next;
        pre.next = null;

//        if (length == 2) {
//            cur.next = pre;
//            headNode = cur;
//            return headNode;
//        }

        //length>2

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        headNode = pre;

        return headNode;

    }

    public void display() {
        SingleNode currentNode = headNode;
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
