package leetcode.editor.cn;
//给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。 
//
// 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[7]]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// -99 <= grid[i][j] <= 99 
// 
//
// 👍 172 👎 0


import java.util.*;

/**
 * 下降路径最小和  II
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-08-10 22:55:46 
 */
public class MinimumFallingPathSumIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
            list.add(dp[0][j]);
        }
        for (int i = 1; i < n; i++) {
            List<Integer> t = new ArrayList<>();
            list.sort(Comparator.naturalOrder());
            for (int j = 0; j < n; j++) {
                // 等于最小值，则选次小值
                if (dp[i - 1][j] == list.get(0)) {
                    dp[i][j] = grid[i][j] + list.get(1);
                } else {
                    dp[i][j] = grid[i][j] + list.get(0);
                }
                t.add(dp[i][j]);
            }
            list = t;
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
