package leetcode.editor.cn;
//给你一个整数数组 nums 。每次 move 操作将会选择任意一个满足 0 <= i < nums.length 的下标 i，并将 nums[i] 递增 1
//。 
//
// 返回使 nums 中的每个值都变成唯一的所需要的最少操作次数。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：1
//解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,2,1,7]
//输出：6
//解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
//可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。 
// 
// 
//
// 
//提示：
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// 👍 216 👎 0


/**
 * 使数组唯一的最小增量
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-11 23:15:56 
 */
public class MinimumIncrementToMakeArrayUniqueSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int[] f = new int[(int) (2e5 + 1)];
        for (int num : nums) {
            f[num]++;
        }
        // 双指针，慢指针指向当前元素，快指针指向有空当的元素，贪心地加最小值
        int increment = 0;
        for (int i = 0, j = 1; i <= (int) 1e5; i++) {
            while (f[i] > 1) {
                j = Math.max(i + 1, j);
                while (f[j] > 0) j++;
                f[j]++;
                f[i]--;
                increment += j - i;
            }
        }
        return increment;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
