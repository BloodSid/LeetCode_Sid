package leetcode.editor.cn;
//给你两个字符串 s 和 t ，请你找出 s 中的非空子串的数目，这些子串满足替换 一个不同字符 以后，是 t 串的子串。换言之，请你找到 s 和 t 串中 
//恰好 只有一个字符不同的子字符串对的数目。 
//
// 比方说， "computer" and "computation" 只有一个字符不同： 'e'/'a' ，所以这一对子字符串会给答案加 1 。 
//
// 请你返回满足上述条件的不同子字符串对数目。 
//
// 一个 子字符串 是一个字符串中连续的字符。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aba", t = "baba"
//输出：6
//解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//("aba", "baba")
//加粗部分分别表示 s 和 t 串选出来的子字符串。
// 
//示例 2：
//
// 
//输入：s = "ab", t = "bb"
//输出：3
//解释：以下为只相差 1 个字符的 s 和 t 串的子字符串对：
//("ab", "bb")
//("ab", "bb")
//("ab", "bb")
//加粗部分分别表示 s 和 t 串选出来的子字符串。
// 
//示例 3：
//
// 
//输入：s = "a", t = "a"
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：s = "abe", t = "bbc"
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 100 
// s 和 t 都只包含小写英文字母。 
// 
// 👍 56 👎 0


import java.util.*;

/**
 * 统计只差一个字符的子串数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-27 00:26:47 
 */
public class CountSubstringsThatDifferByOneCharacterSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s, String t) {
        int n = t.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = t.substring(i, j);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        int cnt = 0;
        n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                for (int k = 0; k < sub.length(); k++) {
                    char cur = sub.charAt(k);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (cur == c) continue;
                        cnt += map.getOrDefault(sub.substring(0, k) + c + sub.substring(k + 1), 0);
                    }
                }
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
