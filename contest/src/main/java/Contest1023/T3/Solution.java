package Contest1023.T3;

/**
 * @author IronSid
 * @since 2022-10-23 10:53
 */
public class Solution {
    private int[] nums;
    private int[] cost;
    private int n;

    public long minCost(int[] nums, int[] cost) {
        this.nums = nums;
        this.cost = cost;
        n = nums.length;
        int l = 1, r = (int) 1e6;
        while (l + 2 < r) {
            int lm = (2 * l + r) / 3;
            int rm = (2 * r + l) / 3;
            if (cost(lm) <= cost(rm)) {
                r = rm;
            } else {
                l = lm;
            }
        }
        long min = Long.MAX_VALUE;
        for (; l <= r; l++) {
            min = Math.min(min, cost(l));
        }
        return min;
    }

    long cost(int target) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) cost[i] * Math.abs(nums[i] - target);
        }
        return res;
    }
}
