package leetcode.editor.cn;

import java.util.*;

/**
 * 有效的括号
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-21 23:46:46
 */
public class ValidParenthesesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (stack.isEmpty() || stack.pollFirst() != '(') {
                    return false;
                }
            } else if (ch == '}') {
                if (stack.isEmpty() || stack.pollFirst() != '{') {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pollFirst() != '[') {
                    return false;
                }
            } else {
                stack.offerFirst(ch);
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
