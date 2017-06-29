package yao.basic.nonlinear.tree;


import java.util.*;

/**
 * 二叉树基本操作
 */
public class BinaryTree<T> {


    /**
     * 利用数组建立二叉树
     *
     * @param array 数组
     * @param start 起始元素下标
     * @param end   终止元素下标
     * @return 根结点
     */
    public BinaryTreeNode<T> createBinaryTreeFromArray(T[] array, int start, int end) {
        if (end < start) {
            return null;
        }

        int middle = (start + end) / 2;

        BinaryTreeNode<T> treeNode = new BinaryTreeNode<>(array[middle]);

        treeNode.left = createBinaryTreeFromArray(array, start, middle - 1);
        treeNode.right = createBinaryTreeFromArray(array, middle + 1, end);

        return treeNode;
    }

    /**
     * 层序遍历二叉树，利用队列
     * 从上到下按层遍历左右子树
     *
     * @param rootNode
     */
    public void levelOrderTraverse(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> temp = queue.poll();
            System.out.print(temp.data + ", ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }

    /**
     * 先序遍历二叉树
     * 根，左，右
     *
     * @param rootNode
     */
    public void preOrderTraverse(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        System.out.print(rootNode.data + ", ");

        preOrderTraverse(rootNode.left);
        preOrderTraverse(rootNode.right);


    }

    /**
     * 中序遍历二叉树
     * 左，根，右
     *
     * @param rootNode
     */
    public void midOrderTraverse(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        midOrderTraverse(rootNode.left);

        System.out.print(rootNode.data + ", ");

        midOrderTraverse(rootNode.right);

    }

    /**
     * 后序遍历二叉树
     * 左，右，根
     *
     * @param rootNode
     */
    public void postOrderTraverse(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        postOrderTraverse(rootNode.left);
        postOrderTraverse(rootNode.right);

        System.out.print(rootNode.data + ", ");

    }


    /**
     * 先序遍历，利用栈
     * 类似于深度优先搜索DFS
     * 创建一个栈，先将根结点入栈，只要栈不为空，就出栈，再依次将右、左节点入栈
     * 简单易懂，单不适合扩展到中序和后序
     *
     * @param rootNode
     */
    public void preOrderTraverse1(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(rootNode);

        while (!stack.isEmpty()) {
            BinaryTreeNode<T> temp = stack.pop();
            System.out.print(temp.data + ", ");

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

    }

    /**
     * 先序遍历，利用栈
     * 两层循环，内层打印根结点，再遍历左子树，外层遍历右子树
     *
     * @param rootNode
     */
    public void preOrderTraverse2(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        Stack<BinaryTreeNode<T>> stack = new Stack<>();

        while (rootNode != null || !stack.isEmpty()) {

            while (rootNode != null) {
                System.out.print(rootNode.data + ", ");
                stack.push(rootNode);
                rootNode = rootNode.left;
            }

            rootNode = stack.pop();
            rootNode = rootNode.right;

        }

    }

    /**
     * 中序遍历，利用栈
     * 利用两层循环，内层遍历左子树，外层打印根结点，再遍历右子树
     *
     * @param rootNode
     */
    public void midOrderTraverse1(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (rootNode != null || !stack.isEmpty()) {

            while (rootNode != null) {
                stack.push(rootNode);
                rootNode = rootNode.left;
            }
            rootNode = stack.pop();
            System.out.print(rootNode.data + ", ");
            rootNode = rootNode.right;
        }

    }

    /**
     * 后序遍历
     * 先左右，再回溯根，需要一个记录哪些节点已被访问的标记
     *
     * @param rootNode
     */
    public void postOrderTraverse1(BinaryTreeNode<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        Stack<BinaryTreeNode<T>> stack = new Stack<>();

        Map<BinaryTreeNode<T>, Boolean> map = new HashMap<>();

        stack.push(rootNode);

        while (!stack.isEmpty()) {

            BinaryTreeNode<T> temp = stack.peek();

            if (temp.left != null && !map.containsKey(temp.left)) {
                temp = temp.left;

                while (temp != null) {

                    if (map.containsKey(temp)) {
                        break;
                    } else {
                        stack.push(temp);
                        temp = temp.left;
                    }
                }
                continue;
            }

            if (temp.right != null && !map.containsKey(temp.right)) {
                stack.push(temp.right);
                continue;
            }

            BinaryTreeNode<T> node = stack.pop();
            map.put(node, true);

            System.out.print(node.data + ", ");
        }
    }




}
