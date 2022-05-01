package leetcode.editor.cn;

import java.util.*;

/**
 * 字符串的总引力
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-01 12:53:45 
 */
public class TotalAppealOfAStringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long appealSum(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = (i > 0 ? dp[i - 1] : 0) + i - pos[ch[i] - 'a'];
            pos[ch[i] - 'a'] = i;
        }
        long sum = 0;
        for (long l : dp) {
            sum += l;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
