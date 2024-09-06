package leetcode.editor.cn;
//给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在下标范围 [0, seq.length - 2] 中 最多只有 k 个
//下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。 
//
// 请你返回 nums 中 好 子序列 的最长长度。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,1,1,3], k = 2 
// 
//
// 输出：4 
//
// 解释： 
//
// 最长好子序列为 [1,2,1,1,3] 。 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3,4,5,1], k = 0 
// 
//
// 输出：2 
//
// 解释： 
//
// 最长好子序列为 [1,2,3,4,5,1] 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 500 
// 1 <= nums[i] <= 10⁹ 
// 0 <= k <= min(nums.length, 25) 
// 
//
// 👍 38 👎 0


/**
 * 求出最长好子序列 I
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-09-06 22:03:38 
 */
public class FindTheMaximumLengthOfAGoodSubsequenceISolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[i]) {
                    for (int ki = 0; ki <= k; ki++) {
                        dp[i][ki] = Math.max(dp[i][ki], dp[j][ki] + 1);
                    }
                } else {
                    for (int ki = 1; ki <= k; ki++) {
                        dp[i][ki] = Math.max(dp[i][ki], dp[j][ki - 1] + 1);
                    }
                }
            }
            for (int j = 0; j <= k; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
