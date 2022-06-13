package leetcode.editor.cn;
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// 👍 2563 👎 0


/**
 * 最长递增子序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-09 23:52:14
 */
public class LongestIncreasingSubsequenceSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // end[i]表示长度 i + 1 的LIS的末尾元素的最小值
        int[] end = new int[n];
        end[0] = nums[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > end[len - 1]) {
                end[len] = nums[i];
                len++;
            } else {
                int l = 0, r = len - 1;
                while (l <= r) {
                    int mid = l + r >> 1;
                    if (end[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                end[l] = nums[i];
            }
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
