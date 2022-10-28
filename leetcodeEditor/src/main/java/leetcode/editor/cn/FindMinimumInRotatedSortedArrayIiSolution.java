package leetcode.editor.cn;
//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变
//化后可能得到：
// 
// 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4] 
// 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7] 
// 
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], 
//..., a[n-2]] 。 
//
// 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。 
//
// 你必须尽可能减少整个过程的操作步骤。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,5]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,0,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转 
// 
//
// 
//
// 进阶：这道题与 寻找旋转排序数组中的最小值 类似，但 nums 可能包含重复元素。允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 👍 554 👎 0


/**
 * 寻找旋转排序数组中的最小值 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-28 17:49:50 
 */
public class FindMinimumInRotatedSortedArrayIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            /*
            设最小值为 x, 则 x 左侧的元素必定大于等于 nums[r], x 右侧的元素必定小于等于 nums[r], 所以 nums[mid] > nums[r] 时，
            nums[mid] 在 x 左侧，舍弃左半，nums[mid] < nums[r] 时，nums[mid] 在 x 右侧，舍弃右半。但若 nums[mid] == nums[r],
            则无法判断在左还是右，只能根据它们的值相同，去掉 nums[r] 不会改变最小值，来去掉 nums[r]
             */
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                int t = nums[r];
                while (r > mid && nums[r] == t) r--;
            }
        }
        return nums[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
