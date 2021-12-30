package leetcode.editor.cn;

import java.util.*;

/**
 * 一手顺子
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-30 18:45:44
 */
public class HandOfStraightsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        if (groupSize == 1) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            heap.offer(i);
        }
        while (!heap.isEmpty()) {
            int start = heap.poll();
            if (map.get(start) == 0) {
                continue;
            }
            for (int i = start; i < start + groupSize; i++) {
                int cnt = map.getOrDefault(i, 0);
                if (cnt == 0) {
                    return false;
                }
                map.put(i, cnt - 1);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
