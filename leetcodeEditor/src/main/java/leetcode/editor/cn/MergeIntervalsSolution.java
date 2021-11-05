package leetcode.editor.cn;

import java.util.*;

/**
 * 合并区间
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 19:04:31 
 */
public class MergeIntervalsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = list.get(list.size() - 1);
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(intervals[i][1], prev[1]);
            } else {
                list.add(intervals[i]);
            }
        }
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
