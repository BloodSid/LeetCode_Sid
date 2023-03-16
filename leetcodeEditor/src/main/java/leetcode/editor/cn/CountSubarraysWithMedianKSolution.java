package leetcode.editor.cn;
//给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。 
//
// 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。 
//
// 注意： 
//
// 
// 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
//
// 
// 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。 
// 
// 
// 子数组是数组中的一个连续部分。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,4,5], k = 4
//输出：3
//解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,1], k = 3
//输出：1
//解释：[3] 是唯一一个中位数等于 3 的子数组。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i], k <= n 
// nums 中的整数互不相同 
// 
// 👍 135 👎 0


import java.util.HashMap;

/**
 * 统计中位数为 K 的子数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-16 20:23:59 
 */
public class CountSubarraysWithMedianKSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubarrays(int[] nums, int k) {
        // 找到 k 的位置
        int p = 0;
        int n = nums.length;
        for (; p < n; p++) {
            if (nums[p] == k) {
                break;
            }
        }
        int[] pre = new int[n + 1];
        for (int i = 0, t = 0; i < n; i++) {
            t += nums[i] > k ? 1 : -1;
            pre[i + 1] = t;
        }
        // 哈希表存储 p 左侧的前缀，枚举 p 右侧的前缀
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i <= p; i++) {
            f.put(pre[i], f.getOrDefault(pre[i], 0) + 1);
        }
        // 比 k 大的数有 l 个，比 k 小的数有 r 个，l-r=0 或 l-r=1 时对应子数组中位数是k，其中l-r可以由pre计算
        int res = 0;
        for (int i = p + 1; i <= n; i++) {
            res += f.getOrDefault(pre[i], 0);
            res += f.getOrDefault(pre[i] + 1, 0);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
