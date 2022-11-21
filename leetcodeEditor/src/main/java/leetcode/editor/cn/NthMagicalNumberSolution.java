package leetcode.editor.cn;
//一个正整数如果能被 a 或 b 整除，那么它是神奇的。 
//
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1, a = 2, b = 3
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 2 <= a, b <= 4 * 10⁴ 
// 
//
// 
// 👍 109 👎 0


/**
 * 第 N 个神奇数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-22 00:23:45 
 */
public class NthMagicalNumberSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int nthMagicalNumber(int n, int a, int b) {
        long gcd = (long) a * b / gcd(a, b);
        // 二分搜索
        long l = 1, r = (long) 4e13;
        while (l <= r) {
            long mid = l + r >> 1;
            // 容斥原理计算 小于等于 mid 的数中有多少个“神奇数字”
            if (mid / a + mid / b - mid / gcd >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) (l % MOD);
    }

    long gcd(long a, long b) {
        // gcd(a, b) = gcd(b, a % b)
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
