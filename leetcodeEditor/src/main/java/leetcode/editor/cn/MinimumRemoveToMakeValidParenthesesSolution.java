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
        int left = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
                balance++;
                sb.append(ch);
            } else if (ch == ')') {
                if (balance > 0) {
                    balance--;
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        if (balance == 0) {
            return sb.toString();
        }
        StringBuilder result = new StringBuilder();
        // 总左括号数减要删除的左括号数
        int remain = left - balance;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '(') {
                if (remain > 0) {
                    remain--;
                    result.append(ch);
                }
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
