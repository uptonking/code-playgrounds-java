package yao.leetcode;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Created by yaoo on 1/19/18
 */
public class SLN746MinCostClimbingStairs {


    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;
        int[] minCost = new int[len + 1];

        minCost[0] = cost[0];
        minCost[1] = cost[1];

        for (int i = 2; i <= len; i++) {

            int costI = (i == len) ? 0 : cost[i];

            minCost[i] = Math.min(minCost[i - 1] + costI, minCost[i - 2] + costI);
        }

        return minCost[cost.length];
    }

    public static void main(String[] args) {

        SLN746MinCostClimbingStairs sln = new SLN746MinCostClimbingStairs();

        // min 6
        int[] arr = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        int result = sln.minCostClimbingStairs(arr);

        System.out.println(result);

    }

}
