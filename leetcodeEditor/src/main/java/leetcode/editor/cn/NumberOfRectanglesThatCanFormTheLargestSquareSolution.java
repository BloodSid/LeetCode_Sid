package leetcode.editor.cn;

import java.util.*;

/**
 * 可以形成最大正方形的矩形数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-04 00:04:19
 */
public class NumberOfRectanglesThatCanFormTheLargestSquareSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int cnt = 0;
        for (int[] rectangle : rectangles) {
            int len = Math.min(rectangle[0], rectangle[1]);
            if (len > maxLen) {
                maxLen = len;
                cnt = 1;
            } else if (len == maxLen) {
                cnt++;
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
