package leetcode.editor.cn;

import java.util.Map;
import java.util.TreeMap;

/**
 * 寻找右区间
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-20 00:10:51
 */
public class FindRightIntervalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        TreeMap<Integer, Integer> startToIndex = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            startToIndex.put(intervals[i][0], i);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> entry = startToIndex.ceilingEntry(intervals[i][1]);
            if (entry == null) res[i] = -1;
            else res[i] = entry.getValue();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
