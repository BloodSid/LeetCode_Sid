package leetcode.editor.cn;

import java.util.*;

/**
 * 搜索二维矩阵
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-25 22:08:49
 */
public class SearchA2dMatrixSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (matrix[mid][0] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (hi < 0 || Arrays.binarySearch(matrix[hi], target) < 0) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
