package leetcode.editor.cn;
//如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。 
//
// 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 20
//输出：19
//解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
//解释：1 到 5 所有整数都是特殊整数。
// 
//
// 示例 3： 
//
// 
//输入：n = 135
//输出：110
//解释：从 1 到 135 总共有 110 个整数是特殊整数。
//不特殊的部分数字为：22 ，114 和 131 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁹ 
// 
// 👍 18 👎 0


import java.util.*;

/**
 * 统计特殊整数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-15 14:45:40 
 */
public class CountSpecialIntegersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] d = new int[10];
    int len = 0;
    int[][] dp;

    public int countSpecialNumbers(int n) {
        for (int t = n; t > 0; t /= 10) d[len++] = t % 10;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            int t = d[i]; d[i] = d[j]; d[j] = t;
        }
        dp = new int[len][1 << 10];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dp(0, 0, true, false);
    }

    int dp(int i, int mask, boolean isLimited, boolean isNum) {
        if (i == len) return isNum ? 1 : 0;
        if (!isLimited && isNum && dp[i][mask] >= 0) return dp[i][mask];
        int res = 0;
        // 可以跳过当前数位
        if (!isNum) res = dp(i + 1, mask, false, false);
        int up = isLimited ? d[i] : 9;
        int low = isNum ? 0 : 1;
        // 枚举要填入的数字 j
        for (int j = low; j <= up; j++) {
            if ((mask >> j & 1) == 0) {
                res += dp(i + 1, mask | (1 << j), isLimited && j == up, true);
            }
        }
        // 对不受 n 的约束且前面的数位已经填了数字的情况进行缓存
        if (!isLimited && isNum) dp[i][mask] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
