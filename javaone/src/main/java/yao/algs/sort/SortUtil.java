package yao.algs.sort;

import yao.algs.stack.ArrayStack;

import java.util.Arrays;

/**
 * 常用排序算法
 * <p>
 * Created by yaoo on 1/18/18
 */
public class SortUtil {


    /**
     * 排序算法模板
     *
     * @param a 待排序数组
     * @return 排序后的数组
     */
    public Comparable[] Sort(Comparable[] a) {
        Comparable[] result;

        return null;
    }

    /**
     * 直接选择排序 就地排序 O(n2) 不稳定
     * <p>
     * 分两边，左边有序为空，右边无序
     * 每轮选出最小的，与无序最左边的交换位置
     */
    public Object[] selectSort(Comparable[] a) {
        int len = a.length;
        Comparable temp;
        int m;

        for (int i = 0; i < len; i++) {
            //保存最小元素的位置
            m = i;
            for (int j = i; j < len; j++) {
                if (a[j].compareTo(a[m]) < 0) {
                    m = j;
                }
            }
            //一轮换一次
            temp = a[i];
            a[i] = a[m];
            a[m] = temp;
        }

        return a;
    }

    /**
     * 堆排序 就地排序 O(n*logn) 不稳定
     * <p>
     * 初始构建大顶堆，每次移除最大值放到末尾
     * 入堆是向上渗透，出堆是向下渗透
     * <p>
     * 使用小顶堆得到的结果是倒序
     */
    public Comparable[] heapSort(Comparable[] a) {
        int len = a.length;

        ///向上渗透建堆，结束后第1个最大
        for (int i = 0; i < len; i++) {
            percolateUp(i, a);
        }

        //System.out.println(Arrays.toString(a));

        ///向下渗透出堆，最大的在末尾
        for (int i = 0; i < len; i++) {
            percolateDown(0, a, len - i - 1);
        }

        return a;
    }

    /**
     * 从index开始向上渗透 最大堆
     * 一般index=size-1
     */
    public void percolateUp(int i, Comparable[] a) {
        Comparable temp;

        //当父节点存在
        while (getParent(i) >= 0) {

            //当前节点比父节点大
            if (a[i].compareTo(a[getParent(i)]) > 0) {
                temp = a[i];
                a[i] = a[getParent(i)];
                a[getParent(i)] = temp;
            }
            i = getParent(i);
        }

    }

    /**
     * 从index开始向下渗透 最大堆
     * 一般index=0
     *
     * @param last 表示最后一个无序元素
     */
    public void percolateDown(int i, Comparable[] a, int last) {
        Comparable temp;

        //将堆顶与最末位无序元素交换
        temp = a[i];
        a[i] = a[last];
        a[last] = temp;

        //当前节点的孩子节点，默认左孩子
        int child;

        //当左孩子存在
        while (getLChild(i) < last) {

            child = getLChild(i);
            //如果右孩子存在，且比左孩子还大
            if (child + 1 < last && a[child + 1].compareTo(a[child]) > 0) {
                child++;
            }

            //如果当前节点比孩子小
            if (a[i].compareTo(a[child]) < 0) {
                temp = a[i];
                a[i] = a[child];
                a[child] = temp;
            }

            i = child;
        }

    }

    /**
     * 获取当前节点的父节点索引
     * <p>
     * 注意i==0时的特殊情况
     *
     * @param i 当前节点索引
     * @return 父节点索引
     */
    private int getParent(int i) {
        return i == 0 ? -1 : (i - 1) / 2;
    }

    private int getLChild(int i) {
        return 2 * i + 1;
    }

