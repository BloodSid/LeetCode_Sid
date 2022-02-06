package leetcode.editor.cn;

import java.util.*;

/**
 * 最长快乐字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-07 00:49:38
 */
public class LongestHappyStringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[][] cnts = {{'a', a}, {'b', b}, {'c', c}};
        StringBuilder sb = new StringBuilder();
        while (true) {
            Arrays.sort(cnts, (o1, o2) -> o2[1] - o1[1]);
            int len = sb.length();
            for (int[] cnt : cnts) {
                if (cnt[1] == 0) {
                    break;
                }
                if (len >= 2 && sb.charAt(len - 1) == cnt[0] && sb.charAt(len - 2) == cnt[0]) {
                    continue;
                }
                sb.append((char) cnt[0]);
                cnt[1]--;
                break;
            }
            if (len == sb.length()) {
                return sb.toString();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
