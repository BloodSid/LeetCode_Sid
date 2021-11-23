package leetcode.editor.cn;

import java.util.*;

/**
 * 前 K 个高频元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-23 07:37:13
 */
public class TopKFrequentElementsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (Integer key : map.keySet()) {
            queue.offer(key);
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
