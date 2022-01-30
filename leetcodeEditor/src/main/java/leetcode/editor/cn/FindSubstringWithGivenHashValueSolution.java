package leetcode.editor.cn;

import java.util.*;

/**
 * 查找给定哈希值的子串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-30 14:02:09
 */
public class FindSubstringWithGivenHashValueSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        char[] chr = s.toCharArray();
        for (int i = 0; i < chr.length; i++) {
            chr[i] -= 'a' - 1;
        }
        for (int i = 0; i + k - 1 < n; i++) {
            long temp = 0;
            for (int j = 0; j < k; j++) {
                temp += (long) chr[i + j] * powWithMod(power, j, modulo);
                temp %= modulo;
            }
            if (temp == hashValue) {
                return s.substring(i, i + k);
            }
        }
        return "";
    }

    int powWithMod(int base, int power, int mod) {
        if (power == 0) {
            return 1;
        }
        if (base >= mod) {
            return powWithMod(base % mod, power, mod);
        }
        long res = 1;
        for (; power > 0; power >>= 1) {
            if ((power & 1) == 1) {
                res *= base;
            }
            res %= mod;
            base = (int) (((long) base * base) % mod);
        }
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
