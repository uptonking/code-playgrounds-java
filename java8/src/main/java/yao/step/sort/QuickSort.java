package yao.step.sort;

import java.util.List;

/**
 * Created by yaoo on 6/17/17.
 */
public class QuickSort {

    public static int[] sortArray(int[] a) {
        sortArray(a, 0, a.length - 1);
        return a;
    }

    public static int[] sortArray(int[] a, int start, int end) {

        if (end < start) return null;

        // 选定的基准值（第一个数值作为基准值）
        int base = a[start];
        // 记录临时中间值
        int temp;
        int i = start, j = end;
        while (i <= j) {
            while ((a[i] < base) && (i < end)) {
                i++;
            }
            while ((a[j] > base) && (j > start)) {
                j--;
            }

            if (i <= j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        if (j > start)
            sortArray(a, start, j);
        if (i < end)
            sortArray(a, i, end);

        return a;
    }


    public static List<Integer> sortList(List<Integer> a) {


        return a;
    }

}
