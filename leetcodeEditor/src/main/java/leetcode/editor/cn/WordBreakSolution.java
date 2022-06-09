package leetcode.editor.cn;
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
// 👍 1637 👎 0


import java.util.*;

/**
 * 单词拆分
 *
 * @author IronSid
 * @since 2022-06-09 23:00:50 
 * @version 1.0
 */
public class WordBreakSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (!dp[j]) continue;
                if (set.contains(new String(ch, j, i - j))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
