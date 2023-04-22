package Contest0422.T4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author IronSid
 * @since 2023-04-22 14:59
 */
public class Solution {

    public static final int INF = (int) (1e9 + 7);
    public static final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] trans;
    private int m;
    private int n;
    private int tx;
    private int ty;
    private char[][] g;
    private boolean[][] vis;

    public int challengeOfTheKeeper(String[] maze) {
        m = maze.length;
        n = maze[0].length();
        g = new char[m][];
        for (int i = 0; i < m; i++) {
            g[i] = maze[i]. toCharArray();
        }
        int sx = 0;
        int sy = 0;
        tx = 0;
        ty = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (g[i][j] == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }
        vis = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[m][n];
        for (int[] ints : dist) {
            Arrays.fill(ints, INF);
        }
        vis[tx][ty] = true;
        dist[tx][ty] = 0;
        q.offer(new int[]{tx, ty});
        for (int d = 1; !q.isEmpty(); d++) {
            for (int size = q.size(); size > 0; size--) {
                int[] poll = q.poll();
                int x = poll[0], y = poll[1];
                for (int[] dir : DIRS) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && g[nx][ny] != '#' && !vis[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        dist[nx][ny] = d;
                        vis[nx][ny] = true;
                    }
                }
            }
        }
        // 传送后的距离
        trans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                trans[i][j] = -1;
                if (g[i][j] != '.') continue;
                int[][] ps = {{i, n - j - 1}, {m - i - 1, j}};
                int max = 0;
                for (int pi = 0; pi < 2; pi++) {
                    int[] p = ps[pi];
                    if (g[p[0]][p[1]] == '#') continue;
                    max = Math.max(max, dist[p[0]][p[1]]);
                }
                trans[i][j] = max;
            }
        }
        if (dist[sx][sy] == INF) return -1;
        // 二分路径求路径上最大值的最小值
        int l = 0, r = INF;
        while (l <= r) {
            int mid = l + r >> 1;
            vis = new boolean[m][n];
            boolean flag = dfs(sx, sy, mid);
            if (flag) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int min = l;
        return min < INF ? min : -1;
    }

    boolean dfs(int x, int y, int max) {
        vis[x][y] = true;
        if (x == tx && y == ty) {
            return true;
        }
        if (trans[x][y] > max) {
            return false;
        }
        for (int[] dir : DIRS) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && g[nx][ny] != '#' && !vis[nx][ny]) {
                if (dfs(nx, ny, max)) {
                    return true;
                }
            }
        }
        return false;
    }

}