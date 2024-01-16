package leetcode.editor.cn;
//给你两个数字字符串 num1 和 num2 ，以及两个整数 max_sum 和 min_sum 。如果一个整数 x 满足以下条件，我们称它是一个好整数： 
//
// 
// num1 <= x <= num2 
// min_sum <= digit_sum(x) <= max_sum. 
// 
//
// 请你返回好整数的数目。答案可能很大，请返回答案对 10⁹ + 7 取余后的结果。 
//
// 注意，digit_sum(x) 表示 x 各位数字之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "1", num2 = "12", min_num = 1, max_num = 8
//输出：11
//解释：总共有 11 个整数的数位和在 1 到 8 之间，分别是 1,2,3,4,5,6,7,8,10,11 和 12 。所以我们返回 11 。
// 
//
// 示例 2： 
//
// 
//输入：num1 = "1", num2 = "5", min_num = 1, max_num = 5
//输出：5
//解释：数位和在 1 到 5 之间的 5 个整数分别为 1,2,3,4 和 5 。所以我们返回 5 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1 <= num2 <= 10²² 
// 1 <= min_sum <= max_sum <= 400 
// 
//
// 👍 62 👎 0


import java.util.*;

/**
 * 统计整数数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-01-16 14:41:42 
 */
public class CountOfIntegersSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int M = (int) (1e9 + 7);
    private int minSum;
    private int maxSum;
    private char[] s;
    private long[][] dp;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        minSum = min_sum;
        maxSum = max_sum;
        // 计算 (nums1,nums2] 的结果
        long res = count(num2) - count(num1);
        // 计算 nums1 是否符合
        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += c & 15;
        }
        return (int) ((res + M + ((sum >= min_sum && sum <= max_sum) ? 1 : 0)) % M);
    }

    // 计算 [1,num] 的结果
    long count(String num) {
        s = num.toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] &= 15;
        }
        dp = new long[s.length][maxSum + 1];
        for (long[] longs : dp) {
            Arrays.fill(longs, -1);
        }
        return f(0, 0, true);
    }

    // f(i,sum) 表示前缀长度i，前缀和为sum的数字有多少个；limited 表示受上限num约束
    long f(int i, int sum, boolean limited) {
        // 大于上限直接返回0
        if (sum > maxSum) {
            return 0;
        }
        // 到达结尾时，不小于下限返回1
        if (i == s.length) return sum >= minSum ? 1 : 0;
        // 计算过的直接返回记忆中的结果
        if (!limited && dp[i][sum] != -1) return dp[i][sum];
        long res = 0;
        // 记忆化
        int up = limited ? s[i] : 9;
        for (int d = 0; d <= up; d++) {
            res += f(i + 1, sum + d, limited && d == s[i]);
        }
        res %= M;
        if (!limited) dp[i][sum] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
