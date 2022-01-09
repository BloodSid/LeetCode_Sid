package leetcode.editor.cn;

import java.util.*;

/**
 * 矩阵中的路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-09 17:26:30
 */
public class JuZhenZhongDeLuJingLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    char[][] board;
    int m;
    int n;
    char[] arr;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        arr = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == arr[0]) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(int i, int j, int index) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (board[i][j] != arr[index]) {
            return false;
        }
        if (index == arr.length - 1) {
            return true;
        }
        board[i][j] = 0;
        for (int[] direction : directions) {
            if (dfs(i + direction[0], j + direction[1], index + 1)) {
                return true;
            }
        }
        board[i][j] = arr[index];
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
