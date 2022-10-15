package Contest1015.T2;

/**
 * @author IronSid
 * @since 2022-10-15 22:31
 */
public class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int[] productQueries(int n, int[][] queries) {
        int[] pows = new int[32];
        int p = 0;
        while (n > 0) {
            pows[p++] = Integer.lowestOneBit(n);
            n &= n - 1;
        }
        int[] res = new int[queries.length];
        p = 0;
        for (int[] query : queries) {
            int left = query[0], right = query[1];
            long t = 1;
            for (; left <= right; left++) {
                t = t * pows[left] % MOD;
            }
            res[p++] = (int) t;
        }
        return res;
    }
}
