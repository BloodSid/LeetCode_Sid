package leetcode.editor.cn;

import java.util.*;

/**
 * 顺时针打印矩阵
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-20 17:40:14
 */
public class ShunShiZhenDaYinJuZhenLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int xMin = 0, xMax = matrix.length - 1, yMin = 0, yMax = matrix[0].length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        int direction = 0;
        while (xMin <= xMax && yMin <= yMax) {
            direction %= 4;
            if (direction == 0) {
                for (int j = yMin; j <= yMax; j++) {
                    res[index++] = matrix[xMin][j];
                }
                xMin++;
            } else if (direction == 1) {
                for (int i = xMin; i <= xMax; i++) {
                    res[index++] = matrix[i][yMax];
                }
                yMax--;
            } else if (direction == 2) {
                for (int j = yMax; j >= yMin; j--) {
                    res[index++] = matrix[xMax][j];
                }
                xMax--;
            } else {
                for (int i = xMax; i >= xMin; i--) {
                    res[index++] = matrix[i][yMin];
                }
                yMin++;
            }
            direction++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
