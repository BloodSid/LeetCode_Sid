package Contest0121.T3;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2023-01-21 22:32
 */
public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        // 根据 nums2 元素逆序排序 idx
        Arrays.sort(idx, (o1, o2) -> nums2[o2] - nums2[o1]);
        // 用小顶堆维护 nums1 的子序列
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> nums1[o1] - nums1[o2]);
        for (int i = 0; i < k; i++) {
            pq.offer(idx[i]);
            sum += nums1[idx[i]];
        }
        // 枚举 nums2 子序列的最小值
        long res = sum * nums2[idx[k - 1]];
        for (int i = k; i < n; i++) {
            int poll = pq.poll();
            sum -= nums1[poll];
            pq.offer(idx[i]);
            sum += nums1[idx[i]];
            res = Math.max(res, sum * nums2[idx[i]]);
        }
        return res;
    }
}
