package Contest0317.T4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2024-03-17 10:23
 */
public class Solution {
    public long minimumMoves(int[] nums, int k, int mc) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                list.add(i);
            }
        }
        int m = list.size();
        int[] idx = new int[m];
        long[] p = new long[m + 1];
        long t = 0;
        // c: 最多连续的1的个数
        int c = 0;
        for (int i = 0, tc = 0; i < m; i++) {
            t += idx[i] = list.get(i);
            p[i+1] = t;
            if (i > 0 && idx[i] == idx[i - 1] + 1) {
                tc++;
            } else {
                tc = 1;
            }
            c = Math.max(c, tc);
        }
        // 只考虑连续的3个
        c = Math.min(c, 3);
        // 分3步考虑，1. 选i, i+1, i-1 上的1; 2. 再接着选mc中的 3. 如果还不够，则选择离i最近的
        if (k <= c) {
            return k - 1;
        }
        if (k - c <= mc) {
            return (k - c) * 2L + Math.max(c - 1, 0);
        }
        // 考虑到第3步，此时问题可转化成mc中的全选，然后选离i最近的k-mc个，可用中位数贪心求解
        int size = k - mc;
        long res = Long.MAX_VALUE;
        for (int r = size; r <= m; r++) {
            int l = r - size;
            int i = l + size / 2;
            long ls = (long) (i - l) * idx[i] - (p[i] - p[l]);
            long rs = p[r] - p[i] - (long) (r - i) * idx[i];
            res = Math.min(res, ls + rs);
        }
        return mc * 2L + res;
    }
}
