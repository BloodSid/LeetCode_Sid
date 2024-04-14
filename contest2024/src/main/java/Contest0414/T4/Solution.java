package Contest0414.T4;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2024-04-14 10:27
 */
public class Solution {

    public static final int INF = (int) (1e9+7);
    private int n;
    private int[] nums;
    private int m;
    private int[] v;
    private HashMap<String, Integer> cache;

    public int minimumValueSum(int[] nums, int[] v) {
        n = nums.length;
        this.nums = nums;
        m = v.length;
        this.v = v;
        cache = new HashMap<>();
        int res = dp(0, 0, -1);
        return res != INF ? res : -1;
    }

    // 表示 nums[i] 之后的所有元素进行划分，当前划分到v[j]，且最后一组的的与运算值为 and 时的最小”值“
    // 该做法成立的原因：一端固定的情况下，子数组只能有O(logU)个不同的AND结果，那么时间复杂度是O(nmlogU)，不超时
    int dp(int i, int j, int and) {
        if (i == n) {
            if (j == m) return 0;
            else return INF;
        }
        if (j == m) {
            return INF;
        }
        String tuple = i + " " + j + " " + and;
        Integer val = cache.get(tuple);
        if (val != null) return val;
        and &= nums[i];
        // and只能越来越小，剪枝
        if (and < v[j]) {
            return INF;
        }
        int res = dp(i + 1, j, and);
        if (and == v[j]) res = Math.min(res, dp(i + 1, j + 1, -1) + nums[i]);
        cache.put(tuple, res);
        return res;
    }
}

