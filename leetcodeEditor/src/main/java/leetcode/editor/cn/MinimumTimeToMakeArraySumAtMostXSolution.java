package leetcode.editor.cn;
//给你两个长度相等下标从 0 开始的整数数组 nums1 和 nums2 。每一秒，对于所有下标 0 <= i < nums1.length ，nums1[
//i] 的值都增加 nums2[i] 。操作 完成后 ，你可以进行如下操作： 
//
// 
// 选择任一满足 0 <= i < nums1.length 的下标 i ，并使 nums1[i] = 0 。 
// 
//
// 同时给你一个整数 x 。 
//
// 请你返回使 nums1 中所有元素之和 小于等于 x 所需要的 最少 时间，如果无法实现，那么返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3], nums2 = [1,2,3], x = 4
//输出：3
//解释：
//第 1 秒，我们对 i = 0 进行操作，得到 nums1 = [0,2+2,3+3] = [0,4,6] 。
//第 2 秒，我们对 i = 1 进行操作，得到 nums1 = [0+1,0,6+3] = [1,0,9] 。
//第 3 秒，我们对 i = 2 进行操作，得到 nums1 = [1+1,0+2,0] = [2,2,0] 。
//现在 nums1 的和为 4 。不存在更少次数的操作，所以我们返回 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2,3], nums2 = [3,3,3], x = 4
//输出：-1
//解释：不管如何操作，nums1 的和总是会超过 x 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10³ 
// 1 <= nums1[i] <= 10³ 
// 0 <= nums2[i] <= 10³ 
// nums1.length == nums2.length 
// 0 <= x <= 10⁶ 
// 
//
// 👍 100 👎 0


import java.util.*;

/**
 * 使数组和小于等于 x 的最少时间
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-01-19 22:46:11 
 */
public class MinimumTimeToMakeArraySumAtMostXSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        // 贪心1：某个元素减两次必不优于减一次
        // 贪心2：n2更大的元素越晚减越好，所以把所有元素按n2增序排列
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a,b) -> nums2.get(a) - nums2.get(b));
        int[] n1 = new int[n], n2 = new int[n];
        for (int i = 0; i < n; i++) {
            n1[i] = nums1.get(idx[i]);
            n2[i] = nums2.get(idx[i]);
        }
        // dp(i,j) 表示对前i个元素做j次操作可最多减掉的值
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 选或不选第i个元素
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + n1[i - 1] + n2[i - 1] * j);
            }
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += n1[i];
            sum2 += n2[i];
        }
        // 从小到大枚举时间，范围[0,n]，计算是否存在满足和小于等于x的时间
        for (int t = 0; t <= n; t++) {
            if (sum1 + sum2 * t - dp[n][t] <= x) {
                return t;
            }
        }
        // 不存在
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
