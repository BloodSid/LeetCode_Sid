package leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 target 。 
//
// 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。 
//
// 由于答案可能很大，请将结果对 10⁹ + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,5,6,7], target = 9
//输出：4
//解释：有 4 个子序列满足该条件。
//[3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//[3,5,6] -> (3 + 6 <= 9)
//[3,6] -> (3 + 6 <= 9)
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,3,6,8], target = 10
//输出：6
//解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6] 
//
// 示例 3： 
//
// 
//输入：nums = [2,3,3,4,6,7], target = 12
//输出：61
//解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
//有效序列总数为（63 - 2 = 61）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 1 <= target <= 10⁶ 
// 
// 👍 94 👎 0


import java.util.*;

/**
 * 满足条件的子序列数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-11 23:16:44 
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumConditionSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = 0;
        int[] v = new int[nums.length];
        int[] f = new int[nums.length];
        for (int num : nums) {
            if (n > 0 && num == v[n - 1]) {
                f[n - 1]++;
            } else {
                v[n] = num;
                f[n] = 1;
                n++;
            }
        }
        // 数组 f 的前缀和
        int[] pre = new int[n + 1];
        for (int i = 0, t = 0; i < n; i++) {
            t += f[i];
            pre[i + 1] = t;
        }
        long sum = 0;
        for (int i = 0, j = n - 1; i <= j; i++) {
            while (i <= j && v[i] + v[j] > target) j--;
            if (i > j) break;
            // i 表示下限，必选至少一个，j 表示上限， (i, j] 可选
            int a = f[i], b = pre[j + 1] - pre[i + 1];
            sum += (pow2(a) - 1) * pow2(b) % MOD;
        }
        return (int) (sum % MOD);
    }

    // 快速幂
    long pow2(int x) {
        if (x == 0) return 1;
        long t = pow2(x >> 1);
        if ((x & 1) == 1) return 2 * (t * t) % MOD;
        else return t * t % MOD;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
