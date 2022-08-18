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


import java.util.*;

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
        // 元素的频率
        HashMap<Integer, Integer> f = new HashMap<>();
        // 频率的频率
        HashMap<Integer, Integer> ff = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            int freq = f.getOrDefault(e, 0);
            ff.put(freq + 1, ff.getOrDefault(freq + 1, 0) + 1);
            if (freq != 0) ff.put(freq, ff.get(freq) - 1);
            f.put(e, freq + 1);
            maxFreq = Math.max(maxFreq, freq + 1);
            // 满足以下条件可使得频数相等 频数只有 “1” 一种 或 频数 a 有多个，b 有一个，且 b = 1 或 a + 1
            if (maxFreq == 1 || (ff.get(maxFreq) == 1 && maxFreq + (maxFreq - 1) * ff.get(maxFreq - 1) == i + 1)
                    || (ff.get(1) == 1 && maxFreq * ff.get(maxFreq) + 1 == i + 1)) {
                max = Math.max(max, i + 1);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
