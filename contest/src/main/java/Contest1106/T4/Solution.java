package Contest1106.T4;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-11-06 10:10
 */
public class Solution {

    public static final long INF = (long) 1e18;

    public long minimumTotalDistance(List<Integer> robotList, int[][] factory) {
        // 设最小安排时，机器人 i 安排给工厂 fi, 根据贪心，必存在一种最优的分法，fi 不严格单调增
        int m = factory.length;
        int n = robotList.size();
        // 排序
        int[] robot = new int[n];
        for (int i = 0; i < n; i++) robot[i] = robotList.get(i);
        Arrays.sort(robot);
        Arrays.sort(factory, (o1, o2) -> o1[0] - o2[0]);
        // dp[i][j] 表示给 [0,i) 的工厂 和 [0,j) 的机器人找到的最小安排, i = 0 且 j != 0 时 dp 为无限大，j = 0 时 dp 为 0
        long[][] dp = new long[m + 1][n + 1];
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            int pos = factory[i - 1][0];
            int limit = factory[i - 1][1];
            for (int j = 1; j <= n; j++) {
                // 这个工厂处理 0 个机器人
                long t = dp[i - 1][j];
                long cost = 0;
                /* dp[i][j] = dp[i-1][j-k] + cost(i,j,k) 枚举 k, 结果取最小值。cost(i,j,k)表示从 j 往前的 k 个机器人到
                工厂 i 的距离 */
                for (int k = 1; k <= Math.min(j, limit); k++) {
                    cost += Math.abs(robot[j - k] - pos);
                    t = Math.min(t, dp[i - 1][j - k] + cost);
                }
                dp[i][j] = t;
            }
        }
        return dp[m][n];
    }
}
