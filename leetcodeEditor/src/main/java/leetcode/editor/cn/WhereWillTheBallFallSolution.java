package leetcode.editor.cn;

import java.util.*;

/**
 * 球会落何处
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-24 15:18:07
 */
public class WhereWillTheBallFallSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = i;
            for (int j = 0; j < m; j++) {
                if (grid[j][pos] == 1 && pos < n - 1 && grid[j][pos + 1] == 1) {
                    pos++;
                } else if (grid[j][pos] == -1 && pos > 0 && grid[j][pos - 1] == -1) {
                    pos--;
                } else {
                    pos = -1;
                    break;
                }
            }
            res[i] = pos;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
