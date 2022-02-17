package leetcode.editor.cn;

import java.util.*;

/**
 * 区域和检索 - 数组不可变
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-17 11:06:55
 */
public class RangeSumQueryImmutableSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    int[] preSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
