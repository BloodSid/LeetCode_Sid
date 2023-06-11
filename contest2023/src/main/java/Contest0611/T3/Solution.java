package Contest0611.T3;

/**
 * @author IronSid
 * @since 2023-06-11 10:29
 */
public class Solution {
    public long minCost(int[] nums, long x) {
        int n = nums.length;
        long minCost = Long.MAX_VALUE;
        // 每种类型巧克力的最小成本
        long[] mn = new long[n];
        for (int i = 0; i < nums.length; i++) {
            mn[i] = nums[i];
        }
        // 枚举操作次数
        for (int i = 0; i < n; i++) {
            long cost = i * x;
            for (int j = 0; j < mn.length; j++) {
                mn[j] = Math.min(mn[j], nums[(j + i) % n]);
                cost += mn[j];
            }
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }
}
