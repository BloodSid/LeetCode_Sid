package leetcode.editor.cn;

/**
 * 一次编辑
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-13 00:03:11
 */
public class OneAwayLcciSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String shorter, String longer) {
        if (shorter.length() > longer.length()) return oneEditAway(longer, shorter);
        int diff = longer.length() - shorter.length();
        if (diff > 1) return false;
        int edit = 0;
        char[] ch1 = shorter.toCharArray(), ch2 = longer.toCharArray();
        for (int i1 = 0, i2 = 0; i1 < ch1.length; ) {
            if (ch1[i1] == ch2[i2]) {
                i1++;
                i2++;
            } else {
                if (edit == 1) return false;
                edit++;
                // diff 为 1 的时候不变，diff 为 0 的时候加一
                i1 += diff ^ 1;
                i2++;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
