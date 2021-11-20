package leetcode.editor.cn;

import java.util.*;

/**
 * 最长和谐子序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-20 18:22:25
 */
public class LongestHarmoniousSubsequenceSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (Integer key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
