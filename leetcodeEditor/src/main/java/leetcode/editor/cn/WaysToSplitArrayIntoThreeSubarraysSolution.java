package leetcode.editor.cn;
//我们称一个分割整数数组的方案是 好的 ，当它满足： 
//
// 
// 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。 
// left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。 
// 
//
// 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1]
//输出：1
//解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,2,2,5,0]
//输出：3
//解释：nums 总共有 3 种好的分割方案：
//[1] [2] [2,2,5,0]
//[1] [2,2] [2,5,0]
//[1,2] [2,2] [5,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,1]
//输出：0
//解释：没有好的分割方案。 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁴ 
// 
// 👍 79 👎 0


/**
 * 将数组分成三个子数组的方案数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-08 21:33:43 
 */
public class WaysToSplitArrayIntoThreeSubarraysSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0, t = 0; i < n; i++) {
            t += nums[i];
            pre[i + 1] = t;
        }
        long res = 0;
        for (int i = 1, j = 2, k = 2; i <= n; i++) {
            int left = pre[i];
            while (j <= n && pre[j] - pre[i] < left) j++;
            if (j > n || pre[n] - pre[j] < pre[j] - pre[i]) continue;
            while (k <= n && pre[k] - pre[i] <= pre[n] - pre[k]) k++;
            if (k > n) break;
            res += k - j;
        }
        return (int) (res % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
