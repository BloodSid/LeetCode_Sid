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
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        char[][] ch = new char[n][];
        for (int i = 0; i < n; i++) {
            ch[i] = strs[i].toCharArray();
        }
        int max = -1;
        // 如果 str 的一个子序列是“特殊序列”，那 str 也是“特殊序列”，所以检查所有的 str 是不是其他 str 的子序列即可
        for (int i = 0; i < n; i++) {
            int j = 0;
            if (ch[i].length <= max) continue;
            for (; j < n; j++) {
                if (i == j) continue;
                if (isSubseq(ch[i], ch[j])) break;
            }
            if (j == n) max = ch[i].length;
        }
        return max;
    }

    boolean isSubseq(char[] c1, char[] c2) {
        int p1 = 0, p2 = 0;
        for (; p1 < c1.length && p2 < c2.length; p2++) {
            if (c1[p1] == c2[p2]) {
                p1++;
            }
        }
        return p1 == c1.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
