package leetcode.editor.cn;

import java.util.*;

/**
 * 用栈实现队列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-04 16:45:39
 */
public class ImplementQueueUsingStacksSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int head = peek();
        stack2.pop();
        return head;
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
