package leetcode.editor.cn;
//给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。 
//
// 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。 
//
// 
//
// 示例 1： 
//
// 输入：a = 12, b = 6
//输出：4
//解释：12 和 6 的公因子是 1、2、3、6 。
// 
//
// 示例 2： 
//
// 输入：a = 25, b = 30
//输出：2
//解释：25 和 30 的公因子是 1、5 。 
//
// 
//
// 提示： 
//
// 
// 1 <= a, b <= 1000 
// 
//
// 👍 13 👎 0


import java.util.HashMap;

/**
 * 公因子的数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-05 01:03:36 
 */
public class NumberOfCommonFactorsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int commonFactors(int a, int b) {
        int gcd = gcd(a, b);
        int cnt = 1;
        for (Integer c : primeFactorization(gcd).values()) {
            cnt *= c + 1;
        }
        return cnt;
    }

    int gcd(int a, int b) {
        // gcd(a,b) = gcd(b, a mod b)
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // 分解质因数，用哈希表记录结果
    HashMap<Integer, Integer> primeFactorization(int n) {
        HashMap<Integer, Integer> f = new HashMap<>();
        // 时间复杂度O(sqrt(n))
        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                f.put(i, f.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        // 若只有一个质因子，但是这个质因子出现多次，那么这里的n可能为1
        if (n != 1) f.put(n, f.getOrDefault(n, 0) + 1);
        return f;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
