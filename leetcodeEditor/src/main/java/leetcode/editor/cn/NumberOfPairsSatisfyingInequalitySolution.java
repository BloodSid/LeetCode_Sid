package leetcode.editor.cn;
//给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两个数组的大小都为 n ，同时给你一个整数 diff ，统计满足以下条件的 数对 (i, 
//j) ： 
//
// 
// 0 <= i < j <= n - 1 且 
// nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff. 
// 
//
// 请你返回满足条件的 数对数目 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [3,2,5], nums2 = [2,2,1], diff = 1
//输出：3
//解释：
//总共有 3 个满足条件的数对：
//1. i = 0, j = 1：3 - 2 <= 2 - 2 + 1 。因为 i < j 且 1 <= 1 ，这个数对满足条件。
//2. i = 0, j = 2：3 - 5 <= 2 - 1 + 1 。因为 i < j 且 -2 <= 2 ，这个数对满足条件。
//3. i = 1, j = 2：2 - 5 <= 2 - 1 + 1 。因为 i < j 且 -3 <= 2 ，这个数对满足条件。
//所以，我们返回 3 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [3,-1], nums2 = [-2,2], diff = -1
//输出：0
//解释：
//没有满足条件的任何数对，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 2 <= n <= 10⁵ 
// -10⁴ <= nums1[i], nums2[i] <= 10⁴ 
// -10⁴ <= diff <= 10⁴ 
// 
// 👍 6 👎 0


/**
 * 满足不等式的数对数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-04 19:37:49 
 */
public class NumberOfPairsSatisfyingInequalitySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int diff;
    private int[] temp;


    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        this.diff = diff;
        int n = nums1.length;
        int[] nums = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }
        return mergeSort(nums, 0, n - 1);
    }

    // 归并排序，并在每次合并前计算出符合不等式 nums[i] <= nums[j] + diff 的数对数量
    long mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + right >> 1;
        // 左右两部分各自内部的数对数量
        long pairs = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        // 左右两部分交叉的数对数量
        for (int i = left, j = mid + 1; j <= right; j++) {
            while (i <= mid && nums[i] <= nums[j] + diff) {
                i++;
            }
            pairs += i - left;
        }
        // 合并左右两部分为一个有序数列
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int p = left;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (temp[p1] < temp[p2]) {
                nums[p++] = temp[p1++];
            } else {
                nums[p++] = temp[p2++];
            }
        }
        if (p1 > mid) {
            System.arraycopy(temp, p2, nums, p, right - p + 1);
        } else {
            System.arraycopy(temp, p1, nums, p, right - p + 1);
        }
        return pairs;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
