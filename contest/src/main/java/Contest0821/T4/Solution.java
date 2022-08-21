package Contest0821.T4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2022-08-21 9:54
 */
public class Solution {
    public long kSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong((long[] o) -> o[0]).reversed());
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                break;
            }
            sum += nums[i];
            pq.offer(new long[]{sum, i});
        }
        pq.offer(new long[]{-1, 0});
        long[] poll = null;
        for (int i = 0; i < k; i++) {
            poll = pq.poll();
            long s = poll[0], idx = poll[1];
            if (idx < n - 1) {
                pq.add(new long[]{s - nums[(int) idx] + nums[(int) (idx + 1)], idx + 1});
            }
            if (idx < n - 1 && nums[(int) (idx + 1)] <= 0) {
                pq.add(new long[]{s + nums[(int) (idx + 1)], idx + 1});
            }
            System.out.println("i = " + i);
            System.out.println("poll[0] = " + poll[0]);
            System.out.println(Arrays.toString(poll));
        }
        return poll[0];
    }
}
