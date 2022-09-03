package Contest0903.T4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2022-09-03 22:33
 */
public class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int max = 0;
        // 用堆维护最大值
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator
                .comparingInt((Integer i) -> chargeTimes[i]).reversed());
        long sum = 0;
        // 滑动窗口
        for (int i = 0, j = 0; j <= n;) {
            long cost = (pq.isEmpty() ? 0 : chargeTimes[pq.peek()]) + (j - i) * sum;
            if (cost > budget && i <= j) {
                sum -= runningCosts[i];
                pq.remove(i);
                i++;
            } else {
                max = Math.max(max, j - i);
                if (j == n) break;
                sum += runningCosts[j];
                pq.offer(j);
                j++;
            }
        }
        return max;
    }
}
