package Contest0609.T2;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-06-09 10:43
 */
public class Solution {

    public static final int MOD = (int) (1e9+7);

    public int valueAfterKSeconds(int n, int k) {
        long[] res = new long[n];
        Arrays.fill(res, 1);
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = (res[j] + res[j - 1]) % MOD;
            }
        }
        return (int) res[n - 1];
    }
}
