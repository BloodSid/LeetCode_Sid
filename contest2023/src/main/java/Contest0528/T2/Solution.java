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
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                HashSet<Integer> s1 = new HashSet<>();
                for (int i1 = i - 1, j1 = j - 1; i1 >= 0 && j1 >= 0; i1--, j1--) {
                    s1.add(grid[i1][j1]);
                }
                HashSet<Integer> s2 = new HashSet<>();
                for (int i1 = i + 1, j1 = j + 1; i1 < m && j1 < n; i1++, j1++) {
                    s2.add(grid[i1][j1]);
                }
                ans[i][j] = Math.abs(s1.size() - s2.size());
            }
        }
        return ans;
    }
}
