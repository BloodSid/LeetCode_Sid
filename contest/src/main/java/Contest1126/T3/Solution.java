package Contest1126.T3;

/**
 * @author IronSid
 * @since 2022-11-26 22:25
 */
public class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] pre = new int[n + 1];
        for (int i = 0, t = 0; i < n; i++) {
            t += customers.charAt(i) == 'Y' ? 1 : 0;
            pre[i + 1] = t;
        }
        int minCost = Integer.MAX_VALUE;
        // 代价最小的最早关门时间
        int minT = 0;
        for (int i = 0; i <= n; i++) {
            int cost = i - pre[i] + (pre[n] - pre[i]);
            if (cost < minCost) {
                minT = i;
                minCost = cost;
            }
        }
        return minT;
    }
}
