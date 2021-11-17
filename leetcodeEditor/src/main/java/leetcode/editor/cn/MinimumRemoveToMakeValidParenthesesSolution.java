package leetcode.editor.cn;

import java.util.*;

/**
 * 移除无效的括号
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-17 01:00:52
 */
public class MinimumRemoveToMakeValidParenthesesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.length());
                sb.append(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
