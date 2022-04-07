package leetcode.editor.cn;

/**
 * 二维区域和检索 - 矩阵不可变
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-07 21:39:06
 */
public class RangeSumQuery2dImmutableSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

    private final int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int temp = 0;
            int[] line = matrix[i];
            for (int j = 0; j < n; j++) {
                temp += line[j];
                preSum[i + 1][j + 1] = preSum[i][j + 1] + temp;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
