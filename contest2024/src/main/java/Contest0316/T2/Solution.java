package Contest0316.T2;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-03-16 22:26
 */
public class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int m = queries.length;
        int n = nums.length;
        boolean[] mark = new boolean[n];
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> nums[a] != nums[b] ? nums[a] - nums[b] : a - b);
        long[] res = new long[m];
        for (int i = 0, j = 0; i < m; i++) {
            int index = queries[i][0], k = queries[i][1];
            // 未标记
            if (!mark[index]) {
                sum -= nums[index];
                mark[index] = true;
            }
            for (; j < n && k > 0; j++) {
                if (!mark[idx[j]]) {
                    sum -= nums[idx[j]];
                    mark[idx[j]] = true;
                    k--;
                }
            }
            res[i] = sum;
        }
        return res;
    }
}
