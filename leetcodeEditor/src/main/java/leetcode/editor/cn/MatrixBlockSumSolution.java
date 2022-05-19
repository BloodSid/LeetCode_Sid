package leetcode.editor.cn;

/**
 * 矩阵区域和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-19 16:23:37 
 */
public class MatrixBlockSumSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int p = Math.max(i - k, 0); p <= Math.min(i + k, m - 1); p++) {
                    for (int q = Math.max(j - k, 0); q <= Math.min(j + k, n - 1); q++) {
                        sum += mat[p][q];
                    }
                }
                ans[i][j] = sum;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
