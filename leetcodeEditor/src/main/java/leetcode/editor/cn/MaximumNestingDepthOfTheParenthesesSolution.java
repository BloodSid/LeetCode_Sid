package leetcode.editor.cn;

import java.util.*;

/**
 * 括号的最大嵌套深度
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-07 21:11:13
 */
public class MaximumNestingDepthOfTheParenthesesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == ')') {
                depth--;
            }
        }
        return maxDepth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
