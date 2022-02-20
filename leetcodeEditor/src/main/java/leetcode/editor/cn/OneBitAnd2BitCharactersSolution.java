package leetcode.editor.cn;

import java.util.*;

/**
 * 1比特与2比特字符
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-20 21:54:45
 */
public class OneBitAnd2BitCharactersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            if (bits[i - 1] == 0) {
                dp[i] |= dp[i - 1];
            }
            if (i >= 2 && bits[i - 2] == 1) {
                dp[i] |= dp[i - 2];
            }
        }
        if (n >= 2 && dp[n - 2] && bits[n - 2] == 1) {
            return false;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
