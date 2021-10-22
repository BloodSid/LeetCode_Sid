package leetcode.editor.cn;

import java.util.*;

/**
 * 构造矩形
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-23 01:15:45
 */
public class ConstructTheRectangleSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructRectangle(int area) {
        for (int width = (int) Math.sqrt(area); width > 0; width--) {
            if (area % width == 0) {
                return new int[]{area / width, width};
            }
        }
        return new int[2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
