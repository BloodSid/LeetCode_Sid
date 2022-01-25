package leetcode.editor.cn;

import java.util.*;

/**
 * 丑数 III
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-24 12:46:54
 */
public class UglyNumberIiiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    long a, b, c, abLCM, bcLCM, acLCM, abcLCM;

    public int nthUglyNumber(int n, int a, int b, int c) {
        int l = 1, r = (int) 2e9;
        this.a = a;
        this.b = b;
        this.c = c;
        abLCM = lcm(a, b);
        bcLCM = lcm(b, c);
        acLCM = lcm(a, c);
        abcLCM = lcm(abLCM, c);
        while (l < r) {
            int mid = l + (r - l >>> 1);
            if (getCnt(mid) < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // 计算小于等于n的丑数的个数
    int getCnt(int n) {
        return (int) (n / a + n / b + n / c - n / abLCM - n / acLCM - n / bcLCM + n / abcLCM);
    }

    // 辗转相除法 gcd(a,b)=gcd(b,a mod b) greatest common divisor
    long gcd(long a, long b) {
        long c = 0;
        while (b != 0) {
            c = b;
            b = a % b;
            a = c;
        }
        return a;
    }

    // 最小公倍数 least common multiple
    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
