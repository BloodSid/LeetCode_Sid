package leetcode.editor.cn;
//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
// Related Topics 数组 排序 
// 👍 253 👎 0


import java.util.*;

/**
 * 第三大的数
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-06 00:06:54
 */
public class ThirdMaximumNumberSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        List<Integer> max = new ArrayList<>();
        max.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int len = max.size();
            int j = 0;
            for (; j < len; j++) {
                if (nums[i] > max.get(j)) {
                    max.add(j, nums[i]);
                    break;
                } else if (nums[i] == max.get(j)) {
                    break;
                }
            }
            if (j == len) {
                max.add(nums[i]);
            }
            if (max.size() == 4) {
                max.remove(3);
            }
        }
        return max.size() == 3 ? max.get(2) : max.get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
