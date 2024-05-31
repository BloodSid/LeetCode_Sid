package leetcode.editor.cn;
//给你一个仅由小写英文字母组成的字符串 s 。 
//
// 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字
//符串。 
//
// 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。 
//
// 子字符串 是字符串中的一个连续 非空 字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaaa"
//输出：2
//解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
//可以证明最大长度是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcdef"
//输出：-1
//解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
// 
//
// 示例 3： 
//
// 
//输入：s = "abcaba"
//输出：1
//解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
//可以证明最大长度是 1 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 5 * 10⁵ 
// s 仅由小写英文字母组成。 
// 
//
// 👍 28 👎 0


/**
 * 找出出现至少三次的最长特殊子字符串 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-05-31 22:43:40 
 */
public class FindLongestSpecialSubstringThatOccursThriceIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private char[] c;
    private int n;

    public int maximumLength(String s) {
        n = s.length();
        c = s.toCharArray();
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + r >> 1;
            // 检查mid长度的特殊字符串是否足够
            if (check(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r != 0 ? r : -1;
    }

    boolean check(int len) {
        char t = 0;
        // 检查由对应字符组成的特殊字符串的出现次数
        int[] f = new int[26];
        int dp = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] != t) {
                dp = 1;
                t = c[i];
            } else {
                dp++;
            }
            if (dp >= len) {
                f[c[i]-'a']++;
            }
            if (f[c[i]-'a'] == 3) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
