package Contest0507_1.T3;

import java.util.*;

/**
 * @author IronSid
 * @since 2023-05-07 14:59
 */
public class Solution {
    static int[][] dirs = {{0, 0}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int extractMantra(String[] matrix, String mantra) {
        char[][] g = new char[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            g[i] = matrix[i].toCharArray();
        }
        char[] c = mantra.toCharArray();
        int m = g.length;
        int n = g[0].length;
        // x, y, ci。ci表示待抓取的字符位置。这样保证每格的进入次数是有限的，避免重复搜索。
        Deque<int[]> pq = new ArrayDeque<>();
        pq.offer(new int[]{0, 0, 0});
        boolean[][][] vis = new boolean[m][n][c.length + 1];
        vis[0][0][0] = true;
        int p = 0;
        while (!pq.isEmpty()) {
            for (int size = pq.size(); size > 0; size--) {
                int[] poll = pq.poll();
                int x = poll[0], y = poll[1], ci = poll[2];
                if (ci == c.length) {
                    return p;
                }
                // 每一步向周围的4格走，或者原地不动
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    //  是否抓取
                    boolean flag = x == nx && y == ny && c[ci] == g[nx][ny];
                    int nci = ci + (flag ? 1 : 0);
                    if (vis[nx][ny][nci]) continue;
                    pq.offer(new int[]{nx, ny, nci});
                    vis[nx][ny][nci] = true;
                }

            }
            p++;
        }
        return -1;
    }
}
