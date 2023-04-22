package leetcode.editor.cn;
//给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。 
//
// 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... <
// ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么
//序列 seq 是等差的。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,6,9,12]
//输出：4
//解释： 
//整个数组是公差为 3 的等差数列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9,4,7,2,10]
//输出：3
//解释：
//最长的等差子序列是 [4,7,10]。
// 
//
// 示例 3： 
//
// 
//输入：nums = [20,1,15,3,10,5,8]
//输出：4
//解释：
//最长的等差子序列是 [20,15,10,5]。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 1000 
// 0 <= nums[i] <= 500 
// 
//
// 👍 257 👎 0


import java.util.*;

/**
 * 最长等差数列
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-22 10:38:15
 */
public class LongestArithmeticSubsequenceSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int max = 0;
        int n = nums.length;
        // dp(i,d) 表示以 nums[i] 结束的公差为d的最长等差数列的长度
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        dp[0] = new HashMap<>();
        for (int i = 1; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int d = nums[j] - nums[i];
                /* 对于一个确定的 i,d, 前一个元素 nums[j] 的大小是确定的。若i之前有若干个元素都等于nums[j]，一定是其中的最后一个最能构成子
                序列，再根据j是从小到大遍历，所以这里可以直接赋值而不用比较大小。*/
                dp[i].put(d, dp[j].getOrDefault(d, 1) + 1);
                max = Math.max(max, dp[i].get(d));
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
