package leetcode.editor.cn;

import java.util.*;

/**
 * 求众数 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-22 01:12:29
 */
public class MajorityElementIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int lowerBound = nums.length / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0);
            cnt++;
            if (cnt == lowerBound + 1) {
                ans.add(num);
            }
            map.put(num, cnt);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
