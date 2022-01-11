package leetcode.editor.cn;

import java.util.*;

/**
 * 扑克牌中的顺子
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-11 22:23:41
 */
public class BuKePaiZhongDeShunZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        int[] freq = new int[14];
        for (int num : nums) {
            freq[num]++;
        }
        if (freq[0] == nums.length) {
            return true;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > 1) {
                return false;
            }
        }
        int min = 1;
        while (freq[min] == 0) {
            min++;
        }
        int max = 13;
        while (freq[max] == 0) {
            max--;
        }
        return max - min < nums.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
