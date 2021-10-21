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
        // 摩尔投票法的核心思想为对拼消耗
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                vote1++;
            } else if (vote2 > 0 && num == element2) {
                vote2++;
            } else if (vote1 == 0) {
                element1 = num;
                vote1++;
            } else if (vote2 == 0) {
                element2 = num;
                vote2++;
            } else {
                // 与前面两个数均不同，则抵消这三个数
                vote1--;
                vote2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (num == element1) {
                cnt1++;
            } else if (num == element2){
                cnt2++;
            }
        }
        if (cnt1 > nums.length / 3) {
            ans.add(element1);
        }
        if (cnt2 > nums.length / 3) {
            ans.add(element2);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
