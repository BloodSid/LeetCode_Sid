package Contest0416.T1;

/**
 * @author IronSid
 * @since 2023-04-16 10:30
 */
public class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        // {idx, max}
        int[] res = new int[2];
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                cnt += mat[i][j];
            }
            if (cnt > res[1]) {
                res[1] = cnt;
                res[0] = i;
            }
        }
        return res;
    }
}