package leetcode.editor.cn;

import java.util.*;

/**
 * 路径交叉
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-28 13:13:41
 */
public class SelfCrossingSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSelfCrossing(int[] dis) {
        for (int i = 0; i < dis.length; i++) {
            if ((i >= 3 && dis[i] >= dis[i - 2] && dis[i - 1] <= dis[i - 3])
                || (i >= 4 && dis[i - 1] == dis[i - 3] && dis[i] + dis[i - 4] >= dis[i - 2])
                || (i >= 5 && dis[i - 2] > dis[i - 4] && dis[i] + dis[i - 4] >= dis[i - 2]
                    && dis[i - 3] > dis[i - 5] && dis[i - 1] + dis[i - 5] >= dis[i - 3] && dis[i - 3] >= dis[i - 1])) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
