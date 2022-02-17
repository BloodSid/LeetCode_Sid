package leetcode.editor.cn;

/**
 * 骑士在棋盘上的概率
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-17 00:17:01
 */
public class KnightProbabilityInChessboardSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][] curr = new double[n][n];
        double[][] next = new double[n][n];
        curr[row][column] = 1;
        for (int i1 = 0; i1 < k; i1++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double sum = 0;
                    for (int[] dir : dirs) {
                        int nRow = i + dir[0];
                        int nCol = j + dir[1];
                        if (nRow < 0 || nRow >= n || nCol < 0 || nCol >= n) {
                            continue;
                        }
                        sum += curr[nRow][nCol];
                    }
                    next[i][j] = sum / 8.0;
                }
            }
            double[][] temp = curr;
            curr = next;
            next = temp;
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += curr[i][j];
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
