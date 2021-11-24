package leetcode.editor.cn;

import java.util.*;

/**
 * 可怜的小猪
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-25 00:06:03
 */
public class PoorPigsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
