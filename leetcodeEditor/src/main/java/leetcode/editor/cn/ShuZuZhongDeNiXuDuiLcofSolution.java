package leetcode.editor.cn;

import java.util.*;

/**
 * 数组中的逆序对
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-25 15:02:43
 */
public class ShuZuZhongDeNiXuDuiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] temp;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        temp = new int[nums.length];
        return reversePairs(nums, 0, nums.length - 1);
    }

    int reversePairs(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + r >>> 1;
        int left = reversePairs(nums, l, mid);
        int right = reversePairs(nums, mid + 1, r);
        int cross = mergeAndCount(nums, l, mid, r);
        return cross + left + right;
    }

    int mergeAndCount(int[] nums, int l, int mid, int r) {
        int l1 = l, r1 = mid, l2 = mid + 1, r2 = r;
        System.arraycopy(nums, l1, temp, l1, r2 - r1 + 1);
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            if (l1 > r1) {
                nums[i] = nums[l2];
                l2++;
            } else if (l2 > r2) {
                nums[i] = temp[l1];
                l1++;
                cnt += l2 - mid - 1;
            } else if (temp[l1] > nums[l2]) {
                nums[i] = nums[l2];
                l2++;
            } else {
                nums[i] = temp[l1];
                l1++;
                cnt += l2 - mid - 1;
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
