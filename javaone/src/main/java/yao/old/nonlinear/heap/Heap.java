package yao.old.nonlinear.heap;

public abstract class Heap<T extends Comparable<T>> {

    public int left(int i) {
        return (i + 1) * 2 - 1;
    }

    public int right(int i) {
        return (i + 1) * 2;
    }

    public int parent(int i) {
        // i为根结点
        if (i == 0) {
            return -1;
        }
        return (i - 1) / 2;
    }

    /**
     * @param a          保存堆的数组
     * @param i          堆中需要下降的元素
     * @param heapLength 堆元素个数
     */
    public abstract void heapify(T[] a, int i, int heapLength);

    /**
     * 建堆
     *
     * @param a          数组
     * @param heapLength 堆元素个数
     */
    public void buildHeap(T[] a, int heapLength) {

        // 从后往前看，lengthParent处的元素是第一个有孩子节点的节点
        int lengthParent = parent(heapLength - 1);

        // 最初，parent(length)之后的所有元素都是叶子结点；
        // 因为大于length/2处元素的孩子节点如果存在，那么
        // 它们的数组下标值必定大于length，这与事实不符；
        // 在数组中，孩子元素必定在父亲元素的后面，从后往前
        // 对元素调用maxHeapify，保证了元素的孩子都是大根堆
        for (int i = lengthParent; i >= 0; i--) {
            heapify(a, i, heapLength);
        }
    }
}

