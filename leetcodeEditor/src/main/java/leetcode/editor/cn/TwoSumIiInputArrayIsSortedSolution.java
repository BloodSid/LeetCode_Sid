package leetcode.editor.cn;

/**
 * 两数之和 II - 输入有序数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:29:44 
 */
public class TwoSumIiInputArrayIsSortedSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0, j = n - 1; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[]{i + 1, j + 1};
            if (sum > target) j--;
            else i++;
        }
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
