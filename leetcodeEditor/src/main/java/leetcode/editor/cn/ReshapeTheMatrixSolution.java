package leetcode.editor.cn;

import java.util.*;

/**
 * 重塑矩阵
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-30 20:16:15
 */
public class ReshapeTheMatrixSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            result[i / c][i % c] = mat[i / n][i % n];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
