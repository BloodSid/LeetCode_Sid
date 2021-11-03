package leetcode.editor.cn;

import java.util.*;

/**
 * 接雨水 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-03 12:17:13
 */
public class TrappingRainWaterIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, heightMap[i][j]);
                dp[i][j] = max;
            }
            max = 0;
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max, heightMap[i][j]);
                dp[i][j] = Math.min(max, dp[i][j]);
            }
            max = 0;
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                max = Math.max(max, heightMap[i][j]);
                dp[i][j] = Math.min(max, dp[i][j]);
            }
            max = 0;
            for (int i = m - 1; i >= 0; i--) {
                max = Math.max(max, heightMap[i][j]);
                dp[i][j] = Math.min(max, dp[i][j]);
            }
            max = 0;
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += dp[i][j] - heightMap[i][j];
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
