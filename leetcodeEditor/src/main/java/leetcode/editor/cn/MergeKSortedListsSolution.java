package leetcode.editor.cn;

import java.util.*;

/**
 * 合并K个升序链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-29 12:29:56
 */
public class MergeKSortedListsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode prehead = new ListNode(-1);
        Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        ListNode cur = prehead;
        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();
            cur.next = smallest;
            if (heap.isEmpty()) {
                break;
            }
            while (smallest.next != null && smallest.next.val <= heap.peek().val) {
                smallest = smallest.next;
            }
            cur = smallest;
            if (smallest.next != null) {
                heap.offer(smallest.next);
            }
        }
        return prehead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
