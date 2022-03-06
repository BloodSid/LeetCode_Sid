package leetcode.editor.cn;

import linkedList.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-15 02:15:14
 */
public class SwapNodesInPairsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
