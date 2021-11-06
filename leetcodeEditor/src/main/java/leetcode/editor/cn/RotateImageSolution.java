package leetcode.editor.cn;

import java.util.*;

/**
 * 旋转图像
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-06 12:05:32
 */
public class RotateImageSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n + 1 >> 1; i++) {
            for (int j = 0; j < n >> 1; j++) {
                int[][] pos = new int[4][];
                pos[0] = new int[]{i, j};
                pos[1] = new int[]{n - 1 - j, i};
                pos[2] = new int[]{n - 1 - i, n - 1 - j};
                pos[3] = new int[]{j, n - 1 - i};
                int temp = matrix[pos[0][0]][pos[0][1]];
                for (int k = 0; k < 3; k++) {
                    matrix[pos[k][0]][pos[k][1]] = matrix[pos[k + 1][0]][pos[k + 1][1]];
                }
                matrix[pos[3][0]][pos[3][1]] = temp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
