package leetcode.editor.cn;

import java.util.*;

/**
 * 颜色分类
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 19:54:26
 */
public class SortColorsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }
        }
    }

    void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
