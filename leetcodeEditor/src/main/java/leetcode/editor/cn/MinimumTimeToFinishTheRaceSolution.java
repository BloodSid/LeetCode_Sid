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
        // tire = {f, r}, f从小到大排序，若f相同，则按r从小到大排序
        Arrays.sort(tires, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        // 若一个tire的f和r都大于等于另外一个tire的f和r，则不考虑这个tire
        int minR = Integer.MAX_VALUE;
        List<int[]> tireList = new ArrayList<>();
        for (int[] tire : tires) {
            if (tire[1] < minR) {
                minR = tire[1];
                tireList.add(tire);
            }
        }
        // 只用一种轮胎跑 i 圈的最小时间
        int[] dp = new int[numLaps + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 根据题意，一个轮胎连续使用一定圈数后，一定不如换新轮胎，这个圈数为：
        int MAX_REPEAT = 0;
        for (int[] tire : tireList) {
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
