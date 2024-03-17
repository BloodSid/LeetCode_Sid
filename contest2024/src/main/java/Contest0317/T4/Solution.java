package Contest0317.T4;

/**
 * @author IronSid
 * @since 2024-03-17 10:23
 */
public class Solution {
    public long minimumMoves(int[] nums, int k, int mc) {
        int n = nums.length;
        long[] p = new long[n + 1];
        long[] q = new long[n + 1];
        long tq = 0;
        for (int i = 0, t = 0; i < n; i++) {
            t += nums[i];
            tq += (long) nums[i] * i;
            p[i + 1] = t;
            q[i + 1] = tq;
        }
        int[] idx = new int[(int) p[n]];
        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i] == 1) {
                idx[j++] = i;
            }
        }
        // 滑动窗口计算最近的k-mc个1离当前位置的距离
        long[] s = new long[n];
        if (k - mc > 0) {
            int cnt = k - mc;
            int l = 0, r = cnt - 1;
            for (int i = 0; i < n; i++) {
                while (r < idx.length - 1 && Math.abs(idx[r + 1] - i) <= Math.abs(i - idx[l])) {
                    l++;
                    r++;
                }
                // [l,i) 和[i,r] 分别计算
                s[i] = q[idx[r] + 1] - q[i] - (q[i] - q[idx[l]]) + (p[i] - p[idx[l]]) * i - (p[idx[r] + 1] - p[i]) * i;
            }
        }
        // 特殊处理 k = 1, 2 的特殊情况
        if (k == 1 && p[n] > 0) return 0;
        if (k == 2) {
            for (int i = 0; i < n - 1; i++) {
                if (p[i + 2] - p[i] == 2) {
                    return 1;
                }
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            int cnt = 0;
            // 优先考虑 i, i-1, i+1 上的1
            if (i > 0 && nums[i - 1] == 1) {
                sum += 1;
                cnt++;
            }
            if (nums[i] == 1) {
                cnt++;
            }
            if (i < n - 1 && nums[i + 1] == 1) {
                sum += 1;
                cnt++;
            }
            if (cnt + mc >= k) {
                // mc 中的1够用。k等于1或2时 cnt > k 的情况已经排除
                res = Math.min(res, sum + (k - cnt) * 2L);
            } else {
                // mc 中的1不够用，则找离i最近的 k-mc 个 1
                res = Math.min(res, s[i] + mc * 2);
            }
        }
        return res;
    }
}
