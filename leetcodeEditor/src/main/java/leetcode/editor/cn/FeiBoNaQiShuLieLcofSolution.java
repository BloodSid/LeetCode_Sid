package leetcode.editor.cn;
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 226 👎 0


import java.util.*;

/**
 * 斐波那契数列
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-09-04 23:28:11
 */
public class FeiBoNaQiShuLieLcofSolution {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n < 3) {
                return 1;
            }
            int a = 1;
            int b = 1;
            int c = 0;
            for (int i = 2; i < n; i++) {
                c = (a + b) % 1000000007;
                a = b;
                b = c;
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
