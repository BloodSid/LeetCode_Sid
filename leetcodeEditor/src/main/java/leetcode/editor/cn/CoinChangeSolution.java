package leetcode.editor.cn;
//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// 👍 1973 👎 0


import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-09 23:53:17
 */
public class CoinChangeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        int inf = amount + 1;
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 从小到大遍历 coin
            for (int coin : coins) {
                if (coin > i) break;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount] == inf) return -1;
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
