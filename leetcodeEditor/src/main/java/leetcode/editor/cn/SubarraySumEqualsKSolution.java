package leetcode.editor.cn;

import java.util.*;

/**
 * 和为 K 的子数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-08 14:57:55
 */
public class SubarraySumEqualsKSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            ans += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
