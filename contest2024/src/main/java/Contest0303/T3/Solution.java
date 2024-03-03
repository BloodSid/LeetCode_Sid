package Contest0303.T3;

/**
 * @author IronSid
 * @since 2024-03-03 10:35
 */
public class Solution {
    private int[][] grid;
    private int n;

    public int minimumOperationsToWriteY(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        int N = 3;
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                mn = Math.min(mn, count(i, j));
            }
        }
        return mn;
    }

    private int count(int y, int ny) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i < n / 2 && (i == j || i + j == n - 1)) || (i >= n / 2 && j == n / 2)) {
                    if (grid[i][j] != y) {
                        res++;
                    }
                } else {
                    if (grid[i][j] != ny) res++;
                }
            }
        }
        return res;
    }
}
