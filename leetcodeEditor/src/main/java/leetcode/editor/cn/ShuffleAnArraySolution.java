package leetcode.editor.cn;

import java.util.*;

/**
 * 打乱数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-22 12:35:37
 */
public class ShuffleAnArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] nums;
    int[] original;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
        original = nums.clone();
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
    }

    public int[] shuffle() {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            swap(nums, i, i + random.nextInt(n - i));
        }
        return nums;
    }

    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
