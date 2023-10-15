package leetcode.editor.cn;
//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 👍 1114 👎 0


/**
 * 只出现一次的数字 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-10-15 14:15:49 
 */
public class SingleNumberIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int T = 32;

    public int singleNumber(int[] nums) {
        int[] bits = new int[T];
        for (int num : nums) {
            for (int i = 0; num != 0; num >>>= 1, i++) {
                if ((num & 1) == 1) bits[i]++;
            }
        }
        int res = 0;
        for (int i = 0; i < T; i++) {
            if (bits[i] % 3 != 0) res |= 1 << i;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
