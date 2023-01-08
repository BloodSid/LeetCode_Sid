package Contest0108.T4;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2023-01-08 10:29
 */
public class Solution {

    private static final int INF = Integer.MAX_VALUE;

    public int findCrossingTime(int n, int k, int[][] time) {
        // 稳定排序。所以排序后数组按过桥时间递增，时间相同按原来的下标递增，所以效率由高到低排序
        Arrays.sort(time, (o1, o2) -> o1[0] + o1[2] - o2[0] - o2[2]);
        // 存储 idx, 记录两侧等待过桥的工人，idx大，效率低的优先
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) left.offer(i);
        // {idx, time} 记录到达桥边时间
        PriorityQueue<int[]> la = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<int[]> ra = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int now = 0;
        for (int moved = 0; moved < n; ) {
            // 如果没有人正在等过桥
            if (right.isEmpty() && left.isEmpty()) {
                now = Math.min(ra.isEmpty() ? INF : ra.peek()[1], la.isEmpty() ? INF : la.peek()[1]);
            }
            while (!ra.isEmpty() && ra.peek()[1] <= now) right.add(ra.poll()[0]);
            while (!la.isEmpty() && la.peek()[1] <= now) left.add(la.poll()[0]);
            if (!right.isEmpty()) {
                // 右边的工人先过桥
                int poll = right.poll();
                int rtl = time[poll][2], pn = time[poll][3];
                now += rtl;
                la.add(new int[]{poll, now + pn});
            } else {
                // 右边没有等待的过桥的工人时，左边的工人可以过桥
                int poll = left.poll();
                int ltr = time[poll][0], po = time[poll][1];
                now += ltr;
                moved++;
                ra.add(new int[]{poll, now + po});
            }
        }
        // 前面的循环结束时，最后肯定是左边的一个工人过桥，所以right 必为空。则处理ra中的所有工人回到左边的时间可得结果
        while (!ra.isEmpty()) {
            int[] poll = ra.poll();
            now = Math.max(now, poll[1]) + time[poll[0]][2];
        }
        return now;
    }
}
