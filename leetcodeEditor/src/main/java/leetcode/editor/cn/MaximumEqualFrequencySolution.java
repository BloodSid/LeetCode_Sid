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
        HashMap<Integer, Integer> f = new HashMap<>();
        Integer[] first = new Integer[2];
        Integer[] last = new Integer[2];
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];
            int value = f.getOrDefault(key, 0) + 1;
            f.put(key, value);
            // 记录极值和次极值
            if (key == first[0] || key == first[1]) {
                if (first[1] != null) Arrays.sort(first, (o1, o2) -> f.get(o1) - f.get(o2));
            } else if (first[0] == null || value < f.get(first[0])) {
                first[1] = first[0];
                first[0] = key;
            } else if (first[1] == null || value < f.get(first[1])) {
                first[1] = key;
            }
            if (key == last[0] || key == last[1]) {
                if (last[1] != null) Arrays.sort(last, (o1, o2) -> f.get(o2) - f.get(o1));
            } else if (last[0] == null || value > f.get(last[0])) {
                last[1] = last[0];
                last[0] = key;
            } else if (last[1] == null || value > f.get(last[1])) {
                last[1] = key;
            }
            Integer f0 = f.get(first[0]), f1 = f.get(first[1]), l0 = f.get(last[0]), l1 = f.get(last[1]);
            // 满足以下条件可使得频数相等 频数只有 “1” 一种 或 频数只有一个 或 频数 a 有多个，b 有一个，且 b = 1 或 a + 1
            boolean isEqual = (f.size() == 1) || (f0 == 1 && l0 == 1)
                    || (f0 == 1 && f1 == l0) || (f0 == l1 && l0 == l1 + 1);
            if (isEqual) {
                max = Math.max(max, i + 1);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
