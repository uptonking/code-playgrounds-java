package yao.basic.sort;

import java.util.List;

/**
 * 选择排序
 * 每次比较出最小的，对换到最左边
 */
public class SelectSort {

    public static void sortArray(int[] a) {

        int length = a.length;
        for (int i = 0; i < length; i++) {
            //假设i为最小
            int minPos = i;
            int minVal = a[i];

            for (int j = i + 1; j < length; j++) {
                if (a[j] < minVal) {
                    minVal = a[j];
                    minPos = j;
                }

            }
            a[minPos] = a[i];
            a[i] = minVal;

        }

    }

    public static void sortList(List<Integer> a) {


    }

}
