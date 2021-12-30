package leetcode.editor.cn;

import java.util.*;

/**
 * 数组中重复的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-30 20:27:03
 */
public class ShuZuZhongZhongFuDeShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] freq = new int[nums.length];
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > 1) {
                return num;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
