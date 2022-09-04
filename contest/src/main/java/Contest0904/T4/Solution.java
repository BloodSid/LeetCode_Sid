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
        for (int[] meeting : meetings) {
            long cur = meeting[0], end = meeting[1];
            if (empty.isEmpty()) {
                int poll = pq.poll();
                end = last[poll] + end - cur;
                cur = last[poll];
                empty.add(poll);
            }
            int first = empty.first();
            empty.remove(first);
            cnt[first]++;
            last[first] = end;
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
