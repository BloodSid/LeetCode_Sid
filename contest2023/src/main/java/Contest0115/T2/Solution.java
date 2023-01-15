package Contest0115.T2;

/**
 * @author IronSid
 * @since 2023-01-15 10:20
 */
public class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // diff[i] 表示 第 i 行的差分数组
        int[][] diff = new int[n][n];
        for (int[] q : queries) {
            for (int i = q[0]; i <= q[2]; i++) {
                diff[i][q[1]]++;
                if (q[3] + 1 < n) diff[i][q[3] + 1]--;
            }
        }
        for (int[] d : diff) {
            for (int i = 0, t = 0; i < d.length; i++) {
                t += d[i];
                d[i] = t;
            }
        }
        return diff;
    }
}
