package leetcode.editor.cn;

/**
 * 检测大写字母
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-13 12:03:15
 */
public class DetectCapitalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n < 2) {
            return true;
        }
        char[] ch = word.toCharArray();
        // 前两个字母可以是大大、大小、小小、不能是小大
        if ((ch[0] & ~ch[1] & 32) != 0) {
            return false;
        }
        // 后续字母必须与第二个字母形式相同
        for (int i = 2; i < n; i++) {
            if ((ch[1] & 32) != (ch[i] & 32)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
