package yao.algs.tree;

/**
 * 通用二叉树节点
 * Created by yaoo on 1/12/18
 */
public class BinaryTreeNode<E> {

    public E data;
    public BinaryTreeNode<E> left;
    public BinaryTreeNode<E> right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(E data) {
        this.data = data;
    }

    public BinaryTreeNode(E data, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + (data == null ? "NOT EXISTS" : left.data.toString()) +
                ", left=" + (left == null ? "NOT EXISTS" : left.data.toString()) +
                ", right=" + (left == null ? "NOT EXISTS" : left.data.toString()) +
                '}';
    }

}
