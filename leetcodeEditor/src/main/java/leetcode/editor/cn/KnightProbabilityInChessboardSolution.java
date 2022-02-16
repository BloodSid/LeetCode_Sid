package leetcode.editor.cn;

import java.util.*;

/**
 * 骑士在棋盘上的概率
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-17 00:17:01
 */
public class KnightProbabilityInChessboardSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    int[][] dirs = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
    HashMap<Integer, Double> keyToP = new HashMap<>();

    public double knightProbability(int n, int k, int row, int column) {
        this.n = n;
        return p(k, row, column);
    }

    double p(int k, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        int key = (k << 16) + (row << 8) + col;
        if (keyToP.containsKey(key)) {
            return keyToP.get(key);
        }
        double sum = 0;
        for (int[] dir : dirs) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            sum += p(k - 1, nRow, nCol);
        }
        sum /= 8.0;
        keyToP.put(key, sum);
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
