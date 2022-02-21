package leetcode.editor.cn;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1342 👎 0


import java.util.*;

/**
 * 岛屿数量
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-09-19 23:22:02
 */
public class NumberOfIslandsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] p;
    int[] r;
    int count;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[n * m];
        r = new int[n * m];
        count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    p[i * n + j] = i * n + j;
                    count++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == '1') {
                            union(i * n + j, ni * n + nj);
                        }
                    }
                }
            }
        }
        return count;
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (r[a] > r[b]) {
                p[rootB] = rootA;
            } else if (r[a] < r[b]) {
                p[rootA] = rootB;
            } else {
                r[a]++;
                p[rootB] = rootA;
            }
            count--;
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
