package Contest0211.T1;

/**
 * @author IronSid
 * @since 2024-02-11 10:03
 */
public class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] max = new int[n];
        for (int j = 0; j < n; j++) {
            int mx = -1;
            for (int i = 0; i < m; i++) {
                mx = Math.max(mx, matrix[i][j]);
            }
            max[j] = mx;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = max[j];
                }
            }
        }
        return matrix;
    }
}
