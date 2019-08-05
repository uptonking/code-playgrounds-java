package yao.algs.sort;

import java.util.List;

/**
 * 归并排序
 * 先找中间位置索引，再左右递归排序，再用辅助数组归并
 */
public class MergeSort {

    public static void sortArray(int[] nums) {
         sortArray(nums, 0, nums.length - 1);
    }

    /**
     *
     * @param arr 待排序数组
     * @return 输出有序数组
     */
    public static void sortArray(int[] arr, int low, int high) {

        if (low < high) {

            //找出中间索引
            int mid = (low + high) / 2;

            // 先左边递归排序
            sortArray(arr, low, mid);
            // 后右边递归排序
            sortArray(arr, mid + 1, high);

            // 再用辅助数组归并排序
            merge(arr, low, mid, high);
        }

    }


    /**
     * 将数组中low到high位置的数进行排序
     *
     * @param arr 待排序数组
     * @param low  待排的开始位置
     * @param mid  待排中间位置
     * @param high 待排结束位置
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int t = 0; t < temp.length; t++) {
            arr[low+t] = temp[t];
        }
    }


    public static void sortList(List<Integer> a) {



    }

}
