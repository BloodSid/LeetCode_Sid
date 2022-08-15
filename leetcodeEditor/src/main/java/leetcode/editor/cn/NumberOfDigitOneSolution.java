package leetcode.editor.cn;

import java.util.*;

/**
 * 数字 1 的个数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-26 13:38:47
 */
public class NumberOfDigitOneSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private char[] s;
    private int[][] dp;

    public int countDigitOne(int n) {
        s = Integer.toString(n).toCharArray();
        for (int i = 0; i < s.length; i++) s[i] -= '0';
        dp = new int[s.length][s.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true);
    }

    int f(int i, int cnt1, boolean isLimited) {
        if (i == s.length) return cnt1;
        if (!isLimited && dp[i][cnt1] >= 0) return dp[i][cnt1];
        int res = 0;
        int up = isLimited ? s[i] : 9;
        int low = 0;
        for (int d = low; d <= up; d++) {
            res += f(i + 1, cnt1 + (d == 1 ? 1 : 0), isLimited && d == s[i]);
        }
        if (!isLimited) dp[i][cnt1] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
