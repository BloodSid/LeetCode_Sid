/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * @author IronSid
 * @create 2021-06-30 12:36
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!check(board, i * 9 + j))
                        return false;
                }
            }
        }
        return true;
    }

    boolean check(char[][] s, int index) {
        int x = index / 9, y = index % 9;
        for (int i = 0; i < 9; i++) {
            if (i != y && s[x][i] == s[x][y]) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i != x && s[i][y] == s[x][y]) {
                return false;
            }
        }
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (i != x || j != y) {
                    if (s[i][j] == s[x][y]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
