package leetcode.editor.cn;
//给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。 
//
// 返回执行此操作后，grid 中最大的岛屿面积是多少？ 
//
// 岛屿 由一组上、下、左、右四个方向相连的 1 形成。 
//
// 
//
// 示例 1: 
//
// 
//输入: grid = [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。 
//
// 示例 3: 
//
// 
//输入: grid = [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 500 
// grid[i][j] 为 0 或 1 
// 
// 👍 274 👎 0


import java.util.HashSet;

/**
 * 最大人工岛
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-18 22:18:09 
 */
public class MakingALargeIslandSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] p;
    private int[] w;

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        w = new int[m * n];
        int cnt = 0;
        // 初始化
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i * n + j] = i * n + j;
                w[i * n + j] = grid[i][j];
                cnt += grid[i][j];
            }
        }
        // 全是陆地
        if (cnt == m * n) return m * n;
        // 并查集
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                int cur = i * n + j;
                if (i < m - 1 && grid[i + 1][j] == 1) union(cur, i * n + j + n);
                if (j < n - 1 && grid[i][j + 1] == 1) union(cur, i * n + j + 1);
            }
        }
        // 遍历所有的海洋，计算把该海洋格周围的陆地合并之后的大小
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int sum = 1;
                    set.clear();
                    if (i > 0) {
                        int up = find(i * n + j - n);
                        if (set.add(up)) sum += w[up];
                    }
                    if (j > 0) {
                        int left = find(i * n + j - 1);
                        if (set.add(left)) sum += w[left];
                    }
                    if (i < m - 1) {
                        int down = find(i * n + j + n);
                        if (set.add(down)) sum += w[down];
                    }
                    if (j < n - 1) {
                        int right = find(i * n + j + 1);
                        if (set.add(right)) sum += w[right];
                    }
                    max = Math.max(max, sum);

                }
            }
        }
        return max;
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        // 若两根相等，说明已经联通，不能再联
        if (rootA == rootB) return;
        if (w[rootA] > w[rootB]) {
            p[rootB] = rootA;
            w[rootA] += w[rootB];
        } else {
            p[rootA] = rootB;
            w[rootB] += w[rootA];
        }
    }

    int find(int a) {
        if (p[a] != a) p[a] = find(p[a]);
        return p[a];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
