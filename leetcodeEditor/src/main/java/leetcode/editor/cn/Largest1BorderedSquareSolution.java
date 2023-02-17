package leetcode.editor.cn;
//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// 👍 138 👎 0


/**
 * 最大的以 1 为边界的正方形
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-02-17 10:28:39 
 */
public class Largest1BorderedSquareSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 分别记录 {i, j} 在右左上下方向上连续1的个数
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0, t = 0; j < n; j++) {
                if (grid[i][j] == 1) t++; else t = 0;
                left[i][j] = t;
            }
            for (int j = n - 1, t = 0; j >= 0; j--) {
                if (grid[i][j] == 1) t++; else t = 0;
                right[i][j] = t;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0, t = 0; i < m; i++) {
                if (grid[i][j] == 1) t++; else t = 0;
                up[i][j] = t;
            }
            for (int i = m - 1, t = 0; i >= 0; i--) {
                if (grid[i][j] == 1) t++; else t = 0;
                down[i][j] = t;
            }
        }
        int mx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                mx = Math.max(mx, 1);
                for (int k = i + 1, l = j + 1, len = 2; len <= Math.min(right[i][j], down[i][j]); k++, l++, len++) {
                    if (grid[k][l] == 0) continue;
                    if (right[i][j] >= len && down[i][j] >= len && left[k][l] >= len && up[k][l] >= len) {
                        mx = Math.max(mx, len);
                    }
                }
            }
        }
        return mx * mx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
