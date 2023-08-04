package leetcode.editor.cn;
//在二维网格 grid 上，有 4 种类型的方格： 
//
// 
// 1 表示起始方格。且只有一个起始方格。 
// 2 表示结束方格，且只有一个结束方格。 
// 0 表示我们可以走过的空方格。 
// -1 表示我们无法跨越的障碍。 
// 
//
// 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。 
//
// 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//输出：2
//解释：我们有以下两条路径：
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) 
//
// 示例 2： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//输出：4
//解释：我们有以下四条路径： 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3) 
//
// 示例 3： 
//
// 输入：[[0,1],[2,0]]
//输出：0
//解释：
//没有一条路能完全穿过每一个空的方格一次。
//请注意，起始和结束方格可以位于网格中的任意位置。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length * grid[0].length <= 20 
// 
//
// 👍 310 👎 0


/**
 * 不同路径 III
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-08-04 23:51:40 
 */
public class UniquePathsIiiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int m, n, mask, tx, ty;
    private int[][] grid;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        mask = (1 << (m * n)) - 1;
        this.grid = grid;
        int sx = 0, sy = 0;
        int status = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    tx = i;
                    ty = j;
                    // 终点也是可以走的位置
                    grid[i][j] = 0;
                } else if (grid[i][j] == -1) {
                    // 标记有障碍的位置
                    status |= 1 << offset(i, j);
                }
            }
        }
        return dfs(sx, sy, status);
    }

    int dfs(int i, int j, int status) {
        status |= 1 << offset(i, j);
        if (i == tx && j == ty && status == mask) {
            return 1;
        }
        int res = 0;
        grid[i][j] = 1;
        for (int[] dir : DIRS) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            // 无视障碍和已经经过的格子
            if (grid[x][y] != 0) continue;
            res += dfs(x, y, status);
        }
        grid[i][j] = 0;
        return res;
    }

    int offset(int x, int y) {
        return x * n + y;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
