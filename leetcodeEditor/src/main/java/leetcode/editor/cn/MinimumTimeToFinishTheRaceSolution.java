package leetcode.editor.cn;

import java.util.*;

/**
 * 完成比赛的最少时间
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-27 17:02:44
 */
public class MinimumTimeToFinishTheRaceSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        // 只用一种轮胎跑 i 圈的最小时间
        int[] dp = new int[numLaps + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 根据题意，一个轮胎连续使用一定圈数后，一定不如换新轮胎，这个圈数为：
        int MAX_REPEAT = 0;
        for (int[] tire : tires) {
            long lapTime = tire[0], total = 0;
            // 若继续跑一圈的时间大于换新胎跑一圈的时间，则停止计算
            for (int i = 1; lapTime <= tire[0] + changeTime && i <= numLaps; i++) {
                total += lapTime;
                dp[i] = (int) Math.min(dp[i], total);
                lapTime *= tire[1];
                MAX_REPEAT = Math.max(MAX_REPEAT, i);
            }
        }
        for (int i = 2; i <= numLaps; i++) {
            for (int j = 1; j <= MAX_REPEAT && j < i; j++) {
                // 由于当连续使用MAX_REPEAT圈后一定会换新胎，所以j大于MAX_REPEAT的情况不考虑
                // 由于缩小了j的范围，也就缩小了时间复杂度
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j] + changeTime);
            }
        }
        return dp[numLaps];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
