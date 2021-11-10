package leetcode.editor.cn;

import java.util.*;

/**
 * 划分字母区间
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-10 13:01:47
 */
public class PartitionLabelsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] arr = s.toCharArray();
        int[][] intervals = new int[26][2];
        for (int i = 0; i < intervals.length; i++) {
            intervals[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] - 'a';
            intervals[index][0] = Math.min(intervals[index][0], i);
            intervals[index][1] = Math.max(intervals[index][1], i);
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> fusedIntervals = new ArrayList<>();
        fusedIntervals.add(intervals[0]);
        for (int i = 1; i < intervals.length && intervals[i][0] < arr.length; i++) {
            int[] lastInterval = fusedIntervals.get(fusedIntervals.size() - 1);
            if (intervals[i][0] < lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
                fusedIntervals.add(intervals[i]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] fusedInterval : fusedIntervals) {
            ans.add(fusedInterval[1] - fusedInterval[0] + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
