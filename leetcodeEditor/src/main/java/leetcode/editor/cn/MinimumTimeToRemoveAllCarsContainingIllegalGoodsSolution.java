package leetcode.editor.cn;

import java.util.*;

/**
 * 移除所有载有违禁货物车厢所需的最少时间
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-06 19:18:19
 */
public class MinimumTimeToRemoveAllCarsContainingIllegalGoodsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTime(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] &= 15;
        }
        int[] dp = new int[n + 1];
        int min = n;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + 2 * arr[i - 1], i);
            min = Math.min(dp[i] + n - i, min);
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
