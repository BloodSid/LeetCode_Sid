package leetcode.editor.cn;
//给你两个正整数：n 和 target 。 
//
// 如果数组 nums 满足下述条件，则称其为 美丽数组 。 
//
// 
// nums.length == n. 
// nums 由两两互不相同的正整数组成。 
// 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。 
// 
//
// 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 10⁹ + 7。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2, target = 3
//输出：4
//解释：nums = [1,3] 是美丽数组。
//- nums 的长度为 n = 2 。
//- nums 由两两互不相同的正整数组成。
//- 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
//可以证明 4 是符合条件的美丽数组所可能具备的最小和。 
//
// 示例 2： 
//
// 
//输入：n = 3, target = 3
//输出：8
//解释：
//nums = [1,3,4] 是美丽数组。 
//- nums 的长度为 n = 3 。 
//- nums 由两两互不相同的正整数组成。 
//- 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
//可以证明 8 是符合条件的美丽数组所可能具备的最小和。 
//
// 示例 3： 
//
// 
//输入：n = 1, target = 1
//输出：1
//解释：nums = [1] 是美丽数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 1 <= target <= 10⁹ 
// 
//
// 👍 41 👎 0


/**
 * 找出美丽数组的最小和
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-03-08 15:45:44 
 */
public class FindTheMinimumPossibleSumOfABeautifulArraySolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int M = (int) (1e9+7);

    public int minimumPossibleSum(int n, int target) {
        // 贪心，先从【1，target/2】取数
        int m = Math.min(n, target / 2);
        long sum = (1L + m) * m / 2;
        n -= m;
        // 再从target开始取数，直到取够
        sum += ((long) target + target + n - 1) * n / 2;
        return (int) (sum % M);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
