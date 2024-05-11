package Contest0511.T2;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-05-11 21:53
 */
public class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> getR(points[a]) - getR(points[b]));
        char[] c = s.toCharArray();
        int[] f = new int[128];
        int i;
        for (i = 0; i < n; i++) {
            f[c[idx[i]]]++;
            if (f[c[idx[i]]] > 1) {
                break;
            }
        }
        if (i == n) return n;
        int r = getR(points[idx[i]]);
        // 退掉不合法半边长的点
        while (i >= 0 && getR(points[idx[i]]) == r) {
            i--;
        }
        return i + 1;
    }

    int getR(int[] p) {
        return Math.max(Math.abs(p[1]), Math.abs(p[0]));
    }
}
