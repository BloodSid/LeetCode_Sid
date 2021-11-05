package leetcode.editor.cn;

import java.util.*;

/**
 * 多数元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 00:20:46 
 */
public class MajorityElementSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int element = 0;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                element = num;
                cnt++;
            } else if (num == element) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return element;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
