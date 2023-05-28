package Contest0528.T2;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2023-05-28 10:29
 */
public class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] tl = new int[m][n], br = new int[m][n];
        for (int k = 0; k < m + n - 1; k++) {
            int i = Math.max(0, k - n + 1), j = Math.max(0, n - k - 1);
            HashSet<Integer> set = new HashSet<>();
            for (; i < m && j < n; i++, j++) {
                tl[i][j] = set.size();
                set.add(grid[i][j]);
            }
        }
        for (int k = 0; k < m + n - 1; k++) {
            HashSet<Integer> set = new HashSet<>();
            int i = Math.min(m - 1, k), j = Math.min(n - 1, m + n - 2 - k);
            for (; i >= 0 && j >= 0; i--, j--) {
                br[i][j] = set.size();
                set.add(grid[i][j]);
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = Math.abs(tl[i][j] - br[i][j]);
            }
        }
        return ans;
    }
}
