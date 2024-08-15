package leetcode.editor.cn;
//给你一个由 正整数 组成、大小为 m x n 的矩阵 grid。你可以从矩阵中的任一单元格移动到另一个位于正下方或正右侧的任意单元格（不必相邻）。从值为 
//c1 的单元格移动到值为 c2 的单元格的得分为 c2 - c1 。 
//
// 你可以从 任一 单元格开始，并且必须至少移动一次。 
//
// 返回你能得到的 最大 总得分。 
//
// 
//
// 示例 1： 
// 
// 
// 输入：grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]] 
// 
//
// 输出：9 
//
// 解释：从单元格 (0, 1) 开始，并执行以下移动： - 从单元格 (0, 1) 移动到 (2, 1)，得分为 7 - 5 = 2 。 - 从单元格 (2
//, 1) 移动到 (2, 2)，得分为 14 - 7 = 7 。 总得分为 2 + 7 = 9 。 
//
// 示例 2： 
//
// 
//
// 
// 输入：grid = [[4,3,2],[3,2,1]] 
// 
//
// 输出：-1 
//
// 解释：从单元格 (0, 0) 开始，执行一次移动：从 (0, 0) 到 (0, 1) 。得分为 3 - 4 = -1 。 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 1000 
// 4 <= m * n <= 10⁵ 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// 👍 42 👎 0


import java.util.*;

/**
 * 矩阵中的最大得分
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-08-15 18:43:21 
 */
public class MaximumDifferenceScoreInAGridSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int ans = Integer.MIN_VALUE;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                int old = grid.get(i).get(j);
                int max = 0;
                if (i != m - 1) {
                    max = Math.max(max, grid.get(i+1).get(j));
                }
                if (j != n - 1) {
                    max = Math.max(max, grid.get(i).get(j+1));
                }
                ans = Math.max(ans, max - old);
                grid.get(i).set(j, Math.max(max, old));
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
