package leetcode.editor.cn;

import java.util.*;

/**
 * 最多可达成的换楼请求数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-28 16:45:29
 */
public class MaximumNumberOfAchievableTransferRequestsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        // 能否用图论找环的方式去做？如果遇到“日”字形状的图可能比较难处理
        int max = 0;
        int len = requests.length;
        for (int status = (1 << len) - 1; status > 0; status--) {
            if (Integer.bitCount(status) <= max) {
                continue;
            }
            int[] cnt = new int[n];
            for (int i = 0; i < len; i++) {
                if (((status >> i) & 1) == 1) {
                    cnt[requests[i][0]]++;
                    cnt[requests[i][1]]--;
                }
            }
            int idx = 0;
            for (; idx < n; idx++) {
                if (cnt[idx] != 0) {
                    break;
                }
            }
            if (idx == n) {
                max = Integer.bitCount(status);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
