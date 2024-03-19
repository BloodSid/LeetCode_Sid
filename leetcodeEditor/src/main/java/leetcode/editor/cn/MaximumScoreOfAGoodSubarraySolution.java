package leetcode.editor.cn;
//给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。 
//
// 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个
// 好 子数组的两个端点下标需要满足 i <= k <= j 。 
//
// 请你返回 好 子数组的最大可能 分数 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,3,7,4,5], k = 3
//输出：15
//解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
// 
//
// 示例 2： 
//
// 输入：nums = [5,5,4,5,4,1,1,1], k = 0
//输出：20
//解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 2 * 10⁴ 
// 0 <= k < nums.length 
// 
//
// 👍 129 👎 0


/**
 * 好子数组的最大分数
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-03-20 00:34:43 
 */
public class MaximumScoreOfAGoodSubarraySolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int min = nums[k];
        int res = nums[k];
        for (int l = k, r = k; ; ) {
            while (l > 0 && nums[l - 1] >= min) {
                l--;
            }
            while (r < n - 1 && nums[r + 1] >= min) {
                r++;
            }
            // 对于每一个 min 找到最长的好子数组
            res = Math.max(res, min * (r - l + 1));
            if (l == 0 && r == n - 1) {
                break;
            } else if (l == 0) {
                r++;
                min = Math.min(min, nums[r]);
            } else if (r == n - 1) {
                l--;
                min = Math.min(min, nums[l]);
            } else if (nums[l - 1] > nums[r + 1]) {
                l--;
                min = Math.min(min, nums[l]);
            } else {
                r++;
                min = Math.min(min, nums[r]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
