package leetcode.editor.cn;

/**
 * 写字符串需要的行数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-12 23:46:56 
 */
public class NumberOfLinesToWriteStringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int last = 0;
        for (char c : s.toCharArray()) {
            if (last + widths[c - 'a'] > 100) {
                lines++;
                last = 0;
            }
            last += widths[c - 'a'];
        }
        return new int[]{lines, last};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
