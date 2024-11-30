package leetcode.editor.cn;
//给你一个 m x n 的二进制矩阵 grid 。 
//
// 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。 
//
// 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。 
//
// 请你返回 最少 翻转次数，使得矩阵中 所有 行和列都是 回文的 ，且矩阵中 1 的数目可以被 4 整除 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：grid = [[1,0,0],[0,1,0],[0,0,1]] 
// 
//
// 输出：3 
//
// 解释： 
//
// 
//
// 示例 2： 
//
// 
// 输入：grid = [[0,1],[0,1],[0,0]] 
// 
//
// 输出：2 
//
// 解释： 
//
// 
//
// 示例 3： 
//
// 
// 输入：grid = [[1],[1]] 
// 
//
// 输出：2 
//
// 解释： 
//
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m * n <= 2 * 10⁵ 
// 0 <= grid[i][j] <= 1 
// 
//
// 👍 43 👎 0


/**
 * 最少翻转次数使二进制矩阵回文 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-11-30 18:14:44 
 */
public class MinimumNumberOfFlipsToMakeBinaryGridPalindromicIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFlips(int[][] grid) {
        // 题意可理解为把g变为D2群的图形
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        int axis = 0; // 轴线上，对称的1的个数
        int noEqual = 0; // 轴线对称位置上不相等的组数
        for (int i1 = 0; i1 < (m + 1) / 2; i1++) {
            int i2 = m - 1 - i1;
            for (int j1 = 0; j1 < (n + 1) / 2; j1++) {
                int j2 = n - 1 - j1;
                if (j1 == j2 && i1 == i2) {
                    cnt += grid[i1][j1];
                } else if (i1 == i2) {
                    int s = grid[i1][j1] ^ grid[i1][j2];
                    cnt += s;
                    noEqual += s;
                    if (s == 0 && grid[i1][j1] == 1) axis += 2;
                } else if (j1 == j2) {
                    int s = grid[i1][j1] ^ grid[i2][j1];
                    cnt += s;
                    noEqual += s;
                    if (s == 0 && grid[i1][j1] == 1) axis += 2;
                } else {
                    int t = grid[i1][j1] + grid[i1][j2] + grid[i2][j1] + grid[i2][j2];
                    cnt += Math.min(t, 4 - t);
                }
            }
        }
        // 如果轴线上1的个数不被4整除，且不存在非回文的位置调整余数，就得把一对已经回文的位置转化。（10可以变成11或者00，以把1个数的余数从2调整为0）
        if (axis % 4 != 0 && noEqual == 0) cnt += 2;
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
