package yao.algs.sort;

import java.util.List;

/**
 * 希尔排序
 * 基于插入排序，先分组再隔h排序
 */
public class ShellSort {

    /**
     * int/2总能取到1,已开始每组最多2个元素
     *
     * @param a
     * @return
     */
    public static void sortArray(int[] a) {

        int length = a.length;
        for (int gap = length / 2; gap >= 1; gap /= 2) {

            for (int i = gap; i < length; i += gap) {

                for (int j = i; j > 0; j -= gap) {

                    if (a[j] < a[j - gap]) {

                        int tmp = a[j];
                        a[j] = a[j - gap];
                        a[j - gap] = tmp;
                    }

                }
            }
        }

    }


    /**
     * int/3取不到1的时候要+1，一开始每组最多3个元素
     *
     * @param a
     * @return
     */
    public static void sortArray3(int[] a) {

        int length = a.length;
        for (int gap = (length / 3) + 1; gap >= 1; gap /= 3) {

            for (int i = 0; i < length; i += gap) {

                for (int k = i; k > 0; k -= gap) {

                    if (a[k] < a[k - gap]) {

                        int tmp = a[k];
                        a[k] = a[k - gap];
                        a[k - gap] = tmp;
                    }

                }
            }
        }

    }


    public static void sortArray2(int[] a) {

        int length = a.length;

        int h = 1;
        while (h < length / 3) {
            h = h * 3 + 1;
        }

//        System.out.println(h);

        while (h >= 1) {
            for (int i = h; i < length; i += h) {

                if (a[i] < a[i - h]) {
                    int tmp = a[i];
                    int j = i - h;

                    while (j >= 0 && a[j] > tmp) {
                        a[j + h] = a[j];
                        j -= h;
                    }
                    a[j + h] = tmp;
                }
            }
            h = h / 3;
        }


    }

    public static void sortList(List<Integer> a) {

    }

}
