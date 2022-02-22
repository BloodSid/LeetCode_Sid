package leetcode.editor.cn;

import java.util.*;

/**
 * 统计子岛屿
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-22 16:34:40
 */
public class CountSubIslandsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] p;
    int[] rank;
    int m, n;
    int[][] grid1;
    int[][] grid2;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        p = new int[m * n];
        rank = new int[m * n];
        this.grid1 = grid1;
        this.grid2 = grid2;
        // 并查集，对grid1的相连陆地进行合并
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 1) {
                    p[i * n + j] = i * n + j;
                } else {
                    p[i * n + j] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 1) {
                    if (i < m - 1 && grid1[i + 1][j] == 1) union(i * n + j, (i + 1) * n + j);
                    if (j < n - 1 && grid1[i][j + 1] == 1) union(i * n + j, i * n + j + 1);
                }
            }
        }
        // 对grid2进行dfs, 如果以a为起点的一次搜索中，搜到了在grid1中与a不处于同一个联通分量的格子，则该岛屿不是子岛屿
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(i, j, i * n + j)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    // 进行bfs的同时判断是否是子岛屿
    boolean dfs(int i, int j, int source) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return true;
        }
        if (grid2[i][j] == 0) {
            return true;
        }
        grid2[i][j] = 0;
        // 若与源点不是一个连通分量则不是子岛屿
        // 若在grid1中是海洋则不是子岛屿
        boolean isSubIsland = grid1[i][j] == 1 && find(i * n + j) == find(source);
        boolean d = dfs(i, j + 1, source);
        boolean u = dfs(i, j - 1, source);
        boolean r = dfs(i + 1, j, source);
        boolean l = dfs(i - 1, j, source);
        return isSubIsland && d && u && r && l;
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                p[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                p[rootA] = rootB;
            } else {
                rank[rootA]++;
                p[rootB] = rootA;
            }
        }
    }

    int find(int a) {
        if (p[a] == -1) {
            return -1;
        }
        // 路径压缩
        if (p[a] != a) {
            p[a] = find(p[a]);
        }
        return p[a];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
