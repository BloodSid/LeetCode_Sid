package leetcode.editor.cn;

import java.util.*;

/**
 * 最长定差子序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 00:19:51
 */
public class LongestArithmeticSubsequenceOfGivenDifferenceSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : arr) {
            int cnt = map.getOrDefault(num - difference, 0);
            cnt++;
            map.put(num, cnt);
            max = Math.max(max, cnt);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
