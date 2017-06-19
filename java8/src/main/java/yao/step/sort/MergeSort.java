package yao.step.sort;

import java.util.List;

/**
 * Created by yaoo on 6/17/17.
 */
public class MergeSort {


    public static int[] sortArray(int[] nums) {
        return sortArray(nums, 0, nums.length - 1);
    }

    /**
     * 时间复杂度为O(nlogn)
     *
     * @param arr 待排序数组
     * @return 输出有序数组
     */
    public static int[] sortArray(int[] arr, int low, int high) {


        if (low < high) {
            //找出中间索引
            int mid = (low + high) / 2;
            // 左边
            sortArray(arr, low, mid);
            // 右边
            sortArray(arr, mid + 1, high);
            // 左右归并
            merge(arr, low, mid, high);
        }


        return arr;
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


    public static List<Integer> sortList(List<Integer> a) {


        return a;
    }

}
