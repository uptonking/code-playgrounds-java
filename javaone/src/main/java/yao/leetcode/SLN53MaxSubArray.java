package yao.leetcode;

/**
 * 最大连续子数组
 * Created by yaoo on 1/19/18
 */
public class SLN53MaxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;

        //dp[i] means the maximum subarray ending with A[i];
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {

        SLN53MaxSubArray sln = new SLN53MaxSubArray();

        //max 6
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int sumMax = sln.maxSubArray(arr);

        System.out.println(sumMax);
    }
}
