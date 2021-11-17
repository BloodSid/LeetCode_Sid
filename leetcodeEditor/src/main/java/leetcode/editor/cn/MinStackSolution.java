package leetcode.editor.cn;

import java.util.*;

/**
 * 最小栈
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-17 01:01:29
 */
public class MinStackSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.offerLast(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.offerLast(val);
        minStack.offerLast(Math.min(minStack.peekLast(), val));
    }

    public void pop() {
        stack.pollLast();
        minStack.pollLast();
    }

    public int top() {
        minStack.peekLast();
        return stack.peekLast();
    }

    public int getMin() {
        return minStack.peekLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
