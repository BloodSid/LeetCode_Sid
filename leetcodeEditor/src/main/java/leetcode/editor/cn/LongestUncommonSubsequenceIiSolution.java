package leetcode.editor.cn;
//给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。 
//
// 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。 
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。 
//
// 
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括
//"aebdc"、 "aeb" 和 "" (空字符串)。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: strs = ["aba","cdc","eae"]
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= strs.length <= 50 
// 1 <= strs[i].length <= 10 
// strs[i] 只包含小写英文字母 
// 
// 👍 97 👎 0


import java.util.HashSet;

/**
 * 最长特殊序列 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-27 00:57:59 
 */
public class LongestUncommonSubsequenceIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashSet<String> sub;
    private HashSet<String> dup;
    private StringBuilder sb;

    public int findLUSlength(String[] strs) {
        int len = 0;
        boolean unique = false;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() > len) {
                len = strs[i].length();
                unique = true;
            } else if (strs[i].length() == len) {
                unique = false;
            }
        }
        if (unique) return len;
        sub = new HashSet<>();
        dup = new HashSet<>();
        sb = new StringBuilder();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            sb.setLength(0);
            dfs(0, ch);
        }
        int max = -1;
        for (String s : sub) {
            if (s.length() <= max) continue;
            if (!dup.contains(s)) max = s.length();
        }
        return max;
    }

    void dfs(int i, char[] ch) {
        if (i == ch.length) {
            String s = sb.toString();
            if (!sub.add(s)) dup.add(s);
            return;
        }
        dfs(i + 1, ch);
        sb.append(ch[i]);
        dfs(i + 1, ch);
        sb.setLength(sb.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
