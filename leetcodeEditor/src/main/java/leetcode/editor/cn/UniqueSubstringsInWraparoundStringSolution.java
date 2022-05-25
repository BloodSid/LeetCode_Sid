package leetcode.editor.cn;
//把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的： 
//
// 
// "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
// 
//
// 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
//
// 
//
// 示例 1: 
//
// 
//输入: p = "a"
//输出: 1
//解释: 字符串 s 中只有一个"a"子字符。
// 
//
// 示例 2: 
//
// 
//输入: p = "cac"
//输出: 2
//解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
// 
//
// 示例 3: 
//
// 
//输入: p = "zab"
//输出: 6
//解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= p.length <= 10⁵ 
// p 由小写英文字母构成 
// 
// 👍 301 👎 0


/**
 * 环绕字符串中唯一的子字符串
 *
 * @author IronSid
 * @since 2022-05-25 21:10:53 
 * @version 1.0
 */
public class UniqueSubstringsInWraparoundStringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] list = new int[26];
        int n = p.length();
        char[] c = p.toCharArray();
        list[c[0] - 'a']++;
        for (int i = 1, len = 1; i < n; i++) {
            if (((c[i] == c[i - 1] + 1) || (c[i] == 'a' && c[i - 1] == 'z'))) {
                len++;
            } else {
                len = 1;
            }
            list[c[i] - 'a'] = Math.max(list[c[i] - 'a'], len);
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += list[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
