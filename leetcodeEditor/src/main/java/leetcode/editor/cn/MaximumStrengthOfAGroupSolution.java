package leetcode.editor.cn;
//给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 
//最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[
//i2] * ... * nums[ik] 。 
//
// 请你返回老师创建的小组能得到的最大实力值为多少。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,-1,-5,2,5,-9]
//输出：1350
//解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5] 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这
//是可以得到的最大实力值。
// 
//
// 示例 2： 
//
// 输入：nums = [-4,-5,-4]
//输出：20
//解释：选择下标为 [0, 1] 的学生。得到的实力值为 20 。我们没法得到更大的实力值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 13 
// -9 <= nums[i] <= 9 
// 
//
// 👍 54 👎 0


import java.util.*;

/**
 * 一个小组的最大实力值
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-09-03 21:56:26 
 */
public class MaximumStrengthOfAGroupSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long res = nums[n - 1];
        long product = 1;
        int cnt = 0;
        for (int i = 0; i + 1 < n; i += 2) {
            if (nums[i] < 0 && nums[i+1] < 0){
                product *= (long) nums[i] * nums[i + 1];
                cnt+=2;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] <= 0) break;
            product *= nums[i];
            cnt++;
        }
        if (cnt == 0) return res;
        return Math.max(res, product);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
