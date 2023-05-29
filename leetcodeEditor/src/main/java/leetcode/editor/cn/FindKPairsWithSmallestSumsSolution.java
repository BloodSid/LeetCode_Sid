package leetcode.editor.cn;

import java.util.*;

/**
 * 查找和最小的 K 对数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-14 11:27:13
 */
public class FindKPairsWithSmallestSumsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int size = (int) Math.min((long) len1 * len2, k);
        List<List<Integer>> ans = new ArrayList<>(size);
        // {i1, i2, sum}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.offer(new int[]{0, 0, nums1[0] + nums2[0]});
        for (int i = 0; i < size; i++) {
            int[] p = pq.poll();
            int i1 = p[0], i2 = p[1];
            ans.add(Arrays.asList(nums1[i1], nums2[i2]));
            // 通过规定顺序避免重复访问
            if (i1 == 0 && i2 < len2 - 1) {
                pq.offer(new int[]{i1, i2 + 1, nums1[i1] + nums2[i2 + 1]});
            }
            if (i1 < len1 - 1) {
                pq.offer(new int[]{i1 + 1, i2, nums1[i1 + 1] + nums2[i2]});
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
