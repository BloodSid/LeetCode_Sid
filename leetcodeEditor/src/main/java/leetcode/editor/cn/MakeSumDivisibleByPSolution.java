package leetcode.editor.cn;
//给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。 
//
// 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。 
//
// 子数组 定义为原数组中连续的一组元素。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,1,4,2], p = 6
//输出：1
//解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
// 
//
// 示例 2： 
//
// 输入：nums = [6,3,5,2], p = 9
//输出：2
//解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3], p = 3
//输出：0
//解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
// 
//
// 示例 4： 
//
// 输入：nums = [1,2,3], p = 7
//输出：-1
//解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
// 
//
// 示例 5： 
//
// 输入：nums = [1000000000,1000000000,1000000000], p = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= p <= 10⁹ 
// 
//
// 👍 135 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 使数组和能被 P 整除
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-10 14:07:41 
 */
public class MakeSumDivisibleByPSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long[] pre = new long[n + 1], suf = new long[n + 1];
        // pre[i] = sum(nums[0, i))
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        // suf[i] = sum(nums[i, n))
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1] + nums[i];
        }
        // 按模分组存储后缀和的下标
        HashMap<Integer, List<Integer>> sufMap = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int r = (int) (suf[i] % p);
            sufMap.putIfAbsent(r, new ArrayList<>());
            sufMap.get(r).add(i);
        }
        if (pre[n] % p == 0) return 0;
        int min = n;
        for (int i = 0; i < n; i++) {
            int a = (int) (pre[i] % p);
            int b = (p - a) % p;
            // 没有满足要求的后缀
            if (!sufMap.containsKey(b)) continue;
            List<Integer> idx = sufMap.get(b);
            // 二分在 idx 中找第一个严格大于 i 的值
            int l = 0, r = idx.size() - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                if (idx.get(mid) > i) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (l != idx.size()) {
                int j = idx.get(l);
                min = Math.min(min, j - i);
            }
        }
        // 删除子数组后，剩余一个前缀一个后缀，枚举前缀找可以让数组和被整除的最长后缀
        return min != n ? min : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
