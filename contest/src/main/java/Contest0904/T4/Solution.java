package Contest0904.T4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author IronSid
 * @since 2022-09-04 10:28
 */
public class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] cnt = new int[n];
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));
        // 上一场会议的结束时间
        long[] last = new long[n];
        // 被占用的会议室
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingLong(i -> last[i]));
        // 空闲会议室
        TreeSet<Integer> empty = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            empty.add(i);
        }
        long cur = 0;
        for (int[] meeting : meetings) {
            cur = Math.max(cur, meeting[0]);
            // 若没有空会议室
            if (empty.isEmpty()) cur = Math.max(cur, last[pq.peek()]);
            // 用当前时间更新会议室状态
            while (!pq.isEmpty() && last[pq.peek()] <= cur) empty.add(pq.poll());
            int first = empty.first();
            empty.remove(first);
            last[first] = cur + meeting[1] - meeting[0];
            pq.offer(first);
            cnt[first]++;
        }
        int res = 0, max = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                res = i;
            }
        }
        return res;
    }
}
