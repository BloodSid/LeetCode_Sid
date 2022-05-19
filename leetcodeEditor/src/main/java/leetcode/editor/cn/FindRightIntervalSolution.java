package leetcode.editor.cn;

import java.util.*;

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
        Integer[] keys = new Integer[n];
        for (int i = 0; i < n; i++) {
            keys[i] = i;
        }
        Arrays.sort(keys, (o1, o2) -> intervals[o1][0] - intervals[o2][0]);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            int val = intervals[i][1];
            while (l <= r) {
                int mid = l + r >> 1;
                if (intervals[keys[mid]][0] >= val) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (l == n) res[i] = -1;
            else res[i] = keys[l];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
