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
    char[][] grid;

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                islandCount += bfs(i, j);
            }
        }
        return islandCount;
    }

    int bfs(int line, int column) {
        if (grid[line][column] != '1') {
            return 0;
        } else {
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{line, column});
            grid[line][column]++;
            while (!queue.isEmpty()) {
                int[] head = queue.poll();
                for (int[] next : getNext(head)) {
                    if (grid[next[0]][next[1]] == '1') {
                        queue.offer(next);
                        grid[next[0]][next[1]]++;
                    }
                }
            }
        }
        return 1;
    }

    int[][] offsets = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    List<int[]> getNext(int[] curr) {
        List<int[]> next = new ArrayList<>(4);
        for (int[] offset : offsets) {
            int line = offset[0] + curr[0];
            int col = offset[1] + curr[1];
            if (line >= 0 && line < grid.length && col >= 0 && col < grid[0].length) {
                next.add(new int[]{line, col});
            }
        }
        return next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
