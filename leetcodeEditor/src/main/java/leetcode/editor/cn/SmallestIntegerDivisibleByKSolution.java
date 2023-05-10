package leetcode.editor.cn;
//给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。 
//
// 返回 n 的长度。如果不存在这样的 n ，就返回-1。 
//
// 注意： n 不符合 64 位带符号整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 1
//输出：1
//解释：最小的答案是 n = 1，其长度为 1。 
//
// 示例 2： 
//
// 
//输入：k = 2
//输出：-1
//解释：不存在可被 2 整除的正整数 n 。 
//
// 示例 3： 
//
// 
//输入：k = 3
//输出：3
//解释：最小的答案是 n = 111，其长度为 3。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10⁵ 
// 
//
// 👍 110 👎 0


import java.util.*;

/**
 * 可被 K 整除的最小整数
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-10 11:42:09 
 */
public class SmallestIntegerDivisibleByKSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRepunitDivByK(int k) {
        HashSet<Integer> set = new HashSet<>();
        // 是否存在
        // 每次增加的值 * 10
        int d = 1;
        int sum = 0;
        while (true) {
            sum = (sum + d) % k;
            d = (10 * d) % k;
            if (!set.add(sum)) {
                break;
            }
            if (sum == 0) {
                break;
            }
        }
        return sum == 0 ? set.size() : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
