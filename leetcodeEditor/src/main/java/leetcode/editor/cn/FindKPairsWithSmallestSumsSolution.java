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
    int[][] dirs = {{0, 1}, {1, 0}};

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int ansSize = Math.min(len1 * len2, k);
        List<List<Integer>> ans = new ArrayList<>(ansSize);
        if (ansSize == len1 * len2) {
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    List<Integer> list = new ArrayList<>();
                    Collections.addAll(list, nums1[i], nums2[j]);
                    ans.add(list);
                }
            }
            return ans;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        HashSet<Integer> visited = new HashSet<>();
        pq.offer(new int[]{0, 0});
        visited.add((0 << 16) + 0);
        while (ans.size() < ansSize) {
            int[] cur = pq.poll();
            List<Integer> list = new ArrayList<>();
            Collections.addAll(list, nums1[cur[0]], nums2[cur[1]]);
            ans.add(list);
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < len1 && y < len2 && !visited.contains((x << 16) + y)) {
                    pq.offer(new int[]{x, y});
                    visited.add((x << 16) + y);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
