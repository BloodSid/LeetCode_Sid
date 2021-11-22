package leetcode.editor.cn;

import java.util.*;

/**
 * 找到小镇的法官
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-22 14:22:46 
 */
public class FindTheTownJudgeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] edge : trust) {
            out[edge[0]]++;
            in[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
