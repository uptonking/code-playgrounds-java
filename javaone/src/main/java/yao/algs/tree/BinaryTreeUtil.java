package yao.algs.tree;

import yao.algs.array.ResizableArray;
import yao.algs.stack.ArrayStack;

import java.util.Arrays;

/**
 * 二叉树通用工具
 * 遍历、查找
 * 遍历的返回值要用链表存，因为只知道根节点不知道节点总数
 * 静态方法不可以访问类上定义的泛型，如果静态方法操作的应用数据类型不确定，可以将泛型定义在方法上
 * 类似地，静态变量不能带有泛型，因为是多实例共享的
 * Created by yaoo on 1/12/18
 */
@SuppressWarnings("unused")
public class BinaryTreeUtil {

    //存储所有树节点数据
    private static ResizableArray list = new ResizableArray();


    /**
     * 先序遍历 递归
     */
    @SuppressWarnings("unchecked")
    public static <E> ResizableArray<E> traversePreOrderRecursive(BinaryTreeNode<E> root) {

        if (root != null) {
            list.add(root.data);
//            System.out.print(root.data + "  ");
            traversePreOrderRecursive(root.left);
            traversePreOrderRecursive(root.right);
        }

        return list;
    }

    /**
     * 后序遍历 递归
     */
    @SuppressWarnings("unchecked")
    public static <E> ResizableArray<E> traversePostOrderRecursive(BinaryTreeNode<E> root) {
        if (root != null) {
            traversePostOrderRecursive(root.left);
            traversePostOrderRecursive(root.right);
            list.add(root.data);
//            System.out.print(root.data + "  ");
        }

        return list;
    }

    /**
     * 中序遍历 递归
     */
    @SuppressWarnings("unchecked")
    public static <E> ResizableArray<E> traverseInOrderRecursive(BinaryTreeNode<E> root) {
        if (root != null) {
            traverseInOrderRecursive(root.left);
            list.add(root.data);
//            System.out.print(root.data + "  ");
            traverseInOrderRecursive(root.right);
        }
        return list;
    }

    /**
     * 先序遍历 迭代
     * 利用栈模拟递归
     * 方法可扩展至中序、后序，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树
     */
    @SuppressWarnings("unchecked")
    public static <E> ResizableArray<E> traversePreOrderIterative(BinaryTreeNode<E> root) {
        if (root == null) {
            return list;
        }

        ArrayStack<BinaryTreeNode<E>> stack = new ArrayStack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.data);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        return null;
    }

    /**
     * 先序遍历 迭代
     * 类似于图的DFS
     * 是对先序遍历的一种特殊实现，简单明了，但是不具备很好的扩展性，在中序和后序方式中不适用
     */
    @SuppressWarnings("unchecked")
    public static <E> ResizableArray<E> traversePreOrderDFSIterative(BinaryTreeNode<E> root) {
        if (root == null) {
            return list;
        }

        ArrayStack<BinaryTreeNode<E>> stack = new ArrayStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<E> temp = stack.pop();
            list.add(temp.data);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }


    /**
     * 后序遍历 迭代
     */
    @SuppressWarnings("unchecked")
    public static <E> ResizableArray<E> traversePostOrderIterative(BinaryTreeNode<E> root) {

        if (root == null) {
            return list;
        }

        ArrayStack<BinaryTreeNode<E>> stack = new ArrayStack<>();
        stack.push(root);

        if (root.right != null) {
            stack.push(root.right);
        }
        if (root.left != null) {
            stack.push(root.left);
        }

        while (!stack.isEmpty()) {
            BinaryTreeNode<E> temp = stack.pop();
            list.add(temp.data);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return list;
    }


    /**
     * 中序遍历 迭代
     */
    @SuppressWarnings("unchecked")
    public static <E> ResizableArray<E> traverseInOrderIterative(BinaryTreeNode<E> root) {


        return null;
    }


    /**
     * 层序遍历
     */
    public static <E> ResizableArray<E> traverseLevelOrder(BinaryTreeNode<E> root) {


        return null;
    }

    /**
     * 基于数组创建完全二叉树
     */
    public static <E> BinaryTreeNode<E> createCompleteBinaryTreeFromArray(E[] arr) {


        return null;
    }


    public static void main(String[] args) {

        BinaryTreeNode<String> root;
        BinaryTreeNode<String> D = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> H = new BinaryTreeNode<>("H", null, null);
        BinaryTreeNode<String> I = new BinaryTreeNode<>("I", null, null);
        BinaryTreeNode<String> J = new BinaryTreeNode<>("J", null, null);
        BinaryTreeNode<String> P = new BinaryTreeNode<>("P", null, null);
        BinaryTreeNode<String> G = new BinaryTreeNode<>("G", P, null);
        BinaryTreeNode<String> F = new BinaryTreeNode<>("F", null, J);
        BinaryTreeNode<String> E = new BinaryTreeNode<>("E", H, I);
        BinaryTreeNode<String> B = new BinaryTreeNode<>("B", D, E);
        BinaryTreeNode<String> C = new BinaryTreeNode<>("C", F, G);
        BinaryTreeNode<String> A = new BinaryTreeNode<>("A", B, C);
        root = A;

//        ResizableArray<String> list = BinaryTreeUtil.traverseInOrderRecursive(root);
//        ResizableArray<String> list = BinaryTreeUtil.traverseInOrderIterative(root);
//        ResizableArray<String> list = BinaryTreeUtil.traversePreOrderRecursive(root);
//        ResizableArray<String> list = BinaryTreeUtil.traversePreOrderIterative(root);
//        ResizableArray<String> list = BinaryTreeUtil.traversePreOrderDFSIterative(root);
//        ResizableArray<String> list = BinaryTreeUtil.traversePostOrderRecursive(root);
//        ResizableArray<String> list = BinaryTreeUtil.traversePostOrderIterative(root);
        Object[] arr = list.toArray(new Object[list.size()]);
        System.out.println(Arrays.toString(arr));
    }


}
