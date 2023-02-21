package leetcode.editor.cn;
//爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。 
//
// 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。 
//
// 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。 
//
// 游戏一直持续到所有石子都被拿走。 
//
// 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [2,7,9,4,4]
//输出：10
//解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那
//么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
// 
//
// 示例 2: 
//
// 
//输入：piles = [1,2,3,4,5,100]
//输出：104
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 100 
// 1 <= piles[i] <= 10⁴ 
// 
// 👍 152 👎 0


/**
 * 石子游戏 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-02-22 00:35:08 
 */
public class StoneGameIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        // pre[i] 表示 piles 中元素 [0, i) 之和
        int[] pre = new int[n + 1];
        for (int i = 0, t = 0; i < n; i++) {
            pre[i + 1] = t += piles[i];
        }
        // i 表示剩余堆数，m 表示堆数限制，dp(i,m) 表示先手与后手的最大得分差值为多少
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int m = 1; m <= n; m++) {
                int max = Integer.MIN_VALUE;
                // 枚举可以取走的堆数
                for (int x = 1; x <= Math.min(i, 2 * m); x++) {
                    max = Math.max(max, pre[n - i + x] - pre[n - i] - dp[i - x][Math.max(m , x)]);
                }
                dp[i][m] = max;
            }
        }
        return (pre[n] + dp[n][1]) / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
