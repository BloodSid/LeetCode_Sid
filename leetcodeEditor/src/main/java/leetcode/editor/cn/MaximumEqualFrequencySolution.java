package leetcode.editor.cn;
//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度： 
//
// 
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。 
// 
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
// 👍 63 👎 0


import java.util.HashMap;

/**
 * 最大相等频率
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-18 00:36:29 
 */
public class MaximumEqualFrequencySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEqualFreq(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            f.put(nums[i], f.getOrDefault(nums[i], 0) + 1);
            boolean isEqual = true;
            int c1 = 0, c2 = 0, cc1 = 0, cc2 = 0;
            // 对频数进行计数
            for (Integer cnt : f.values()) {
                if (cnt == c1) {
                    cc1++;
                } else if (cnt == c2) {
                    cc2++;
                } else if (c1 == 0) {
                    c1 = cnt;
                    cc1 = 1;
                } else if (c2 == 0) {
                    c2 = cnt;
                    cc2 = 1;
                } else {
                    // 频数超过三种，提前终止
                    isEqual = false;
                    break;
                }
            }
            // 没有提前终止，说明频数小于等于两种
            if (isEqual) {
                // 满足以下条件可使得频数相等 频数只有 “1” 一种 或 频数只有一个 或 频数 a 有多个，b 有一个，且 b = 1 或 a + 1
                isEqual = (c2 == 0 && c1 == 1) || f.values().size() == 1
                        || (cc1 == 1 && (c1 == 1 || c1 == c2 + 1)) || (cc2 == 1 && (c2 == 1 || c2 == c1 + 1));
            }
            if (isEqual) {
                max = Math.max(max, i + 1);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
