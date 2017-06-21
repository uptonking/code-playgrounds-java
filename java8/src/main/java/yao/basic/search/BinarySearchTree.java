package yao.basic.search;

/**
 * 二叉查找树查找算法
 * 基于二叉查找树进行优化，进而可以得到其他的树表查找算法，如平衡树、红黑树等高效算法
 */
public class BinarySearchTree {

    /**
     * 二叉查找树定义
     * 二叉查找树左节点的所有节点都比根节点小，右节点的所有节点都比根节点大
     */
    static class BinaryTree {

        int data;
        int index;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int data, int index, BinaryTree left, BinaryTree right) {
            this.data = data;
            this.index = index;
            this.left = left;
            this.right = right;
        }

        public BinaryTree(int data, int index) {
            this.data = data;
            this.index = index;
        }

        public void setParent(BinaryTree parent) {
            if (this.data < parent.data) {
                parent.left = this;
            } else {
                parent.right = this;
            }
        }

    }

    /**
     * 二叉树查找
     *
     * @param arr
     * @param key
     * @return
     */
    public static int searchBinaryTree(int[] arr, int key) {
        BinaryTree bt = CreateBinaryTree(arr);
        return find(bt, key);
    }

    public static BinaryTree CreateBinaryTree(int[] arr) {
        BinaryTree binTree = new BinaryTree(arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            InsertNode(binTree, arr[i], i);
        }
        return binTree;
    }

    private static void InsertNode(BinaryTree tree, int key, int index) {
        //保存初始树
        BinaryTree parent = null;
        while (tree != null) {
            parent = tree;
            if (tree.data > key) {
                tree = tree.left;
            } else {
                tree = tree.right;
            }
        }

        //将新节点加入树
        tree = new BinaryTree(key, index);
        tree.setParent(parent);
    }

    public static int find(BinaryTree tree, int key) {

        while (tree != null) {
            if (key == tree.data) {
                return tree.index;
            } else if (key < tree.data) {
                tree = tree.left;
            } else {
                tree = tree.right;
            }
        }
        return -1;
    }

//    public static void LDR_BT(BinaryTree tree) {
//        if (tree != null) {
//            LDR_BT(tree.left);
//            System.out.print(tree.data + " ");
//            LDR_BT(tree.right);
//        }
//    }

}
