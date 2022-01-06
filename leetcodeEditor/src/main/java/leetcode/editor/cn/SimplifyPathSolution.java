package leetcode.editor.cn;

import java.util.*;

/**
 * 简化路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-06 19:03:36
 */
public class SimplifyPathSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String simplifyPath(String path) {
        String[] piece = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : piece) {
            switch (s) {
                case ".":
                case "":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(s);
            }
        }
        if (stack.size() == 0) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = stack.descendingIterator();
        while (iterator.hasNext()) {
            sb.append('/');
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
