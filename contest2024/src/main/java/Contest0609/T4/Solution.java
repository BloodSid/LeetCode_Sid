package Contest0609.T4;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-06-09 10:43
 */
public class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        // bits的第i低位表示f[i], 即表示总 i 奖励是否可以取到，f[0] = 1
        BigInteger bits = BigInteger.ONE;
        for (int i = 0; i < rewardValues.length; i++) {
            if (i > 0 && rewardValues[i] == rewardValues[i - 1]) {
                // 不会取到两个相同的奖励
                continue;
            }
            int v = rewardValues[i];
            // 取或不取 : f[j] = f[j] | f[j-v]
            // 取 f 的低 v 位，再左移 v 位 f |= (((1 << v) - 1) & f) << v;
            bits = bits.or(BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE).and(bits).shiftLeft(v));
        }
        // f[v]=1 的最大值即为最大奖励
        return bits.bitLength() - 1;
    }
}
