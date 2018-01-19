package yao.algs.search;

/**
 * 常用查找算法
 * <p>
 * Created by yaoo on 1/19/18
 */
public class SearchUtil {

    /**
     * 查找算法模板
     *
     * @param a   数据集合
     * @param key 待查找的值
     * @return 位置索引
     */
    public int search(int[] a, int key) {

        return -1;
    }

    /**
     * 二分查找 非递归 O(logn)
     */
    public int binarySearchIterative(int[] a, int key) {

        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (a[mid] == key) {
                return mid;
            }

            if (a[mid] < key) {
                low = mid + 1;
            }

            if (a[mid] > key) {
                high = mid - 1;
            }
        }

        return -1;
    }


    /**
     * 二分查找 递归
     */
    public int binarySearchRecursive(int[] a, int key) {

        return binarySearch(a, key, 0, a.length - 1);

    }

    private int binarySearch(int[] a, int key, int low, int high) {

        //递归中止条件
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (a[mid] == key) {
            return mid;
        }

        if (a[mid] < key) {
            binarySearch(a, key, a[mid] + 1, high);
        }

        if (a[mid] > key) {
            binarySearch(a, key, low, a[mid] - 1);
        }

        return -1;
    }


    /**
     * 二叉查找树查找 递归 O(logn) ~ O(n)
     */
    public boolean bstSearchRecursive(Node<? extends Comparable> root, int key) {

        if (root.data.compareTo(key) == 0) {
            return true;
        }

        if (root.right != null) {
            if (root.data.compareTo(key) < 0) {
                bstSearchRecursive(root.right, key);
            }
        }

        if (root.left != null) {
            if (root.data.compareTo(key) > 0) {
                bstSearchRecursive(root.left, key);
            }
        }

        return false;
    }

    /**
     * 二叉查找树查找 循环
     */
    public boolean bstSearchIterative(Node<? extends Comparable> root, int key) {

        while (root != null) {

            if (root.data.compareTo(key) == 0) {
                return true;
            }

            if (root.data.compareTo(key) < 0) {
                root = root.right;
            }

            if (root.data.compareTo(key) > 0) {
                root = root.left;
            }
        }

        return false;
    }


    class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 插值查找 O(log (logn) )
     */
    public int insertSearch(int[] a, int key) {

        return -1;
    }

    /**
     * 斐波那契查找 O(logn)
     */
    public int fibonacciSearch(int[] a, int key) {

        return -1;
    }

}
