package leetcode.editor.cn;

import java.util.*;

/**
 * 无重叠区间
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-07 11:44:47 
 */
public class NonOverlappingIntervalsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n = intervals.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return n - max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
