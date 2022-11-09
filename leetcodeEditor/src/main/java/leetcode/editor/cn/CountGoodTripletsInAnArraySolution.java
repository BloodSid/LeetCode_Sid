package leetcode.editor.cn;
//给你两个下标从 0 开始且长度为 n 的整数数组 nums1 和 nums2 ，两者都是 [0, 1, ..., n - 1] 的 排列 。 
//
// 好三元组 指的是 3 个 互不相同 的值，且它们在数组 nums1 和 nums2 中出现顺序保持一致。换句话说，如果我们将 pos1v 记为值 v 在 
//nums1 中出现的位置，pos2v 为值 v 在 nums2 中的位置，那么一个好三元组定义为 0 <= x, y, z <= n - 1 ，且 pos1x 
//< pos1y < pos1z 和 pos2x < pos2y < pos2z 都成立的 (x, y, z) 。 
//
// 请你返回好三元组的 总数目 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [2,0,1,3], nums2 = [0,1,2,3]
//输出：1
//解释：
//总共有 4 个三元组 (x,y,z) 满足 pos1x < pos1y < pos1z ，分别是 (2,0,1) ，(2,0,3) ，(2,1,3) 和 (
//0,1,3) 。
//这些三元组中，只有 (0,1,3) 满足 pos2x < pos2y < pos2z 。所以只有 1 个好三元组。
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3]
//输出：4
//解释：总共有 4 个好三元组 (4,0,3) ，(4,0,2) ，(4,1,3) 和 (4,1,2) 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 3 <= n <= 10⁵ 
// 0 <= nums1[i], nums2[i] <= n - 1 
// nums1 和 nums2 是 [0, 1, ..., n - 1] 的排列。 
// 
// 👍 35 👎 0


import java.util.Arrays;

/**
 * 统计数组中好三元组数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-27 15:18:00 
 */
public class CountGoodTripletsInAnArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] temp;
    private int[] less;

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // nums1 中各个数字的位置
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[nums1[i]] = i;
        }
        // nums2 中各个数字在 nums1 中的位置
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = p[nums2[i]];
        }
        temp = new int[n];
        // cur 左侧更小的元素的数量为 less[cur]
        less = new int[n];
        // 若 arr 中有 i < j < k 且 arr[i] < arr[j] < arr[k] 说明它们对应的数字在两个数组中出现顺序一致
        long res = 0;
        mergeSort(Arrays.copyOf(arr, n), 0, n - 1);
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            // 求出 cur 左侧更大的元素的数量，由于比 cur 更大的元素总数是 n-1-cur 个，可知 cur 右侧更大的元素的数量
            int more = n - 1 - cur - (i - less[cur]);
            // 两个数量相乘，即为 arr[i] 作为中间元素的三元组数量
            res += (long) less[cur] * more;

        }
        return res;
    }

    // 归并排序，并在每次合并前求出每个右半元素在左半中更小元素的数量
    void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + right >> 1;
        // 递归
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        // 双指针 求出每个右半元素在左半中更小元素的数量
        for (int r = mid + 1, l = left; r <= right; r++) {
            int cur = nums[r];
            while (l <= mid && nums[l] <= nums[r]) l++;
            less[cur] += l - left;
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
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
