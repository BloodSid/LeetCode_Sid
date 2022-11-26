package Contest1126.T2;

/**
 * @author IronSid
 * @since 2022-11-26 22:25
 */
public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] diff = new int[m][n];
        int[] icnt = new int[m];
        int[] jcnt = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                icnt[i] += grid[i][j];
                jcnt[j] += grid[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = 2 * icnt[i] + 2 * jcnt[j] - m - n;
            }
        }
        return diff;
    }
}
