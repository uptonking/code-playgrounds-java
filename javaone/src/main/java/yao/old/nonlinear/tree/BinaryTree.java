package yao.old.nonlinear.tree;


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

        BinaryTreeNode<T> temp;

        while (!queue.isEmpty()) {
            temp = queue.poll();
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


    /**
     * 非递归后序遍历
     * ！！！测试失败
     * 完成遍历左子树之后，需要访问当前节点，之后遍历完成右子树还需要访问该当前节点。只有在第二次访问时才处理当前节点。
     * 如何区分两次访问？
     * 方法：当元素出栈时，检查这个元素与栈顶元素的右子节点是否相同。若相同，则说明已经完成左、右子树遍历，此时只需要将栈顶元素出栈输出。
     *
     * @param root 二叉树根节点
     */
    public void postOrderNonRecursive(BinaryTreeNode<T> root) {
        // 根节点为null，不作处理，直接结束
        if (root == null) {
            return;
        }
        // 创建栈存储节点
        Stack<BinaryTreeNode<T>> stack = new Stack<>();

        // 遍历
        while (root!=null||!stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 栈为空，结束程序
                if (stack.isEmpty()) {
                    stack.clear();
                    return;
                } else {
                    // 如果右子树为空，说明栈顶元素是叶子节点
                    if (stack.peek().right == null) {
                        root = stack.pop();
                        System.out.print(root.data + " ");
                        // 判断左右子树是否遍历完
                        if (root == stack.peek().right) {
                            System.out.print(stack.peek().data + " ");
                            root = stack.pop();
                        }
                    }
                }

                if (!stack.isEmpty()) {
                    // 判断根节点左右子树是否遍历完
                    if (root == stack.peek().right) {
                        System.out.print(stack.peek().data + " ");
                        stack.pop();
                        root = null;
                    } else {
                        root = stack.peek().right;
                    }
                } else {
                    root = null;
                }
            }
        }
    }


}





