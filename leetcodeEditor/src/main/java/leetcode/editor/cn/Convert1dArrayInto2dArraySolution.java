package leetcode.editor.cn;

import java.util.*;

/**
 * 将一维数组转变成二维数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-01 19:58:48
 */
public class Convert1dArrayInto2dArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[n * i + j];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
