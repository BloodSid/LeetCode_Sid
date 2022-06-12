package leetcode.editor.cn;
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// 👍 1165 👎 0


/**
 * 最大正方形
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-09 23:51:08
 */
public class MaximalSquareSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 从上往下的长度
        int[][] dp0 = new int[m][n];
        // 左上角的正方形的边长
        int[][] dp2 = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp0[0][i] = matrix[0][i] - '0';
            dp2[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') dp0[i][j] = 0;
                else dp0[i][j] = dp0[i - 1][j] + 1;
            }
        }
        // 从左往右的长度
        int[][] dp1 = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp1[i][0] = matrix[i][0] - '0';
            dp2[i][0] = matrix[i][0] - '0';
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') dp1[i][j] = 0;
                else dp1[i][j] = dp1[i][j - 1] + 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp2[i][j] = Math.min(Math.min(dp0[i - 1][j], dp1[i][j - 1]), dp2[i - 1][j - 1]) + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp2[i][j]);
            }
        }
        return max * max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
