/**
 * https://leetcode-cn.com/problems/sudoku-solver/
 *
 * @author IronSid
 * @create 2021-06-30 12:21
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='.')
                    board[i][j]=0;
                else
                    board[i][j]-='0';
            }
        }
        dfsWrite(board,0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                    board[i][j]+='0';
            }
        }
    }
    //true 表示不会产生矛盾 false 表示会产生矛盾
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

    //dfs写数字
    boolean dfsWrite(char[][] s,int index) {
        //递归终止标记
        if (index == 81) return true;
        int x = index / 9, y = index % 9;

        //若该格子已填则跳过
        if (s[x][y] != 0) return dfsWrite(s,index + 1);

        //若未填则遍历该格子的列表
        for (int num = 1; num <= 9; num++) {
            s[x][y] = (char) num;
            if (check(s,index) && dfsWrite(s,index + 1))
                return true;
            else
                s[x][y] = 0;
        }
        //遍历之后，没有成功填数则返回false
        return false;
    }

}
