package Contest0107.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-01-07 22:35
 */
public class Solution {

    private long[] t;
    private int n;

    public long maxPower(int[] nums, int range, int k) {
        n = nums.length;
        t = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] += nums[i - 1];
            int j = i + (i & -i);
            if (j <= n) t[j] += t[i];
        }
        long l = Arrays.stream(nums).min().getAsInt();
        long r = sumRange(0, n - 1) + k;
        while (l <= r) {
            boolean valid = true;
            int remain = k;
            long mid = l + r >> 1;
            long[] copy = Arrays.copyOf(t, t.length);
            // 贪心地把 k 个电站分配，保证所有位置的供电数大于等于mid。若当前位置不足mid, 则在能给这个位置供电的最右位置加电站
            for (int i = 0; i < n; i++) {
                // 可供电范围 [i-range, i+range]
                long sum = sumRange(Math.max(0, i - range), Math.min(n - 1, i + range));
                if (sum < mid) {
                    // 当前位置供电不够 mid, 还缺 mid - sum
                    if (mid - sum > remain) {
                        // 剩余电站不够，则分配失败
                        valid = false;
                        break;
                    } else {
                        // 剩余电站够，则分配到最右边
                        add(i + range + 1, mid - sum);
                        remain -= mid - sum;
                    }
                }
            }
            if (valid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            t = copy;
        }
        return r;
    }

    long query(int x) {
        long ans = 0;
        for (int i = x; i > 0; i &= i - 1) {
            ans += t[i];
        }
        return ans;
    }

    void add(int x, long u) {
        for (int i = x; i <= n; i += i & -i) {
            t[i] += u;
        }
    }

    public long sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}
