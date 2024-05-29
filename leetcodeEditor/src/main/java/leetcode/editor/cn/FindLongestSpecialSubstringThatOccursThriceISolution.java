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
// 3 <= s.length <= 50 
// s 仅由小写英文字母组成。 
// 
//
// 👍 41 👎 0


import java.util.*;

/**
 * 找出出现至少三次的最长特殊子字符串 I
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-05-29 21:44:44 
 */
public class FindLongestSpecialSubstringThatOccursThriceISolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> f = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                f.merge(s.substring(i, j), 1, Integer::sum);
            }
        }
        int max = -1;
        for (String sub : f.keySet()) {
            if (sub.length() > max && f.get(sub) >= 3 && isUnique(sub)) {
                max = sub.length();
            }
        }
        return max;
    }

    private boolean isUnique(String sub) {
        if (sub.length() <= 1) return true;
        char c = sub.charAt(0);
        for (int i = 1; i < sub.length(); i++){
            if (sub.charAt(i) != c) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
