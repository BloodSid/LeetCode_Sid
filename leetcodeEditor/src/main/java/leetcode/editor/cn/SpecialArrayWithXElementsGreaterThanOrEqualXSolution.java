package leetcode.editor.cn;

/**
 * 特殊数组的特征值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:30:17
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualXSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n;
        while (l <= r) {
            int mid = l + r >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] >= mid) {
                    cnt++;
                }
            }
            if (cnt == mid) return mid;
            else if (cnt < mid) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
