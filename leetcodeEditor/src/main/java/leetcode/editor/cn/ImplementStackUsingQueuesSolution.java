package leetcode.editor.cn;

import java.util.*;

/**
 * 用队列实现栈
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-05 23:30:43 
 */
public class ImplementStackUsingQueuesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {

    private final Deque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue.offer(x);
        int n = queue.size();
        for (int i = 0; i < n - 1; i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
