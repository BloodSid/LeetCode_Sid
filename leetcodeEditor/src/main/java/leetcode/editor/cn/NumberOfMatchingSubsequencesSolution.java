package leetcode.editor.cn;
//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
// 👍 229 👎 0


import java.util.*;

/**
 * 匹配子序列的单词数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-17 00:06:45 
 */
public class NumberOfMatchingSubsequencesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] next = new int[n + 1][];
        int[] t = new int[26];
        Arrays.fill(t, -1);
        for (int i = n - 1; i >= 0; i--) {
            next[i] = t.clone();
            t[ch[i] - 'a'] = i;
        }
        int cnt = 0;
        for (String word : words) {
            char[] w = word.toCharArray();
            int len = w.length;
            int p = t[w[0] - 'a'];
            int i = 1;
            while (p != -1 && i < len) {
                p = next[p][w[i] - 'a'];
                i++;
            }
            if (p != -1) {
                cnt++;
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
