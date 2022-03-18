package leetcode.editor.cn;

/**
 * 错误的集合
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-18 19:03:47
 */
public class SetMismatchSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        int rep = 0;
        int sum = 0;
        for (int num : nums) {
            f[num]++;
            if (f[num] == 2) {
                rep = num;
            }
            sum += num;
        }
        int loss = (n + 1) * n / 2 - sum + rep;
        return new int[]{rep, loss};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
