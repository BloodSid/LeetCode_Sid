package Contest1209.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-12-09 22:16
 */
public class Solution {

    public static final int INF = (int) (1e9 + 7);

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int res = 0;
        // 状态压缩，bit位为1的表示存在
        loop:
        for (int mask = 0; mask < 1 << n; mask++) {
            int[][] d = new int[n][n];
            for (int[] di : d) {
                Arrays.fill(di, INF);
            }
            for (int[] r : roads) {
                int u = r[0], v = r[1], w = r[2];
                if (contains(mask, u) && contains(mask, v)) {
                    // 两点之间可能有多条边
                    d[u][v] = Math.min(d[u][v], w);
                    d[v][u] = Math.min(d[u][v], w);
                }
            }
            // 多源最短路
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (contains(mask, i) && contains(mask, j)) {
                        if (d[i][j] > maxDistance) continue loop;
                    }
                }
            }
            res++;
        }
        return res;
    }

    boolean contains(int mask, int idx) {
        return (mask & (1 << idx)) != 0;
    }
}
