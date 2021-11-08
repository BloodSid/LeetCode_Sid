package leetcode.editor.cn;

import java.util.*;

/**
 * 最长回文串
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-09 01:24:47
 */
public class LongestPalindromeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)]++;
        }
        int ans = 0;
        for (int i : cnt) {
            ans += (i >> 1) << 1;
        }
        return ans < s.length() ? ans + 1 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
