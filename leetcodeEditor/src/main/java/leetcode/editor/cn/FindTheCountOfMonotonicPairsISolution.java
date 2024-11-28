package leetcode.editor.cn;
//给你一个长度为 n 的 正 整数数组 nums 。 
//
// 如果两个 非负 整数数组 (arr1, arr2) 满足以下条件，我们称它们是 单调 数组对： 
//
// 
// 两个数组的长度都是 n 。 
// arr1 是单调 非递减 的，换句话说 arr1[0] <= arr1[1] <= ... <= arr1[n - 1] 。 
// arr2 是单调 非递增 的，换句话说 arr2[0] >= arr2[1] >= ... >= arr2[n - 1] 。 
// 对于所有的 0 <= i <= n - 1 都有 arr1[i] + arr2[i] == nums[i] 。 
// 
//
// 请你返回所有 单调 数组对的数目。 
//
// 由于答案可能很大，请你将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [2,3,2] 
// 
//
// 输出：4 
//
// 解释： 
//
// 单调数组对包括： 
//
// 
// ([0, 1, 1], [2, 2, 1]) 
// ([0, 1, 2], [2, 2, 0]) 
// ([0, 2, 2], [2, 1, 0]) 
// ([1, 2, 2], [1, 1, 0]) 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [5,5,5,5] 
// 
//
// 输出：126 
//
// 
//
// 提示： 
//
// 
// 1 <= n == nums.length <= 2000 
// 1 <= nums[i] <= 50 
// 
//
// 👍 28 👎 0


/**
 * 单调数组对的数目 I
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-11-28 21:45:21 
 */
public class FindTheCountOfMonotonicPairsISolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int M = (int) (1e9 + 7);
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int m = 50;
        // dp(i,j) 是长度为i且arr[i-1]为j的单调数组对的数目
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= nums[0]; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= nums[i]; j++) {
                // j >= j0, nums[i+1]-j = k <= k0 = nums[i]-j'
                for (int j0 = 0; j0 <= Math.min(j, nums[i-1] + j - nums[i]); j0++) {
                    dp[i+1][j] = (dp[i+1][j] + dp[i][j0]) % M;
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= m; i++) {
            res += dp[n][i];
        }
        return (int) (res % M);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
