package leetcode.editor.cn;

import java.util.*;

/**
 * n个骰子的点数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-24 13:27:58
 */
public class NgeTouZiDeDianShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability(int n) {
        int FACES = 6;
        double prob = 1.0 / FACES;
        double[][] dp = new double[n][];
        dp[0] = new double[FACES];
        Arrays.fill(dp[0], prob);
        for (int i = 1; i < n; i++) {
            dp[i] = new double[FACES * (i + 1) - (i + 1) + 1];
            for (int j = 0; j < dp[i].length; j++) {
                double sum = 0.0;
                for (int k = 0; k < 6; k++) {
                    if (j - k >= 0 && j - k < dp[i - 1].length) {
                        sum += dp[i - 1][j - k];
                    }
                }
                dp[i][j] = sum * prob;
            }
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
