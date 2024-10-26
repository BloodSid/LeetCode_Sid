package Contest0609.T4;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-06-09 10:43
 */
public class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int m = 0;
        // 贪心，最后一步选最大值。证明：如果存在其他答案选x更优，由于x<m,则可以换x为m而更优，矛盾。
        for (int r : rewardValues) {
            m = Math.max(m, r);
        }
        for (int r : rewardValues) {
            if (r == m - 1) {
                // m 之前最多取到 m-1，如果m-1存在则可以直接选择
                return 2 * m - 1;
            }
        }
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
