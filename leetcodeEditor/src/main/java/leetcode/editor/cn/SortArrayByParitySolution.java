package leetcode.editor.cn;

/**
 * 按奇偶排序数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-28 13:19:33 
 */
public class SortArrayByParitySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0, l = 0, r = n - 1; i < n; i++) {
            int val = nums[i];
            if ((val & 1) == 1) {
                res[r--] = val;
            } else {
                res[l++] = val;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
