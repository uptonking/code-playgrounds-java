package yao.basic.sort;

import java.util.List;

/**
 * 快速排序
 * 先找基准值分两组，再左右递归排序
 */
public class QuickSort {

    public static void sortArray(int[] a) {
        sortArray(a, 0, a.length - 1);
    }

    public static void sortArray(int[] a, int start, int end) {

        if (end < start) return ;

        // 选定的基准值，这里选第一个元素
        int base = a[start];

        //先分两组
        int i = start, j = end;
        while (i <= j) {
            while ((a[i] < base) && (i < end)) {
                i++;
            }
            while ((a[j] > base) && (j > start)) {
                j--;
            }

            if (i <= j) {
                int temp;
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        //再各组递归排序
        if (j > start)
            sortArray(a, start, j);
        if (i < end)
            sortArray(a, i, end);

    }


    public static void sortList(List<Integer> a) {


    }

}
