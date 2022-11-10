package leetcode.editor.cn;
//给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。 
//
// 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含
//有大写和小写字母。 
//
// 如果 a 和 b 相似，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "book"
//输出：true
//解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
// 
//
// 示例 2： 
//
// 
//输入：s = "textbook"
//输出：false
//解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
//注意，元音 o 在 b 中出现两次，记为 2 个。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 1000 
// s.length 是偶数 
// s 由 大写和小写 字母组成 
// 
// 👍 13 👎 0


/**
 * 判断字符串的两半是否相似
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-11 00:04:16 
 */
public class DetermineIfStringHalvesAreAlikeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static String vowels = "aeiouAEIOU";
    static boolean[] isVowel = new boolean[128];
    static {
        for (int i = 0; i < vowels.length(); i++) {
            isVowel[vowels.charAt(i)] = true;
        }
    }
    public boolean halvesAreAlike(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel[s.charAt(i)]) {
                if (i < s.length() / 2) left++;
                else right++;
            }
        }
        return left == right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
