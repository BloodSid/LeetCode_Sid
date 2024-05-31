package leetcode.editor.cn;
//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。 
//
// 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。 
//
// 子数组 是数组中一个连续且可能为空的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,3,1,3], k = 3
//输出：3
//解释：最优的方案是删除下标 2 和下标 4 的元素。
//删除后，nums 等于 [1, 3, 3, 3] 。
//最长等值子数组从 i = 1 开始到 j = 3 结束，长度等于 3 。
//可以证明无法创建更长的等值子数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,2,2,1,1], k = 2
//输出：4
//解释：最优的方案是删除下标 2 和下标 3 的元素。 
//删除后，nums 等于 [1, 1, 1, 1] 。 
//数组自身就是等值子数组，长度等于 4 。 
//可以证明无法创建更长的等值子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= nums.length 
// 0 <= k <= nums.length 
// 
//
// 👍 107 👎 0


import java.util.*;

/**
 * 找出最长等值子数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-05-31 23:52:58 
 */
public class FindTheLongestEqualSubarraySolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int n;
    private int k;
    private int[] nums;

    public int longestEqualSubarray(List<Integer> list, int k) {
        n = list.size();
        this.k = k;
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }
        int l = 0, r = n;
        while (l <= r) {
            int mid = l + r >> 1;
            // 检查长度 mid + k 的窗口内有无相同的 mid 个元素
            if (check(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private boolean check(int mid) {
        HashMap<Integer, Integer> f = new HashMap<>();
        int i = 0, j = 0;
        for (; j < n; j++) {
            f.merge(nums[j], 1, Integer::sum);
            if (j + 1 - i > mid + k) {
                f.merge(nums[i], -1, Integer::sum);
                i++;
            }
            if (f.get(nums[j]) >= mid) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
