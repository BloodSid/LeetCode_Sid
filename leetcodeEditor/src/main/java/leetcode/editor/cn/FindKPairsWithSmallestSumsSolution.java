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
    boolean reverse = false;

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            reverse = true;
            return kSmallestPairs(nums2, nums1, k);
        }
        List<List<Integer>> ans = new ArrayList<>(Math.min(len1 * len2, k));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        for (int i = 0; i < Math.min(len1, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (ans.size() < k && !pq.isEmpty()) {
            int[] cur = pq.poll();
            List<Integer> list = new ArrayList<>();
            if (reverse) {
                Collections.addAll(list, nums2[cur[1]], nums1[cur[0]]);
            } else {
                Collections.addAll(list, nums1[cur[0]], nums2[cur[1]]);
            }
            ans.add(list);
            if (cur[1] + 1 < len2) {
                pq.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
