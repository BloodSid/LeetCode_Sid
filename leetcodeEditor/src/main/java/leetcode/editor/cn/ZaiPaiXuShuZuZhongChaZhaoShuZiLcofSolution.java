package leetcode.editor.cn;

import java.util.*;

/**
 * 在排序数组中查找数字 I
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-30 20:51:23
 */
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int start = binarySearch(nums, 0, nums.length - 1, target);
        if (start == nums.length) {
            return 0;
        }
        int end = binarySearch(nums, start, nums.length - 1, target + 1);
        return end - start;
    }

    // 找到一个数或者比他大的数第一次出现的位置
    int binarySearch(int[] nums, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
