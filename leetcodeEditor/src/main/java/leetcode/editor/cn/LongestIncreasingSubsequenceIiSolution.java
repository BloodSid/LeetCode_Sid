package leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 k 。 
//
// 找到 nums 中满足以下要求的最长子序列： 
//
// 
// 子序列 严格递增 
// 子序列中相邻元素的差值 不超过 k 。 
// 
//
// 请你返回满足上述要求的 最长子序列 的长度。 
//
// 子序列 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,2,1,4,3,4,5,8,15], k = 3
//输出：5
//解释：
//满足要求的最长子序列是 [1,3,4,5,8] 。
//子序列长度为 5 ，所以我们返回 5 。
//注意子序列 [1,3,4,5,8,15] 不满足要求，因为 15 - 8 = 7 大于 3 。
// 
//
// 示例 2： 
//
// 输入：nums = [7,4,5,1,8,12,4,7], k = 5
//输出：4
//解释：
//满足要求的最长子序列是 [4,5,8,12] 。
//子序列长度为 4 ，所以我们返回 4 。
// 
//
// 示例 3： 
//
// 输入：nums = [1,5], k = 1
//输出：1
//解释：
//满足要求的最长子序列是 [1] 。
//子序列长度为 1 ，所以我们返回 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i], k <= 10⁵ 
// 
// 👍 39 👎 0


import java.util.Arrays;

/**
 * 最长递增子序列 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-06 01:14:16 
 */
public class LongestIncreasingSubsequenceIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] max;

    public int lengthOfLIS(int[] nums, int k) {
        int u = Arrays.stream(nums).max().getAsInt() + 1;
        max = new int[4 * u];
        for (int x : nums) {
            x++;
            int res = 1 + query(1, 1, u, Math.max(x - k, 1), x - 1);
            modify(1, 1, u, x, res);
        }
        return max[1];
    }

    // 修改区间的中的 i 的值为 val，并且返回区间的最大值
    void modify(int o, int l, int r, int i, int val) {
        if (l == r) {
            max[o] = val;
            return;
        }
        int m = l + r >> 1;
        if (i <= m) modify(2 * o, l, m, i, val);
        else modify(2 * o + 1, m + 1, r, i, val);
        max[o] = Math.max(max[2 * o], max[2 * o + 1]);
    }

    // 返回 【L，R】中的最大值
    int query(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            return max[o];
        }
        int m = l + r >> 1;
        int res = 0;
        if (L <= m) res = query(2 * o, l, m, L, R);
        if (R > m) res = Math.max(res, query(2 * o + 1, m + 1, r, L, R));
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
