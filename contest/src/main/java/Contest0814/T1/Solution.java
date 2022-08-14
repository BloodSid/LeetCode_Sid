package Contest0814.T1;

/**
 * @author IronSid
 * @since 2022-08-14 10:23
 */
public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int t = 0;
                for (int di = 0; di < 3; di++) {
                    for (int dj = 0; dj < 3; dj++) {
                        t = Math.max(t, grid[i + di][j + dj]);
                    }
                }
                ans[i][j] = t;
            }
        }
        return ans;
    }
}
