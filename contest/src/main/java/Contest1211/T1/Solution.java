package Contest1211.T1;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-12-11 10:24
 */
public class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, grid[i][j]);
            }
            res += max;
        }
        return res;
    }
}
