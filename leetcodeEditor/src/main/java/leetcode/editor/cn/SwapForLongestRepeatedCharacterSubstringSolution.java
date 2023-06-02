package leetcode.editor.cn;
//如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。 
//
// 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。 
//
// 
//
// 示例 1： 
//
// 输入：text = "ababa"
//输出：3
// 
//
// 示例 2： 
//
// 输入：text = "aaabaaa"
//输出：6
// 
//
// 示例 3： 
//
// 输入：text = "aaabbaaa"
//输出：4
// 
//
// 示例 4： 
//
// 输入：text = "aaaaa"
//输出：5
// 
//
// 示例 5： 
//
// 输入：text = "abcdef"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 20000 
// text 仅由小写英文字母组成。 
// 
//
// 👍 111 👎 0


/**
 * 单字符重复子串的最大长度
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-06-03 00:26:50 
 */
public class SwapForLongestRepeatedCharacterSubstringSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxRepOpt1(String text) {
        char[] ch = text.toCharArray();
        int n = ch.length;
        int[] suf = new int[n];
        int[] f = new int[128];
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || ch[i + 1] != ch[i]) {
                suf[i] = 1;
            } else {
                suf[i] = suf[i + 1] + 1;
            }
            max = Math.max(max, suf[i]);
            f[ch[i]]++;
        }
        for (int i = 1, t = 1; i < n - 1; i++) {
            max = Math.max(max, Math.min(t + 1, f[ch[i - 1]]));
            max = Math.max(max, Math.min(suf[i + 1] + 1, f[ch[i + 1]]));
            if (ch[i - 1] == ch[i + 1]) {
                max = Math.max(max, Math.min(t + suf[i + 1] + 1, f[ch[i + 1]]));
            }
            if (ch[i - 1] == ch[i]) t++;
            else t = 1;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
