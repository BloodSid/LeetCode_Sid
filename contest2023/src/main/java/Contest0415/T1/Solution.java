package Contest0415.T1;

/**
 * @author IronSid
 * @since 2023-04-15 22:30
 */
public class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < grid.length; i++) {
                res[j] = Math.max(res[j], Integer.toString(grid[i][j]).length());
            }
        }
        return res;
    }
}
