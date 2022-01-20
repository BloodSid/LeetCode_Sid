package leetcode.editor.cn;

import java.util.*;

/**
 * 栈的压入、弹出序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-20 17:38:49
 */
public class ZhanDeYaRuDanChuXuLieLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        // popped的索引
        int p1 = 0;
        for (int e : pushed) {
            stack.push(e);
            while (!stack.isEmpty() && stack.peek() == popped[p1]) {
                stack.pop();
                p1++;
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
