package leetcode.editor.cn;

import java.util.*;

/**
 * 二维数组中的查找
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-31 21:12:18
 */
public class ErWeiShuZuZhongDeChaZhaoLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
