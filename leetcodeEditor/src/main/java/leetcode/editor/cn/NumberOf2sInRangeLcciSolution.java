package leetcode.editor.cn;
//编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。 
//
// 示例: 
//
// 输入: 25
//输出: 9
//解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次) 
//
// 提示： 
//
// 
// n <= 10^9 
// 
// 👍 55 👎 0


import java.util.*;

/**
 * 2出现的次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-15 19:18:11 
 */
public class NumberOf2sInRangeLcciSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private char[] s;
    private int[][] dp;

    public int numberOf2sInRange(int n) {
        s = Integer.toString(n).toCharArray();
        for (int i = 0; i < s.length; i++) s[i] -= '0';
        dp = new int[s.length][s.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    int f(int i, int cnt2, boolean isLimited, boolean isNum) {
        if (i == s.length) return cnt2;
        if (!isLimited && isNum && dp[i][cnt2] >= 0) return dp[i][cnt2];
        int res = 0;
        if (!isNum) res = f(i + 1, cnt2, false, false);
        int up = isLimited ? s[i] : 9;
        int low = isNum ? 0 : 1;
        for (int d = low; d <= up; d++) {
            res += f(i + 1, cnt2 + (d == 2 ? 1 : 0), isLimited && d == s[i], true);
        }
        if (!isLimited && isNum) dp[i][cnt2] = res;
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
