package yao.basic.nonlinear.heap;

/**
 * 大顶堆
 */
public class MaxHeap<T extends Comparable<T>> extends Heap<T> {


    @Override
    public void heapify(T[] a, int i, int heapLength) {
        int l = left(i);
        int r = right(i);
        int largest = -1;
        /**
         * 下面两个if条件句用来找到三个元素中的最大元素的位置largest；
         * l < heapLength说明l在数组内，i非叶子结点；
         */
        if (l < heapLength && a[i].compareTo(a[l]) < 0) {
            largest = l;
        } else {
            largest = i;
        }
        // r < heapLength说明r在数组内
        if (r < heapLength && a[largest].compareTo(a[r]) < 0) {
            largest = r;
        }

        // 如果i处元素不是最大的，就把i处的元素与最大处元素交换，交换会使元素下降
        if (i != largest) {
            T temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            // 交换元素后，以a[i]为根的树可能不在满足大根堆性质，于是递归调用该方法
            heapify(a, largest, heapLength);
        }
    }


}

