package leetcode.editor.cn;

import java.util.*;

/**
 * 搜索二维矩阵 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-25 21:38:00
 */
public class SearchA2dMatrixIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
