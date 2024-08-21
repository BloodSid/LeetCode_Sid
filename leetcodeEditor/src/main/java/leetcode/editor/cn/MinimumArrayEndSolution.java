package leetcode.editor.cn;
//给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums ，对于所有 0 <= i < n - 1 ，满足 nums[i + 1] 
//大于 nums[i] ，并且数组 nums 中所有元素的按位 AND 运算结果为 x 。 
//
// 返回 nums[n - 1] 可能的 最小 值。 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 3, x = 4 
// 
//
// 输出：6 
//
// 解释： 
//
// 数组 nums 可以是 [4,5,6] ，最后一个元素为 6 。 
//
// 示例 2： 
//
// 
// 输入：n = 2, x = 7 
// 
//
// 输出：15 
//
// 解释： 
//
// 数组 nums 可以是 [7,15] ，最后一个元素为 15 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n, x <= 10⁸ 
// 
//
// 👍 15 👎 0


/**
 * 数组最后一个元素的最小值
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-08-22 00:00:29 
 */
public class MinimumArrayEndSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minEnd(int n, int x) {
        // 数组所有元素在x是1的位上必须也是1，而剩下的位组成[0,n-1]就是最小化的符合条件的数组
        long res = x;
        for (int i = 0, j = n - 1; i < 63 && j > 0; i++) {
            if (((res >> i) & 1) == 0) {
                // 为0的位上取n-1的各位填充
                res |= (j & 1L) << i;
                j >>= 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
