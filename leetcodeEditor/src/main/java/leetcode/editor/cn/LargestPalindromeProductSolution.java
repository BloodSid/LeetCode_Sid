package leetcode.editor.cn;

/**
 * 最大回文数乘积
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-16 00:37:19
 */
public class LargestPalindromeProductSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestPalindrome(int n) {
        // 3 * 3 = 9
        if (n == 1) return 9;
        long a = (long) Math.pow(10, n);
        // 例如 99 * 99 = 9801 所以从97开始穷举
        for (long i = a - 3; i >= 10; i--) {
            // 反转 i 作为 p 的后半部分
            long p = 0;
            for (long t = i; t > 0; t /= 10) {
                p *= 10;
                p += t % 10;
            }
            // 加上前半部分
            p += i * a;
            // p 除以 i 得 a 余 i 的反转，所以要穷举比 i 更大的数
            for (long j = i + 1; j < a; j++) {
                if (p % j == 0) {
                    return (int) (p % 1337);
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
