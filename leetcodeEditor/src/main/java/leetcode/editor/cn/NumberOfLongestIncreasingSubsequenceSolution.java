package leetcode.editor.cn;
//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 树状数组 线段树 数组 动态规划 
// 👍 438 👎 0


import java.util.*;

/**
 * 最长递增子序列的个数
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-09-20 15:34:19
 */
public class NumberOfLongestIncreasingSubsequenceSolution {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int[] cnt = new int[nums.length];
            int max = 0;
            for (int i = 0; i < dp.length; i++) {
                int len = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        len = Math.max(len, dp[j]);
                    }
                }
                dp[i] = len + 1;
                max = Math.max(max, dp[i]);
                if (len == 0) {
                    cnt[i] = 1;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (nums[j] < nums[i] && dp[j] == len) {
                            cnt[i] += cnt[j];
                        }
                    }
                }
            }
            int cntsum = 0;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == max) {
                    cntsum += cnt[i];
                }
            }
            return cntsum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
