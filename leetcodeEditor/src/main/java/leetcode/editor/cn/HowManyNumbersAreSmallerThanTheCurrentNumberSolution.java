package leetcode.editor.cn;

/**
 * 有多少小于当前数字的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-14 00:05:50
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumberSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static final int MAX = 100;

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] f = new int[MAX + 1];
        int n = nums.length;
        for (int num : nums) {
            f[num]++;
        }
        for (int i = 1; i <= MAX; i++) {
            f[i] += f[i - 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                res[i] = f[nums[i] - 1];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
