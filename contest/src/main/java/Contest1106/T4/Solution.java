package Contest1106.T4;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-11-06 10:10
 */
public class Solution {
    public long minimumTotalDistance(List<Integer> robotList, int[][] factory) {
        int m = robotList.size();
        int[] robot = new int[m];
        for (int i = 0; i < m; i++) {
            robot[i] = robotList.get(i);
        }
        int n = factory.length;
        // pq 存 i, j 对
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> Math.abs(robot[p[0]] - factory[p[1]][0])));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(new int[]{i, j});
            }
        }
        // 记录已经安排的 robot
        HashSet<Integer> set = new HashSet<>();
        // 贪心
        long tot = 0L;
        while (set.size() < m) {
            int[] poll;
            for (; ; ) {
                poll = pq.poll();
                // 若机器人没安排且工厂有余量，跳出
                if (!set.contains(poll[0]) && factory[poll[1]][1] > 0) {
                    break;
                }
            }
            tot += Math.abs(robot[poll[0]] - factory[poll[1]][0]);
            set.add(poll[0]);
            factory[poll[1]][1]--;
        }
        return tot;
    }
}
