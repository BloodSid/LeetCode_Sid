package leetcode.editor.cn;
//给你两个 正整数 l 和 r。对于任何数字 x，x 的所有正因数（除了 x 本身）被称为 x 的 真因数。 
//
// 如果一个数字恰好仅有两个 真因数，则称该数字为 特殊数字。例如： 
//
// 
// 数字 4 是 特殊数字，因为它的真因数为 1 和 2。 
// 数字 6 不是 特殊数字，因为它的真因数为 1、2 和 3。 
// 
//
// 返回区间 [l, r] 内 不是 特殊数字 的数字数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入： l = 5, r = 7 
// 
//
// 输出： 3 
//
// 解释： 
//
// 区间 [5, 7] 内不存在特殊数字。 
//
// 示例 2： 
//
// 
// 输入： l = 4, r = 16 
// 
//
// 输出： 11 
//
// 解释： 
//
// 区间 [4, 16] 内的特殊数字为 4 和 9。 
//
// 
//
// 提示： 
//
// 
// 1 <= l <= r <= 10⁹ 
// 
//
// 👍 38 👎 0


/**
 * 统计不是特殊数字的数字数量
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-11-22 22:06:04 
 */
public class FindTheCountOfNumbersWhichAreNotSpecialSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int MX = 32000;
    private static final int[] p = new int[MX + 1];
    static {
        for (int i = 2; i <= MX; i++) {
            if (p[i] == 0){
                // 质数
                p[i] = p[i-1]+1;
                for (int j = i * i; j <= MX; j += i) {
                    // 标记为合数
                    p[j] = -1;
                }
            } else {
                // 合数
                p[i] = p[i-1];
            }
        }
    }

    public int nonSpecialCount(int l, int r) {
        return r - l + 1 - (p[(int) Math.sqrt(r)] - p[(int) Math.sqrt(l - 1)]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
