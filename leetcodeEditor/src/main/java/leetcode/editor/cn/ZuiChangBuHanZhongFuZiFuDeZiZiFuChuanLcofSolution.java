package leetcode.editor.cn;

import java.util.*;

/**
 * 最长不含重复字符的子字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-06 00:06:15
 */
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] pre = new int[128];
        Arrays.fill(pre, -1);
        int p1 = -1;
        char[] arr = s.toCharArray();
        int max = 0;
        for (int p2 = 0; p2 < arr.length; p2++) {
            char cur = arr[p2];
            p1 = Math.max(pre[cur], p1);
            max = Math.max(p2 - p1, max);
            pre[cur] = p2;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
