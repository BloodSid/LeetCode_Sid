package leetcode.editor.cn;

/**
 * 增减字符串匹配
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-09 01:47:12
 */
public class DiStringMatchSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] diStringMatch(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'D') {
                d++;
            }
        }
        int[] res = new int[n + 1];
        res[0] = d;
        for (int i1 = d - 1, i2 = d + 1, i = 0; i < n; i++) {
            if (ch[i] == 'D') {
                res[i + 1] = i1--;
            } else {
                res[i + 1] = i2++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
