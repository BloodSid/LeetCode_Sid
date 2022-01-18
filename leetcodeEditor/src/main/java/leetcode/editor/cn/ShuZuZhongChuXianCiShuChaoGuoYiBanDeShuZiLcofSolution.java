package leetcode.editor.cn;

import java.util.*;

/**
 * 数组中出现次数超过一半的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-18 11:52:06
 */
public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        // 摩尔投票法
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (num == res) {
                cnt++;
            } else if (cnt > 0) {
                cnt--;
            } else {
                res = num;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
