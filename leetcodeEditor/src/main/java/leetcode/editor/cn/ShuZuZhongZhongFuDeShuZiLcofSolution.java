package leetcode.editor.cn;

import java.util.*;

/**
 * 数组中重复的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-30 20:27:03
 */
public class ShuZuZhongZhongFuDeShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 把nums[i]放到下标为 num[i]的位置上
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            // 此时从nums[0]到nums[i]的值分别为0 到 i; 数组后面的部分也有一些数字是已经排好的
        }
        // 全部排好，无重复数字则返回-1
        return -1;
    }

    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
