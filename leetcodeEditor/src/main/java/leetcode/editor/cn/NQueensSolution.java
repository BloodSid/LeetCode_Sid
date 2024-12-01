package leetcode.editor.cn;
//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// 👍 2203 👎 0


import java.util.*;

/**
 * N 皇后
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-12-02 00:45:02 
 */
public class NQueensSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] plate = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(0, new int[]{i, j}, plate, res);
            }
        }
        return res;
    }

    void dfs(int k, int[] pos, int[][] plate, List<List<String>> res) {
        int n = plate.length;
        plate[pos[0]][pos[1]] = 1;
        k++;
        if (k == n) {
            writeRes(plate, res);
        } else {
            int[] tempPos = {pos[0], n - 1};
            while (hasNext(tempPos, n)) {
                nextPos(tempPos, n);
                if (isValid(tempPos, plate)) {
                    dfs(k, tempPos, plate, res);
                }
            }
        }
        plate[pos[0]][pos[1]] = 0;
    }

    void writeRes(int[][] plate, List<List<String>> res) {
        List<String> lines = new ArrayList<>();
        char[] line = new char[plate.length];
        for (int[] ints : plate) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == 0) {
                    line[i] = '.';
                } else {
                    line[i] = 'Q';
                }
            }
            lines.add(new String(line));
        }
        res.add(lines);
    }

    boolean isValid(int[] pos, int[][] plate) {
        int n = plate.length;
        for (int i = 0; i < n; i++) {
            if (plate[pos[0]][i] == 1) {
                return false;
            }
            if (plate[i][pos[1]] == 1) {
                return false;
            }
        }

        int minus = pos[0] - pos[1];
        int x = 0;
        int y = 0;
        int len = 0;
        if (minus >= 0) {
            x = minus;
            len = n - minus;
        } else {
            y = -minus;
            len = n + minus;
        }
        for (int i = 0; i < len; i++, x++, y++) {
            if (plate[x][y] == 1) {
                return false;
            }
        }
        int add = pos[0] + pos[1];
        if (add <= n - 1) {
            x = 0;
            y = add;
            len = add + 1;
        } else {
            x = add - n + 1;
            y = n - 1;
            len = n - x;
        }
        for (int i = 0; i < len; i++, x++, y--) {
            if (plate[x][y] == 1) {
                return false;
            }
        }
        return true;
    }

    boolean hasNext(int[] pos, int n) {
        if (pos[0] == n - 1 && pos[1] == n - 1) {
            return false;
        }
        return true;
    }

    int[] nextPos(int[] pos, int n) {
        pos[1]++;
        if (pos[1] == n) {
            pos[0]++;
            pos[1] = 0;
        }
        return pos;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
