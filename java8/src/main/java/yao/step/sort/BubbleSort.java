package yao.step.sort;

import java.util.List;

/**
 * Created by yaoo on 6/17/17.
 */
public class BubbleSort {

    public static int[] sortArray(int[] a) {

        int length = a.length;

        for (int i = 0; i < length -1; i++) {

            for (int j = 0; j < length - 1 - i; j++) {
                if (a[j] > a[j+1]) {
                    int t = a[j+1];
                    a[j+1] = a[j];
                    a[j] = t;
                }

            }
        }


        return a;
    }

    public static List<Integer> sortList(List<Integer> a) {


        return a;
    }

}
