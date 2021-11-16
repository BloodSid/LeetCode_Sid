package leetcode.editor.cn;

import java.util.*;

/**
 * 重排链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-16 00:45:16
 */
public class ReorderListSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> queue = new ArrayDeque<>();
        ListNode p = head.next;
        while (p != null) {
            queue.offerLast(p);
            p = p.next;
        }
        p = head;
        while (!queue.isEmpty()) {
            p.next = queue.pollLast();
            p = p.next;
            if (!queue.isEmpty()) {
                p.next = queue.pollFirst();
                p = p.next;
            }
        }
        p.next = null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
