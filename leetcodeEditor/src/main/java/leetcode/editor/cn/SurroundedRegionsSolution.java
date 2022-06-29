package leetcode.editor.cn;
//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// 👍 819 👎 0


/**
 * 被围绕的区域
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-29 18:43:55 
 */
public class SurroundedRegionsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int N = 200 * 200;
    private int[][] q = new int[N][];

    public void solve(char[][] board) {
        int tail = 0, head = 0;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'X';
                q[head++] = new int[]{i, 0};
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = 'X';
                q[head++] = new int[]{i, n - 1};
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'X';
                q[head++] = new int[]{0, i};
            }
            if (board[m - 1][i] == 'O') {
                board[m - 1][i] = 'X';
                q[head++] = new int[]{m - 1, i};
            }
        }
        while (tail < head) {
            int size = head;
            for (; tail < size; tail++) {
                int[] cur = q[tail];
                int x = cur[0], y = cur[1];
                if (x + 1 < m && board[x + 1][y] == 'O') {
                    board[x + 1][y] = 'X';
                    q[head++] = new int[]{x + 1, y};
                }
                if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                    board[x - 1][y] = 'X';
                    q[head++] = new int[]{x - 1, y};
                }
                if (y + 1 < n && board[x][y + 1] == 'O') {
                    board[x][y + 1] = 'X';
                    q[head++] = new int[]{x, y + 1};
                }
                if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                    board[x][y - 1] = 'X';
                    q[head++] = new int[]{x, y - 1};
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        for (int i = 0; i < tail; i++) {
            int x = q[i][0], y = q[i][1];
            board[x][y] = 'O';
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
