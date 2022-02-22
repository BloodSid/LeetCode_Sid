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
    int m, n;
    int[][] grid1;
    int[][] grid2;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        p = new int[m * n];
        this.grid1 = grid1;
        this.grid2 = grid2;
        // 并查集，对grid2的相连陆地进行合并
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    p[i * n + j] = i * n + j;
                } else {
                    p[i * n + j] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (i < m - 1 && grid2[i + 1][j] == 1) union(i * n + j, (i + 1) * n + j);
                    if (j < n - 1 && grid2[i][j + 1] == 1) union(i * n + j, i * n + j + 1);
                }
            }
        }
        // 记录连通分量的根节点
        HashSet<Integer> islands = new HashSet<>();
        HashSet<Integer> notSub = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    int cur = i * n + j;
                    int root = find(cur);
                    if (root == cur) {
                        islands.add(root);
                    }
                    if (grid1[i][j] == 0) {
                        notSub.add(root);
                    }
                }
            }
        }
        islands.removeAll(notSub);
        return islands.size();
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            p[rootB] = rootA;
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
