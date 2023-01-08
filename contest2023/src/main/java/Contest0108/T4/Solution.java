package Contest0108.T4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2023-01-08 10:29
 */
public class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        int[][] t = new int[k][];
        for (int i = 0; i < time.length; i++) {
            t[i] = new int[5];
            t[i][0] = i;
            System.arraycopy(time[i], 0, t[i], 1, 4);
        }
        // 两边的等待队列
        Comparator<int[]> comparator = (o1, o2) -> o1[1] + o1[3] != o2[1] + o2[3] ? o2[1] + o2[3] - o1[1] - o1[3] : o2[0] - o1[0];
        PriorityQueue<int[]> left = new PriorityQueue<>(comparator);
        PriorityQueue<int[]> right = new PriorityQueue<>(comparator);
        for (int[] ints : t) {
            left.add(ints);
        }
        int last = 0;
        // {idx, time} 记录到达桥边时间
        PriorityQueue<int[]> la = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<int[]> ra = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int now = 0;
        for (int i = 0; i < n; i++) {
            while (!ra.isEmpty() && ra.peek()[1] <= now) right.add(t[ra.poll()[0]]);
            while (!right.isEmpty()) {
                // 右边的工人先过桥
                int[] poll = right.poll();
                int idx = poll[0], rtl = poll[3], pn = poll[4];
                now += rtl;
                last = now;
                la.add(new int[]{idx, now + pn});
            }
            // 左边没有工人，则需要右边的工人先回来
            if (left.isEmpty() && la.isEmpty()) {
                now = ra.peek()[1];
            }
            while (!ra.isEmpty() && ra.peek()[1] <= now) right.add(t[ra.poll()[0]]);
            while (!right.isEmpty()) {
                // 右边的工人先过桥
                int[] poll = right.poll();
                int idx = poll[0], rtl = poll[3], pn = poll[4];
                now += rtl;
                last = now;
                la.add(new int[]{idx, now + pn});
            }
            // 右边没有等待的过桥的工人时，左边的工人可以过桥
            if (left.isEmpty()) {
                // 左边没有等待的工人
                now = la.peek()[1];
            }
            while (!la.isEmpty() && la.peek()[1] <= now) left.add(t[la.poll()[0]]);
            // 选出左边效率最低的人过桥
            int[] poll = left.poll();
            int idx = poll[0], ltr = poll[1], po = poll[2];
            now += ltr;
            ra.add(new int[]{idx, now + po});
        }
        // 右边剩下的全返回左边
        while (!right.isEmpty() || !ra.isEmpty()) {
            if (right.isEmpty()) now = ra.peek()[1];
            while (!ra.isEmpty() && ra.peek()[1] <= now) right.add(t[ra.poll()[0]]);
            int[] poll = right.poll();
            int rtl = poll[3];
            now += rtl;
            last = now;
        }
        return last;
    }
}
