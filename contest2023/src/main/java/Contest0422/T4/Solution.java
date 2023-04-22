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
    private int sx;
    private int sy;
    private int tx;
    private int ty;
    private char[][] g;
    private boolean[][] vis;
    private int[][] res;
    private int[][] dist;

    public int challengeOfTheKeeper(String[] maze) {
        for (String s : maze) {
            System.out.println(s);
        }
        m = maze.length;
        n = maze[0].length();
        g = new char[m][];
        for (int i = 0; i < m; i++) {
            g[i] = maze[i]. toCharArray();
        }
        sx = 0;
        sy = 0;
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
        dist = new int[m][n];
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
        // 找一条终点是最大值，且最大值最小的路径
        vis = new boolean[m][n];
        res = new int[m][n];
        vis[sx][sy] = true;
        int min = dfs(tx, ty);
        return min < INF ? min : -1;
    }

    int dfs(int x, int y) {
        if (vis[x][y]) {
            return res[x][y];
        }
        vis[x][y] = true;
        int re = INF;
        for (int[] dir : DIRS) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && g[nx][ny] != '#' && dist[nx][ny] > dist[x][y]) {
                re = Math.min(re, dfs(nx, ny));
            }
        }

        re = Math.max(re, trans[x][y]);
        res[x][y] = re;
        return re;
    }

}