package Contest0115.T2;

/**
 * @author IronSid
 * @since 2023-01-15 10:20
 */
public class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // diff 二维差分数组
        int[][] diff = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2] + 1, c2 = q[3] + 1;
            diff[r1][c1]++;
            if (c2 < n) diff[r1][c2]--;
            if (r2 < n) diff[r2][c1]--;
            if (r2 < n && c2 < n) diff[r2][c2]++;
        }
        // 原地修改求前缀和
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = 0, left = 0, upLeft = 0;
                if (i > 0) up = diff[i - 1][j];
                if (j > 0) left = diff[i][j - 1];
                if (i > 0 && j > 0) upLeft = diff[i - 1][j - 1];
                diff[i][j] = up + left - upLeft + diff[i][j];
            }
        }
        return diff;
    }
}
