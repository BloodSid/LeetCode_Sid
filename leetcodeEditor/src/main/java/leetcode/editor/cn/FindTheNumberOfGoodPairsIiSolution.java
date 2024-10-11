package leetcode.editor.cn;
//给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。 
//
// 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <=
// m - 1）。 
//
// 返回 优质数对 的总数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1 
// 
//
// 输出：5 
//
// 解释： 
//
// 5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。 
//
// 示例 2： 
//
// 
// 输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3 
// 
//
// 输出：2 
//
// 解释： 
//
// 2个优质数对分别是 (3, 0) 和 (3, 1)。 
//
// 
//
// 提示： 
//
// 
// 1 <= n, m <= 10⁵ 
// 1 <= nums1[i], nums2[j] <= 10⁶ 
// 1 <= k <= 10³ 
// 
//
// 👍 44 👎 0


import java.util.*;

/**
 * 优质数对的总数 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-10-11 23:34:27 
 */
public class FindTheNumberOfGoodPairsIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i : nums2) {
            f.merge(i * k, 1, Integer::sum);
        }
        // 枚举n1的因子避免遍历整个f
        long res = 0;
        for (int x : nums1) {
            for (int i = 1; i <= x / i; i++) {
                if (x % i != 0) {
                    continue;
                }
                res += f.getOrDefault(i, 0);
                if (i * i < x) {
                    res += f.getOrDefault(x / i, 0);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
