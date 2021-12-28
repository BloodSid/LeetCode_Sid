package leetcode.editor.cn;

import java.util.*;

/**
 * 包含min函数的栈
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-28 15:38:03
 */
public class BaoHanMinhanShuDeZhanLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        int min = x;
        if (!minStack.isEmpty()) {
            min = Math.min(min, minStack.peek());
        }
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
