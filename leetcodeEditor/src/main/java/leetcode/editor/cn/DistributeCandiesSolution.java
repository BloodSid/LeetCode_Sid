package leetcode.editor.cn;

import java.util.*;

/**
 * 分糖果
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-01 10:22:36 
 */
public class DistributeCandiesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candyType.length && set.size() < candyType.length >> 1; i++) {
            set.add(candyType[i]);
        }
        return set.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
