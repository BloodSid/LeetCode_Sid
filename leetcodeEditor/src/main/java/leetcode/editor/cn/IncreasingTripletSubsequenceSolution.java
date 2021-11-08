package leetcode.editor.cn;

import java.util.*;

/**
 * 递增的三元子序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-08 14:40:06 
 */
public class IncreasingTripletSubsequenceSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
