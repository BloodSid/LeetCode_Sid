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


import java.util.Arrays;
import java.util.HashMap;

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
        // long 类型
        int width = 64;
        int mask = width - 1;
        int offset = 6;
        int m = matrix.length, n = matrix[0].length;
        // 需要k个long存放
        int k = (n + 64 - 1) >> offset;
        long[][] bits = new long[m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bits[i][j >> offset] |= (long) matrix[i][j] << (j & mask);
            }
            // 若一行以1起，则翻转整行
            if (matrix[i][0] == 1) {
                for (int j = 0; j < k; j++) {
                    bits[i][j] = ~bits[i][j];
                }
                // 多余的 bits
                int tail = (64 - n & mask) & mask;
                bits[i][k - 1] = bits[i][k - 1] << tail >>> tail;
            }

        }

        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (long[] bs : bits) {
            String s = Arrays.toString(bs);
            int v = map.getOrDefault(s, 0) + 1;
            max = Math.max(max, v);
            map.put(s, v);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
