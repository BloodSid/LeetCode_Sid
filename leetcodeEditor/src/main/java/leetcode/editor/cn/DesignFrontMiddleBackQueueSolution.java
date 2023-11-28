package leetcode.editor.cn;
//请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。 
//
// 请你完成 FrontMiddleBack 类： 
//
// 
// FrontMiddleBack() 初始化队列。 
// void pushFront(int val) 将 val 添加到队列的 最前面 。 
// void pushMiddle(int val) 将 val 添加到队列的 正中间 。 
// void pushBack(int val) 将 val 添加到队里的 最后面 。 
// int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// 
//
// 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说： 
//
// 
// 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。 
// 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", 
//"popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
//[[], [1], [2], [3], [4], [], [], [], [], []]
//输出：
//[null, null, null, null, null, 1, 3, 4, 2, -1]
//
//解释：
//FrontMiddleBackQueue q = new FrontMiddleBackQueue();
//q.pushFront(1);   // [1]
//q.pushBack(2);    // [1, 2]
//q.pushMiddle(3);  // [1, 3, 2]
//q.pushMiddle(4);  // [1, 4, 3, 2]
//q.popFront();     // 返回 1 -> [4, 3, 2]
//q.popMiddle();    // 返回 3 -> [4, 2]
//q.popMiddle();    // 返回 4 -> [2]
//q.popBack();      // 返回 2 -> []
//q.popFront();     // 返回 -1 -> [] （队列为空）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= val <= 10⁹ 
// 最多调用 1000 次 pushFront， pushMiddle， pushBack， popFront， popMiddle 和 popBack 。 
//
// 
//
// 👍 55 👎 0


import java.util.*;

/**
 * 设计前中后队列
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-28 11:06:16 
 */
public class DesignFrontMiddleBackQueueSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class FrontMiddleBackQueue {

    private final Deque<Integer> left;
    private final Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public boolean isEmpty() {
        return left.size() == 0 && right.size() == 0;
    }

    public void pushFront(int val) {
        left.offerFirst(val);
    }

    void rebalance(int lSize) {
        while (left.size() > lSize) {
            right.offerFirst(left.pollLast());
        }
        while (left.size() < lSize) {
            left.offerLast(right.pollFirst());
        }
    }

    public void pushMiddle(int val) {
        int lSize = (left.size() + right.size()) / 2;
        rebalance(lSize);
        left.offerLast(val);
    }
    
    public void pushBack(int val) {
        right.offerLast(val);
    }
    
    public int popFront() {
        if (isEmpty()) return -1;
        if (left.isEmpty()) return right.pollFirst();
        return left.pollFirst();
    }
    
    public int popMiddle() {
        if (isEmpty()) return -1;
        int lSize = (left.size() + right.size() + 1) / 2;
        rebalance(lSize);
        return left.pollLast();
    }
    
    public int popBack() {
        if (isEmpty()) return -1;
        if (right.isEmpty()) return left.pollLast();
        return right.pollLast();
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
