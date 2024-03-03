package Contest0303.T2;

/**
 * @author IronSid
 * @since 2024-03-03 10:34
 */
public class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int t = 0;
            for (int j = 0; j < n; j++) {
                t += grid[i][j];
                int up = i > 0 ? grid[i - 1][j] : 0;
                grid[i][j] = up + t;
                if (grid[i][j] <= k) {
                    res++;
                }
            }
        }
        return res;
    }
}
