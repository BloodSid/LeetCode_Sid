package leetcode.editor.cn;
//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
// 👍 316 👎 0


/**
 * 括号的分数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-09 00:03:13 
 */
public class ScoreOfParenthesesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String s) {
        if (s.length() == 2) return 1;
        int stack = 0;
        int score = 0;
        char[] ch = s.toCharArray();
        int start = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == '(') stack++;
            else stack--;
            if (stack == 0) {
                score += scoreOfParentheses(s.substring(start, i + 1));
                start = i + 1;
            }
        }
        // 到结尾时判断是 AB 还是 (A)
        if (score == 0) return scoreOfParentheses(s.substring(1, s.length() - 1)) * 2;
        score += scoreOfParentheses(s.substring(start));
        return score;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
