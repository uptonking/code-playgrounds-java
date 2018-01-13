package yao.algs.tree;

import yao.algs.array.ResizableArray;
import yao.algs.queue.ArrayQueue;
import yao.algs.stack.ArrayStack;

/**
 * 二叉树通用工具
 * 遍历、查找
 * 遍历的返回值用链表存，因为只知道根节点不知道节点总数
 * 静态方法不可以访问类上定义的泛型，如果静态方法操作的应用数据类型不确定，可以将泛型定义在方法上
 * 类似地，静态变量不能带有泛型，因为是多实例共享的
 * Created by yaoo on 1/12/18
 */
@SuppressWarnings("unused")
public class BinaryTreeUtil {

    //存储所有树节点数据，不能是静态类型，不能在这里声明的地方初始化，否组数据会一直追加
    private ResizableArray list = new ResizableArray();

    /**
     * 先序遍历 递归
     */
    @SuppressWarnings("unchecked")
    public <E> ResizableArray<E> traversePreOrderRecursive(BinaryTreeNode<E> root) {

        if (root != null) {
            list.add(root.data);
//            System.out.print(root.data + "  ");
            traversePreOrderRecursive(root.left);
            traversePreOrderRecursive(root.right);
        }

        return list;
    }

    /**
     * 中序遍历 递归
     */
    @SuppressWarnings("unchecked")
    public <E> ResizableArray<E> traverseInOrderRecursive(BinaryTreeNode<E> root) {

        if (root != null) {
            traverseInOrderRecursive(root.left);
            list.add(root.data);
//            System.out.print(root.data + "  ");
            traverseInOrderRecursive(root.right);
        }

        return list;
    }

    /**
     * 后序遍历 递归
     */
    @SuppressWarnings("unchecked")
    public <E> ResizableArray<E> traversePostOrderRecursive(BinaryTreeNode<E> root) {

        if (root != null) {
            traversePostOrderRecursive(root.left);
            traversePostOrderRecursive(root.right);
            list.add(root.data);
//            System.out.print(root.data + "  ");
        }

        return list;
    }


    /**
     * 先序遍历 迭代
     * 利用栈模拟递归，打印顺序用的是入栈顺序
     * 方法可扩展至中序，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树
     */
    @SuppressWarnings("unchecked")
    public <E> ResizableArray<E> traversePreOrderIterative(BinaryTreeNode<E> root) {
        if (root == null) {
            return list;
        }

        ArrayStack<BinaryTreeNode<E>> stack = new ArrayStack<>();

        BinaryTreeNode<E> curNode = root;
        while (curNode != null || !stack.isEmpty()) {

            ///节点移动到最左边
            while (curNode != null) {
                //记录节点数据
                list.add(curNode.data);

                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            curNode = curNode.right;
        }

        return list;
    }

    /**
     * 先序遍历 迭代
     * 类似于图的DFS
     * 是对先序遍历的一种特殊实现，简单明了，但是不具备很好的扩展性，在中序和后序方式中不适用
     */
    @SuppressWarnings("unchecked")
    public <E> ResizableArray<E> traversePreOrderDFSIterative(BinaryTreeNode<E> root) {
        if (root == null) {
            return list;
        }

        ArrayStack<BinaryTreeNode<E>> stack = new ArrayStack<>();
        stack.push(root);

        BinaryTreeNode<E> curNode;

        while (!stack.isEmpty()) {
            curNode = stack.pop();

            //记录节点数据
            list.add(curNode.data);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        return list;
    }

    /**
     * 中序遍历 迭代
     * 利用栈模拟递归，打印顺序用的是出栈顺序
     */
    @SuppressWarnings("unchecked")
    public <E> ResizableArray<E> traverseInOrderIterative(BinaryTreeNode<E> root) {
        if (root == null) {
            return list;
        }

        ArrayStack<BinaryTreeNode<E>> stack = new ArrayStack<>();
        BinaryTreeNode<E> curNode = root;

        while (curNode != null || !stack.isEmpty()) {

            ///节点移动到最左边
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            //记录节点数据
            list.add(curNode.data);
            curNode = curNode.right;
        }

        return list;
    }


    /**
     * 后序遍历 迭代
     * 不同于先序遍历和中序遍历，先处理左右子树，再回溯根，难点在于需要记录已经访问的节点
     */
    @SuppressWarnings("unchecked")
    public <E> ResizableArray<E> traversePostOrderIterative(BinaryTreeNode<E> root) {
        if (root == null) {
            return list;
        }

        ArrayStack<BinaryTreeNode<E>> stack = new ArrayStack<>();

        //当前访问的节点
        BinaryTreeNode<E> curNode = root;
        //上次访问的节点
        BinaryTreeNode<E> prevNode = null;

        ///curNode移到最左边
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }

        while (!stack.isEmpty()) {
            //弹出栈顶节点
            curNode = stack.pop();

            ///如果该节点存在右子树，且右子树未访问过
            if (curNode.right != null && curNode.right != prevNode) {

                stack.push(curNode);
                curNode = curNode.right;

                //curNode移到右子树最左边
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }

                ///右子树不存在时，直接打印该节点
            } else {
                list.add(curNode.data);
                prevNode = curNode;
            }
        }
        return list;
    }


    /**
     * 层序遍历
     * 类似于图的BFS
     * 用队列实现
     */
    @SuppressWarnings("unchecked")
    public <E> ResizableArray<E> traverseLevelOrder(BinaryTreeNode<E> root) {
        if (root == null) {
            return list;
        }

        ArrayQueue<BinaryTreeNode<E>> queue = new ArrayQueue<>();
        queue.offer(root);

        BinaryTreeNode<E> curNode;

        while (!queue.isEmpty()) {
            curNode = queue.poll();
            list.add(curNode.data);
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
        }

        return list;
    }

    /**
     * 基于数组创建完全二叉树
     * 数组a下标与完全二叉树节点位置关系：
     * a[i]的父节点是a[i-1 / 2],子节点分别是a[2i-1], a[2i]
     */
    @SuppressWarnings("unchecked")
    public <E> BinaryTreeNode<E> createCompleteBinaryTreeFromArray(E[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int len = arr.length;
        BinaryTreeNode[] nodeList = new BinaryTreeNode[len];
        for (int i = 0; i < len; i++) {
            nodeList[i] = new BinaryTreeNode(arr[i]);
        }

        int maxNotLeaf = calMaxNotLeaf(len);
        for (int i = 0; i < maxNotLeaf + 1; i++) {

            if (2 * i + 1 < len) {
                nodeList[i].left = nodeList[2 * i + 1];
            }
            if (2 * i + 2 < len) {
                nodeList[i].right = nodeList[2 * i + 2];
            }
        }

        return nodeList[0];
    }

    /**
     * 根据数组长度求最大的非叶节点下标
     * 层-下标 0-0 1-2 2-6 3-14 ... n-2^n+1-2
     * <p>
     * 长度  3  7  15
     * max  0  2  6
     *
     * @param len 数组长度
     * @return 最大非叶节点下标
     */
    int calMaxNotLeaf(int len) {
        if (len <= 0) {
            throw new RuntimeException("数组长度必须大于0");
        }
        if (len == 1) {
            return 0;
        }

        int maxNotLeaf;
        int i;
        i = 1;
        while (len > Math.pow(2, i) - 1) {
            i++;
        }
        maxNotLeaf = (int) (Math.pow(2, i - 1) - 2);
        return maxNotLeaf;
    }

}
