package leetcode.editor.cn;

/**
 * 用地毯覆盖后的最少白色砖块
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-20 00:42:20 
 */
public class MinimumWhiteTilesAfterCoveringWithCarpetsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int m = numCarpets, n = floor.length();
        int[][] dp = new int[m + 1][n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (floor.charAt(i) == '1') {
                temp++;
            }
            dp[0][i] = temp;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < carpetLen) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - carpetLen], dp[i][j - 1] + (floor.charAt(j) == '1' ? 1 : 0));
                }
            }
        }
        return dp[m][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
