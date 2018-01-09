package yao.basic.sort;

import java.util.List;

/**
 * 冒泡排序
 * 每次比较出最大的，两两交换到末位
 */
public class BubbleSort {

    public static void sortArray(int[] a) {

        int length = a.length;

        for (int i = 0; i < length - 1; i++) {

            for (int j = 0; j < length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = t;
                }

            }
        }


    }

    public static void sortList(List<Integer> a) {


    }

}
