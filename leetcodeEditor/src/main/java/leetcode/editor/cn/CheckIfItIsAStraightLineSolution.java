package leetcode.editor.cn;

import java.util.*;

/**
 * 缀点成线
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-10 13:29:07
 */
public class CheckIfItIsAStraightLineSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        for (int i = 1; i < coordinates.length; i++) {
            coordinates[i][0] -= x0;
            coordinates[i][1] -= y0;
        }
        int x1_x0 = coordinates[1][0];
        int y1_y0 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            if (coordinates[i][0] * y1_y0 != coordinates[i][1] * x1_x0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
