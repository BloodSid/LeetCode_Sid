package Contest0904.T2;

import java.math.BigInteger;

/**
 * @author IronSid
 * @since 2022-09-04 10:28
 */
public class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int numberOfWays(int startPos, int endPos, int k) {
        int diff = Math.abs(endPos - startPos);
        if (k < diff || (k - diff) % 2 == 1) return 0;
        return combination((k - diff) / 2, k);
    }

    int combination(int a, int b) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = b - a + 1, j = 1; i <= b; i++, j++) {
            res = res.multiply(BigInteger.valueOf(i)).divide(BigInteger.valueOf(j));
        }
        return res.divideAndRemainder(BigInteger.valueOf(MOD))[1].intValue();
    }
}