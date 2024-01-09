package leetcode.editor.cn;
//给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在 
//dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。 
//
// 请你采取最优策略分割 s ，使剩下的字符 最少 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
//输出：1
//解释：将 s 分成两个子字符串：下标从 0 到 3 的 "leet" 和下标从 5 到 8 的 "code" 。只有 1 个字符没有使用（下标为 4），所以
//我们返回 1 。
// 
//
// 示例 2： 
//
// 输入：s = "sayhelloworld", dictionary = ["hello","world"]
//输出：3
//解释：将 s 分成两个子字符串：下标从 3 到 7 的 "hello" 和下标从 8 到 12 的 "world" 。下标为 0 ，1 和 2 的字符没有使
//用，所以我们返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 50 
// 1 <= dictionary.length <= 50 
// 1 <= dictionary[i].length <= 50 
// dictionary[i] 和 s 只包含小写英文字母。 
// dictionary 中的单词互不相同。 
// 
//
// 👍 59 👎 0


import java.util.Arrays;

/**
 * 字符串中的额外字符
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-01-09 11:08:02 
 */
public class ExtraCharactersInAStringSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int n;
    private String[] dictionary;
    private int[] dp;

    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        this.dictionary = dictionary;
        // dp[i] 表示 s[i,n) 的最小额外字符数
        dp = new int[n];
        Arrays.fill(dp, -1);
        dfs(s, 0);
        return dp[0];
    }

    int dfs(String s, int i) {
        if (i == n) {
            // 递归终点空字符串
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        // 当前字符不匹配
        int res = dfs(s, i + 1) + 1;
        // 遍历所有单词，判断是否匹配
        for (String word : dictionary) {
            if (s.startsWith(word, i)) {
                // 若匹配，则更新额外字符数的最小值
                res = Math.min(res, dfs(s, i + word.length()));
            }
        }
        return dp[i] = res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
