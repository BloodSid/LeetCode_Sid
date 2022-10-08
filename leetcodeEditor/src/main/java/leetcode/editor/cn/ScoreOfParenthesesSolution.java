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


import java.util.ArrayDeque;
import java.util.Deque;

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
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(0);
            else {
                Integer pop = stack.pop();
                int val = pop == 0 ? 1 : 2 * pop;
                stack.push(stack.pop() + val);
            }
        }
        return stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
