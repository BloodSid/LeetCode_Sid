package leetcode.editor.cn;
//有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。 
//
// 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。 
//
// 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：stones = [3,2,4,1], K = 2
//输出：20
//解释：
//从 [3, 2, 4, 1] 开始。
//合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
//合并 [4, 1]，成本为 5，剩下 [5, 5]。
//合并 [5, 5]，成本为 10，剩下 [10]。
//总成本 20，这是可能的最小值。
// 
//
// 示例 2： 
//
// 输入：stones = [3,2,4,1], K = 3
//输出：-1
//解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
// 
//
// 示例 3： 
//
// 输入：stones = [3,5,1,2,6], K = 3
//输出：25
//解释：
//从 [3, 5, 1, 2, 6] 开始。
//合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
//合并 [3, 8, 6]，成本为 17，剩下 [17]。
//总成本 25，这是可能的最小值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 2 <= K <= 30 
// 1 <= stones[i] <= 100 
// 
//
// 👍 344 👎 0


/**
 * 合并石头的最低成本
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-08 16:05:07 
 */
public class MinimumCostToMergeStonesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        int[] pre = new int[n + 1];
        for (int i = 0, t = 0; i < n; i++) {
            t += stones[i];
            pre[i + 1] = t;
        }
        int[][] f = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int res = Integer.MAX_VALUE;
                for (int m = i; m < j; m += k - 1) {
                    res = Math.min(res, f[i][m] + f[m + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    res += pre[j + 1] - pre[i];
                }
                f[i][j] = res;
            }
        }
        return f[0][n - 1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
