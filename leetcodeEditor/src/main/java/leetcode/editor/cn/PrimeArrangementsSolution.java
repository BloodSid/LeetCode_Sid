package leetcode.editor.cn;
//请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。 
//
// 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。 
//
// 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：12
//解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
// 
//
// 示例 2： 
//
// 输入：n = 100
//输出：682289015
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
// 👍 47 👎 0


/**
 * 质数排列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-30 00:04:30 
 */
public class PrimeArrangementsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int numPrimeArrangements(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) cnt++;
        }
        return (int) (factorial(cnt) * factorial(n - cnt) % MOD);

    }

    boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }

    // 计算阶乘
    long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i % MOD;
        }
        return fact;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
