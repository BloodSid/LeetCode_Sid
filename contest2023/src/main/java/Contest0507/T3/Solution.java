package Contest0507.T3;

/**
 * @author IronSid
 * @since 2023-05-07 10:38
 */
public class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] c = new int[n];
        int[] res = new int[queries.length];
        int cnt = 0;
        int pr = 0;
        for (int[] qi : queries) {
            int i = qi[0], color = qi[1];
            int d = sameNeighbor(c, i);
            c[i] = color;
            d = sameNeighbor(c, i) - d;
            cnt += d;
            res[pr++] = cnt;
        }
        return res;
    }

    int sameNeighbor(int[] a, int i) {
        if (a[i] == 0) return 0;
        int cnt = 0;
        if (i > 0 && a[i] == a[i - 1]) cnt++;
        if (i < a.length - 1 && a[i] == a[i + 1]) cnt++;
        return cnt;
    }
}
