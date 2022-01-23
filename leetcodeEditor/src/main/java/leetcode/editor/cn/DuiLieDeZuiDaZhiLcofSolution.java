package leetcode.editor.cn;

import java.util.*;

/**
 * 队列的最大值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-23 13:14:08
 */
public class DuiLieDeZuiDaZhiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        // 从队头到队尾的元素单调递减
        while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) {
            maxQueue.pollLast();
        }
        maxQueue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int front = queue.poll();
        if (front == maxQueue.peekFirst()) {
            maxQueue.pollFirst();
        }
        return front;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
