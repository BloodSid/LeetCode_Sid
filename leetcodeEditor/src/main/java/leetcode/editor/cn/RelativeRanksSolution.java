package leetcode.editor.cn;

import java.util.*;

/**
 * 相对名次
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-02 13:21:40
 */
public class RelativeRanksSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (o1, o2) -> score[o2] - score[o1]);
        String[] ranks = new String[n];
        for (int i = 0; i < n; i++) {
            String s = null;
            if (i == 0) {
                s = "Gold Medal";
            } else if (i == 1) {
                s = "Silver Medal";
            } else if (i == 2) {
                s = "Bronze Medal";
            } else {
                s = Integer.toString(i + 1);
            }
            ranks[index[i]] = s;
        }
        return ranks;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
