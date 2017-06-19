package yao.step.sort;

import java.util.List;

/**
 * Created by yaoo on 6/17/17.
 */
public class SelectSort {

    public static int[] sortArray(int[] a) {

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

        return a;
    }

    public static List<Integer> sortList(List<Integer> a) {


        return a;
    }

}
