package leetcode.editor.cn;
//一个 n x n 的二维网络 board 仅由 0 和 1 组成 。每次移动，你能任意交换两列或是两行的位置。 
//
// 返回 将这个矩阵变为 “棋盘” 所需的最小移动次数 。如果不存在可行的变换，输出 -1。 
//
// “棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
//输出: 2
//解释:一种可行的变换方式如下，从左到右：
//第一次移动交换了第一列和第二列。
//第二次移动交换了第二行和第三行。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: board = [[0, 1], [1, 0]]
//输出: 0
//解释: 注意左上角的格值为0时也是合法的棋盘，也是合法的棋盘.
// 
//
// 示例 3: 
//
// 
//
// 
//输入: board = [[1, 0], [1, 0]]
//输出: -1
//解释: 任意的变换都不能使这个输入变为合法的棋盘。
// 
//
// 
//
// 提示： 
//
// 
// n == board.length 
// n == board[i].length 
// 2 <= n <= 30 
// board[i][j] 将只包含 0或 1 
// 
// 👍 89 👎 0


/**
 * 变为棋盘
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-23 09:46:23 
 */
public class TransformToChessboardSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) cnt += board[0][i];
        // 每行，列 01 的数量必一致或差一
        if (cnt != n / 2 && !(n % 2 == 1 && cnt == n / 2 + 1)) return -1;
        cnt = 0;
        for (int i = 0; i < n; i++) cnt += board[i][0];
        if (cnt != n / 2 && !(n % 2 == 1 && cnt == n / 2 + 1)) return -1;

        // 任意两行要么全部一致，要么全部相反；列也一样
        // 给每行每列一个标记，和首行首列一致的为 0, 相反的为 1
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 1; i < n; i++) {
            boolean isEqual = board[0][0] == board[i][0];
            for (int j = 1; j < n; j++) {
                if ((board[0][j] == board[i][j]) != isEqual) return -1;
            }
            row[i] = isEqual ? 0 : 1;
        }
        for (int i = 1; i < n; i++) {
            boolean isEqual = board[0][0] == board[0][i];
            for (int j = 1; j < n; j++) {
                if ((board[j][0] == board[j][i]) != isEqual) return -1;
            }
            col[i] = isEqual ? 0 : 1;
        }

        // 两种行的数量必须也一致或差一
        int cntRow = 0;
        for (int i = 0; i < n; i++) cntRow += row[i];
        if (cntRow != n / 2 && !(n % 2 == 1 && cntRow == n / 2 + 1)) return -1;
        int cntCol = 0;
        for (int i = 0; i < n; i++) cntCol += col[i];
        if (cntCol != n / 2 && !(n % 2 == 1 && cntCol == n / 2 + 1)) return -1;

        // 把两种行列交错排列就得到棋盘
        int ops = 0;
        if (n % 2 == 0) {
            int swap = 0;
            for (int i = 0; i < n; i += 2) swap += row[i];
            // 把 swap 中的 ‘1’ 行交换， 或者把 swap 外的 ‘1’ 行交换
            ops += Math.min(swap, n / 2 - swap);
            swap = 0;
            for (int i = 0; i < n; i += 2) swap += col[i];
            ops += Math.min(swap, n / 2 - swap);
        } else {
            int swap = 0;
            for (int i = cntRow == n / 2 ? 0 : 1; i < n; i += 2) swap += row[i];
            for (int i = cntCol == n / 2 ? 0 : 1; i < n; i += 2) swap += col[i];
            ops += swap;
        }
        return ops;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
