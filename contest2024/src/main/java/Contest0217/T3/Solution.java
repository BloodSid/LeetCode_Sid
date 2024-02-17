package Contest0217.T3;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-02-17 22:03
 */
public class Solution {
    private int[] nums;
    private int n;
    private int target;
    private int[][] memo;

    public int maxOperations(int[] nums) {
        this.nums = nums;
        n = nums.length;
        int res = maxOperations(nums[0] + nums[1]);
        res = Math.max(res, maxOperations(nums[0] + nums[n - 1]));
        res = Math.max(res, maxOperations(nums[n - 2] + nums[n - 1]));
        return res;
    }

    private int maxOperations(int target) {
        this.target = target;
        memo = new int[n][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return f(0, n - 1);
    }

    private int f(int start, int end) {
        if (end - start <= 0) {
            // 范围内元素数量0或1时
            return 0;
        }
        if (memo[start][end] != -1) {
            return memo[start][end];
        }
        int res = 0;
        if (nums[start] + nums[start + 1] == target) res = Math.max(res, f(start + 2, end) + 1);
        if (nums[start] + nums[end] == target) res = Math.max(res, f(start + 1, end - 1)+ 1);
        if (nums[end - 1] + nums[end] == target) res = Math.max(res, f(start, end - 2) + 1);
        return memo[start][end] = res;
    }
}
