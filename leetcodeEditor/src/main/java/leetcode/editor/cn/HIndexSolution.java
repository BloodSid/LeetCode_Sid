package leetcode.editor.cn;

import java.util.*;

/**
 * H 指数
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-18 21:36:07
 */
public class HIndexSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        // 被引数i对应num[i]篇论文
        int len = citations.length + 1;
        int[] num = new int[len];
        for (int citation : citations) {
            num[citation < len ? citation : (len - 1)]++;
        }
        // 后缀和
        if (num[len - 1] >= len - 1) {
            return len -1;
        }
        for (int i = len - 2; i >= 0; i--) {
            num[i] += num[i + 1];
            if (num[i] >= i) {
                return i;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
