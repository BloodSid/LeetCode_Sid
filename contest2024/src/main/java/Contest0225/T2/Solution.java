package Contest0225.T2;

/**
 * @author IronSid
 * @since 2024-02-25 10:31
 */
public class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x1 = bottomLeft[i][0], y1 = bottomLeft[i][1];
            int x2 = topRight[i][0], y2 = topRight[i][1];
            for (int j = i + 1; j < n; j++) {
                int x3 = bottomLeft[j][0], y3 = bottomLeft[j][1];
                int x4 = topRight[j][0], y4 = topRight[j][1];
                max = Math.max(max, Math.min(intersect(x1, x2, x3, x4), intersect(y1, y2, y3, y4)));
            }
        }
        return (long) max * max;
    }

    int intersect(int l1, int r1, int l2, int r2) {
        return Math.max(0, Math.min(r1, r2) - Math.max(l1, l2));
    }
}
