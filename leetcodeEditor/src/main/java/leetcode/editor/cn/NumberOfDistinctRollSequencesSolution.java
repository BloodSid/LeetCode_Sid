package leetcode.editor.cn;
//给你一个整数 n 。你需要掷一个 6 面的骰子 n 次。请你在满足以下要求的前提下，求出 不同 骰子序列的数目： 
//
// 
// 序列中任意 相邻 数字的 最大公约数 为 1 。 
// 序列中 相等 的值之间，至少有 2 个其他值的数字。正式地，如果第 i 次掷骰子的值 等于 第 j 次的值，那么 abs(i - j) > 2 。 
// 
//
// 请你返回不同序列的 总数目 。由于答案可能很大，请你将答案对 10⁹ + 7 取余 后返回。 
//
// 如果两个序列中至少有一个元素不同，那么它们被视为不同的序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：184
//解释：一些可行的序列为 (1, 2, 3, 4) ，(6, 1, 2, 3) ，(1, 2, 3, 1) 等等。
//一些不可行的序列为 (1, 2, 1, 3) ，(1, 2, 3, 6) 。
//(1, 2, 1, 3) 是不可行的，因为第一个和第三个骰子值相等且 abs(1 - 3) = 2 （下标从 1 开始表示）。
//(1, 2, 3, 6) i是不可行的，因为 3 和 6 的最大公约数是 3 。
//总共有 184 个不同的可行序列，所以我们返回 184 。 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：22
//解释：一些可行的序列为 (1, 2) ，(2, 1) ，(3, 2) 。
//一些不可行的序列为 (3, 6) ，(2, 4) ，因为最大公约数不为 1 。
//总共有 22 个不同的可行序列，所以我们返回 22 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// 👍 8 👎 0


/**
 * 不同骰子序列的数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-27 18:54:09 
 */
public class NumberOfDistinctRollSequencesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int MOD = (int) (1e9 + 7);

    public int distinctSequences(int n) {
        int[][] gcd = new int[6 + 1][6 + 1];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                gcd[i][j] = gcd(i, j);
            }
        }
        long[][] dp = new long[6 + 1][n];
        for (int i = 1; i <= 6; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 6; j++) {
                long t = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j == k || gcd[j][k] != 1) continue;
                    t += dp[k][i - 1] - (i < 2 ? 0 : dp[j][i - 2]);
                }
                // 鸽笼原理：dp[k][i - 1] 中已经把 dp[k][i - 3] 去掉了，但是 dp[j][i - 2] 中这些序列还在
                // 所以上面的减法减重复了，把重复的部分再加回来，所有的 k 对应的重复部分 dp[k][i - 3] 之和正是 dp[j][i - 2]
                if (i >= 3) t += dp[j][i - 2];
                // 有可能是负数
                dp[j][i] = (t % MOD + MOD) % MOD;
            }
        }
        long res = 0;
        for (int i = 1; i <= 6; i++) {
            res += dp[i][n - 1];
        }
        return (int) (res % MOD);
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
