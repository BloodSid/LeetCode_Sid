package Contest0108.T2;

import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2023-01-08 10:29
 */
public class Solution {
    public long maxKelements(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            int poll = pq.poll();
            res += poll;
            pq.offer((poll + 2) / 3);
        }
        return res;
    }
}
