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
        // 根据每一行的首尾元素缩小搜索范围
        int lowerLimit = 0;
        for (; lowerLimit < m && matrix[lowerLimit][n - 1] < target; lowerLimit++) {
        }
        int higherLimit = m - 1;
        for (; higherLimit >= lowerLimit && matrix[higherLimit][0] > target; higherLimit--) {
        }
        int toIndex = n;
        for (int i = lowerLimit; i <= higherLimit; i++) {
            int index = Arrays.binarySearch(matrix[i], 0, toIndex, target);
            if (index >= 0) {
                return true;
            } else {
                // 该行第一个比target大的元素的下标
                toIndex = -index - 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
