package leetcode.editor.cn;
//给定 m x n 矩阵 matrix 。 
//
// 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。） 
//
// 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[0,1],[1,1]]
//输出：1
//解释：不进行翻转，有 1 行所有值都相等。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1],[1,0]]
//输出：2
//解释：翻转第一列的值之后，这两行都由相等的值组成。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
//输出：2
//解释：翻转前两列的值之后，后两行由相等的值组成。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] == 0 或 1 
// 
//
// 👍 65 👎 0


/**
 * 按列翻转得到最大值等行数
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-11 14:10:12 
 */
public class FlipColumnsForMaximumNumberOfEqualRowsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 枚举行，计算在把某行变为相等的翻转方法下，矩阵有多少行的所有值都相等
        int max = 1;
        for (int k = 0; k < m; k++) {
            // f[j] 为0不反转，为1反转
            int[] f = matrix[k];
            int cnt = 1;
            for (int i = 0; i < m; i++) {
                if (i == k) continue;
                int j = 1;
                int start = matrix[i][0] ^ f[0];
                for (; j < n; j++) {
                    if ((matrix[i][j] ^ f[j]) != start) {
                        break;
                    }
                }
                // 所有的值都一致
                if (j == n) cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
