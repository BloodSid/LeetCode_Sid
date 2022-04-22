package leetcode.editor.cn;

/**
 * 旋转函数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-22 18:06:31
 */
public class RotateFunctionSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxRotateFunction(int[] nums) {
        int f = 0;
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
            sum += nums[i];
        }
        int max = f;
        for (int i = n - 1; i > 0; i--) {
            f = f - n * nums[i] + sum;
            max = Math.max(max, f);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
