package leetcode.editor.cn;

import java.util.*;

/**
 * 岛屿的最大面积
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-21 22:20:09
 */
public class MaxAreaOfIslandSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] p;
    private int max;
    private int[] cnt;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        cnt = new int[m * n];
        max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    p[i * n + j] = i * n + j;
                    cnt[i * n + j] = 1;
                    max = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            union(i * n + j, ni * n + nj);
                        }
                    }
                }
            }
        }
        return max;
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            p[rootB] = rootA;
            cnt[rootA] += cnt[rootB];
            max = Math.max(max, cnt[rootA]);
        }
    }

    int find(int i) {
        if (p[i] != i) {
            return find(p[i]);
        }
        return p[i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
