package Contest0903.T3;

/**
 * @author IronSid
 * @since 2022-09-03 22:33
 */
public class Solution {
    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length;
        int n = mat[0].length;
        int max = 0;
        for (int status = 0; status < 1 << n; status++) {
            if (Integer.bitCount(status) != cols) continue;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                int j;
                for (j = 0; j < n; j++) {
                    if (mat[i][j] == 1 && (status >> j & 1) == 0) break;
                }
                if (j == n) cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
