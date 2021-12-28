package leetcode.editor.cn;

import java.util.*;

/**
 * 用两个栈实现队列
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-28 15:37:53
 */
public class YongLiangGeZhanShiXianDuiLieLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
    Deque<Integer> a = new ArrayDeque<>();
    Deque<Integer> b = new ArrayDeque<>();

    public void appendTail(int value) {
        a.push(value);
    }

    public int deleteHead() {
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.isEmpty() ? -1 : b.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
