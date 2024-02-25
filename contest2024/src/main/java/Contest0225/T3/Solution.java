package Contest0225.T3;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-02-25 10:31
 */
public class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;
        int[] last = new int[n];
        for (int i = 0; i < m; i++) {
            last[changeIndices[i] - 1] = i + 1;
        }
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> last[a] - last[b]);
        // 某个下标i的 last[i]=0 表示该下标从未被标记
        if (last[idx[0]] == 0) {
            return -1;
        }
        int t = 0;
        int sum = 0;
        int p = 1;
        // 贪心按照标记时间顺序进行标记
        for (int j = 0; j < n; j++) {
            int i = idx[j];
            sum += nums[i] + 1;
            if (sum > last[i]) {
                return -1;
            }
            // 最早可以标记i的时间
            p = Math.max(p, sum);
            // 找最近的 changeIndices[p]=i
            while (p <= m && changeIndices[p - 1] - 1 != i) {
                p++;
            }
            // changeIndices 用尽
            if (p == m + 1) {
                return -1;
            }
            t = p;
        }
        return t;
    }
}
