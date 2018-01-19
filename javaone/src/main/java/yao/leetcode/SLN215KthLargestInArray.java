package yao.leetcode;

import java.util.Arrays;

/**
 * 寻找数组中第K大的值
 * <p>
 * 快排要注意数组长度
 * <p>
 * Created by yaoo on 1/19/18
 */
public class SLN215KthLargestInArray {


    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;

        //两个元素的处理

        quickSort(nums, 0, len - 1);

        return nums[len - k];

    }

    public void quickSort(int[] nums, int low, int high) {

        if (low > high) return;

        int pivotIndex = getPivotIndex(nums, low, high);

        quickSort(nums, low, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, high);

    }

    public int getPivotIndex(int[] nums, int low, int high) {

        int pivotValue = nums[low];

        while (low < high) {

            while (low < high && nums[high] > pivotValue) {
                high--;
            }
            nums[low] = nums[high];

            while (low < high && nums[low] < pivotValue) {
                low++;
            }
            nums[high] = nums[low];

        }

        nums[low] = pivotValue;

        return low;
    }

    public static void main(String[] args) {

        SLN215KthLargestInArray sln = new SLN215KthLargestInArray();

        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        int[] arr1 = new int[]{3, 3, 3, 3, 3, 3, 4};

        int result = sln.findKthLargest(arr, 2);

        sln.quickSort(arr1, 0, arr1.length - 1);

        System.out.println(Arrays.toString(arr1));
        //System.out.println(result);

    }
}

