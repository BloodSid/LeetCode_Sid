package leetcode.editor.cn;

/**
 * 乘积小于K的子数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-08 19:30:29
 */
public class SubarrayProductLessThanKSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int n = nums.length;
        int sum = 0;
        for (int low = 0, high = 0; high < n; high++) {
            product *= nums[high];
            while (product >= k && low <= high) product /= nums[low++];
            sum += high - low + 1;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
