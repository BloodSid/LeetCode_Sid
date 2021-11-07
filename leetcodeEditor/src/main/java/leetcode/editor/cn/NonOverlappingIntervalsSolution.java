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
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int n = intervals.length;
        int[] pre = intervals[0];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= pre[1]) {
                ans++;
                pre = intervals[i];
            }
        }
        return n - ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
