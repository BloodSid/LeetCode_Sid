package leetcode.editor.cn;

import java.util.*;

/**
 * 螺旋矩阵 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-06 14:16:40
 */
public class SpiralMatrixIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int xMin = 0, yMin = 0;
        int xMax = result[0].length - 1, yMax = result.length - 1;
        int tem = 1;
        while (xMax >= xMin) {
            for (int i = yMin; i <= yMax; i++) {
                result[xMin][i] = tem;
                tem++;
            }
            xMin++;

            for (int i = xMin; i <= xMax; i++) {
                result[i][yMax] = tem;
                tem++;
            }
            yMax--;

            for (int i = yMax; i >= yMin; i--) {
                result[xMax][i] = tem;
                tem++;
            }
            xMax--;

            for (int i = xMax; i >= xMin; i--) {
                result[i][yMin] = tem;
                tem++;
            }
            yMin++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
