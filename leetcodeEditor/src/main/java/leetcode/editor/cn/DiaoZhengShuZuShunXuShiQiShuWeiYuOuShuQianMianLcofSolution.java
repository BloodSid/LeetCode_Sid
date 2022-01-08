package leetcode.editor.cn;

import java.util.*;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-09 00:00:39
 */
public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            while (l < r && nums[l] % 2 == 1) {
                l++;
            }
            while (l < r && nums[r] % 2 == 0) {
                r--;
            }
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            } else {
                break;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
