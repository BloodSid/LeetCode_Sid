package leetcode.editor.cn;

import java.util.*;

/**
 * 字符的最短距离
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:05:30
 */
public class ShortestDistanceToACharacterSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        int i = 0;
        for (; i < n; i++) if (ch[i] == c) break;
        for (int t = 0; i < n; i++) {
            if (ch[i] == c) t = 0;
            else t++;
            res[i] = t;
        }
        i = n - 1;
        for (; i >= 0; i--) if (ch[i] == c) break;
        for (int t = 0; i >= 0; i--) {
            if (ch[i] == c) t = 0;
            else t++;
            if (res[i] == -1 || res[i] > t) {
                res[i] = t;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