    /**
     * 插入排序 就地排序 O(n2) 稳定
     * <p>
     * 分两边，左边有序
     * 右边逐一插入左边，小的放左边
     */
    public Comparable[] insertSort(Comparable[] a) {
        int len = a.length;
        Comparable temp;

        ///内层本质上就是插入排序
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i].compareTo(a[j]) < 0) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        return a;
    }

    /**
     * 希尔排序 就地排序  O(n^m) 1<m<2 时间复杂度与步长选择有关
     * 间距递减
     */
    public Comparable[] shellSort(Comparable[] a) {
        int len = a.length;
        Comparable temp;

        int gap = len / 2;

        while (gap > 0) {

            for (int i = gap; i < len; i = i + gap) {
                for (int j = 0; j < i; j = j + gap) {
                    if (a[i].compareTo(a[j]) < 0) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }

            gap = gap / 2;
        }

        return a;
    }

    /**
     * 冒泡排序 就地排序 O(n2) 稳定
     * <p>
     * 分两边，左边无序
     * 一轮比较，最大的放右边
     */
    public Comparable[] bubbleSort(Comparable[] a) {
        int len = a.length;
        Comparable temp;

        for (int i = len; i > 1; i--) {

            for (int j = 0; j < i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        return a;
    }

    /**
     * 快速排序 非递归
     * <p>
     * 栈存放每次的首尾索引
     */
    public Comparable[] quickSortStack(Comparable[] a) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(0);
        stack.push(a.length - 1);

        while (!stack.isEmpty()) {

            int high = stack.pop();
            int low = stack.pop();

            //计算基准值的位置，并将基准值放到最终正确的位置
            int pivotIndex = getPivotIndex(a, low, high);

            if (pivotIndex > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex < high && pivotIndex > 0) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }

        return a;
    }


    /**
     * 快速排序 空间O(logn) 时间O(n*logn) 不稳定
     * <p>
     * 先比较得出基准值位置，再递归分割
     */
    public Comparable[] quickSortRecursive(Comparable[] a) {

        quickSort(a, 0, a.length - 1);

        return a;
    }


    public void quickSort(Comparable[] a, int low, int high) {

        //递归中止条件，low在high的左边，也可以相等，都OK
        if (low > high) {
            return;
        }

        //下面这样也OK
//        if (low >= high) {
//            return;
//        }

        //先计算基准值的位置
        int pivotIndex = getPivotIndex(a, low, high);

        //System.out.println(Arrays.toString(a));

        quickSort(a, low, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, high);

    }

    /**
     * 计算基准值的位置，并把基准值放到最终的正确的位置
     * <p>
     * 所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。
     * 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作
     *
     * @param a    数组
     * @param low  头索引
     * @param high 尾索引
     * @return 基准值的下标
     */
    private int getPivotIndex(Comparable[] a, int low, int high) {

        //默认以第一个作为基准值，在low的位置挖个坑
        Comparable pivotValue = a[low];

        while (low < high) {

            ///从后往前找比基准值大的
            while (low < high && a[high].compareTo(pivotValue) > 0) {
                high--;
            }
            //把high的值填到基准值的位置
            a[low] = a[high];

            ///从前往后找比基准值小的
            while (low < high && a[low].compareTo(pivotValue) < 0) {
                low++;
            }
            a[high] = a[low];
        }

        //循环结束时，low==high或相差1，下面两行任选一条即可，把pivot填到最终正确的位置
        //a[high] = pivot;
        a[low] = pivotValue;

        return low;
    }


    /**
     * 归并排序 空间O(n) 时间O(n*logn) 稳定
     * <p>
     * 二路归并
     * <p>
     * 把待排序数组分为若干个子序列，每个子序列是有序的，然后再把有序子序列合并为整体有序序列
     * <p>
     * <p>
     * 先递归分割，再比较
     * 自上而下递归，自下而上迭代
     */
    public Comparable[] mergeSortRecursive(Comparable[] a) {

        mergeSort(a, 0, a.length - 1);
        return a;
    }

    private void mergeSort(Comparable[] a, int low, int high) {

        //递归中止条件，low位置必须在high的左边，不能相等，有两段才能归并
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        //System.out.println(Arrays.toString(a));

        ///二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);

        merge(a, low, mid, high);

    }

    private void merge(Comparable[] a, int low, int mid, int high) {

        //临时数组，长度与原数组a一样大
        Comparable[] tempArr = Arrays.copyOf(a, a.length);

        //临时数组索引，初始放置在第一段数组头部
        int tIndex = low;

        //第二段数组头部
        int rIndex = mid + 1;

        //本轮处理数组的最小位置索引
        int cIndex = low;

        ///取出两段数组中较小的放入临时数组，两段函数处理完一个
        while (low <= mid && rIndex <= high) {

            if (a[low].compareTo(a[rIndex]) < 0) {
                tempArr[tIndex++] = a[low++];
            } else {
                tempArr[tIndex++] = a[rIndex++];
            }

        }

        //将左边剩余元素归并
        while (low <= mid) {
            tempArr[tIndex++] = a[low++];
        }

        //将右边剩余元素归并
        while (rIndex <= high) {
            tempArr[tIndex++] = a[rIndex++];
        }

        ///将临时数组中有序的元素拷贝到原数组
        while (cIndex <= high) {
            a[cIndex] = tempArr[cIndex++];
        }

    }

    /**
     * 归并排序 非递归
     * <p>
     * 迭代实现
     */
    public Comparable[] mergeSortIterative(Comparable[] a) {

        int len = a.length;
        //最初归并元素的最小单元
        int k = 1;

        ///将数组中相邻的k个元素进行归并
        while (k < len) {
            int i = 0;

            while (i < len - 2 * k + 1) {
                merge(a, i, i + k - 1, i + 2 * k - 1);
                i = i + 2 * k;
            }

            //长度不足的部分单独归并
            if (i < len - k) {
                merge(a, i, i + k - 1, len - 1);
            }

            //归并的单元长度翻倍
            k = k * 2;
        }

        return a;
    }

    /**
     * 基数排序 LSD
     * <p>
     * 适用于：
     * (1)数据范围较小，建议在小于1000
     * (2)每个数值都要大于等于0
     */
    public Integer[] radixSortLSD(Integer[] a) {
        int len = a.length;

        //计算数组最大数
        int max = a[0];
        for (int i = 0; i < len; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        //计算最大数数位
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }

        //创建十进制的桶
        int[][] buckets = new int[10][a.length];

        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {

            //存储各桶元素的数量
            int[] bucketLen = new int[10];

            //分配
            for (int j = 0; j < len; j++) {
                int whichBucket = (a[j] % base) / (base / 10);
                buckets[whichBucket][bucketLen[whichBucket]] = a[j];
                bucketLen[whichBucket]++;
            }

            //收集
            int k = 0;
            for (int m = 0; m < buckets.length; m++) {
                for (int n = 0; n < bucketLen[m]; n++) {
                    a[k++] = buckets[m][n];
                }
            }

            base = base * 10;
        }

        return a;
    }


}
