package Contest0814.T2;

/**
 * @author IronSid
 * @since 2022-08-14 10:23
 */
public class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] sc = new long[n];
        for (int i = 0; i < edges.length; i++) {
            sc[edges[i]] += i;
        }
        long max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (sc[i] > max) {
                max = sc[i];
                res = i;
            }
        }
        return res;
    }
}
