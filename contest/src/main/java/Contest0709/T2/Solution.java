package Contest0709.T2;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-07-09 22:21
 */
class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int n = buses.length;
        int m = passengers.length;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int p1 = 0, p2 = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int last = 0;
        while (p1 < n) {
            if (p2 < m && passengers[p2] <= buses[p1]) {
                q.offer(passengers[p2]);
                p2++;
            } else {
                int i;
                for (i = 0; i < capacity; i++) {
                    if (q.isEmpty()) break;
                    last = q.poll();
                }
                if (i < capacity) last = buses[p1];
                p1++;
            }
        }
        int idx = Arrays.binarySearch(passengers, last);
        // 无重复时间 则直接返回 last
        if (idx < 0) return last;
        for (int i = idx - 1; i >= 0; i--) {
            if (passengers[i] < passengers[i + 1] - 1) return passengers[i + 1] - 1;
        }
        return passengers[0] - 1;
    }
}
