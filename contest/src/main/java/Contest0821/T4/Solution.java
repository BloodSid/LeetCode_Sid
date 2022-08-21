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
        long neg = 0;
        long sum = 0;
        int n = nums.length;
        // 负数转化为相反数，使数组中全都是正数
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (nums[i] < 0) {
                neg += nums[i];
                nums[i] = -nums[i];
            }
        }
        // 排序
        Arrays.sort(nums);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong((long[] o) -> o[0]));
        pq.offer(new long[]{nums[0], 0});
        // 求最大的第k个 = 求最小的第k个，然后求它的补集
        // k = 1 时的答案，也就是空集的补集
        long res = sum - neg;
        for (int i = 0; i < k - 1; i++) {
            long[] poll = pq.poll();
            // 求得集合 S, 一个负数的相反数若在集合 S 里，则这个负数不在答案集合里；
            // 若负数的相反数不在集合 S 里，则这个负数在答案集合里，
            // 也就是 sum(S) + neg 可得对应的答案集合，再求补集，最大的第k个子序列
            res = sum - (poll[0] + neg);
            // 不重不漏地生成所有子序列。每次放进去的数不小于拿出来的数。
            if (poll[1] == n - 1) continue;
            int j = (int) poll[1];
            pq.offer(new long[]{poll[0] + nums[j + 1], j + 1});
            pq.offer(new long[]{poll[0] - nums[j] + nums[j + 1], j + 1});
        }
        return res;
    }
}
