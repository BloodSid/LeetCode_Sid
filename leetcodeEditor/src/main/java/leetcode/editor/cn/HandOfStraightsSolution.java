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
        Arrays.sort(hand);
        List<Integer> list = new LinkedList<>();
        for (int i : hand) {
            list.add(i);
        }
        for (int i = 0; i < hand.length / groupSize; i++) {
            int start = list.get(0);
            for (int j = 0; j < groupSize; j++) {
                if (!list.remove(Integer.valueOf(start + j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
